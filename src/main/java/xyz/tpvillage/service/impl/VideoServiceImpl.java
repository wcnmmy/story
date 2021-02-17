package xyz.tpvillage.service.impl;

import cn.hutool.core.util.IdUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.web.multipart.MultipartFile;
import xyz.tpvillage.entity.Video;
import xyz.tpvillage.entity.form.VideoForm;
import xyz.tpvillage.mapper.VideoMapper;
import xyz.tpvillage.service.VideoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import xyz.tpvillage.util.OSSUtil;
import xyz.tpvillage.util.VideoUtil;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * <p>
 * 视频主表 服务实现类
 * </p>
 *
 * @author mybatis-plus-generator
 * @since 2021-01-28
 */
@Service
public class VideoServiceImpl extends ServiceImpl<VideoMapper, Video> implements VideoService {

    @Override
    public Video saveFromVideoForm(VideoForm videoForm) throws IOException {
        /**
         * 获取文件信息
         */
        String name = videoForm.getName();
        String describe = videoForm.getDescribe();
        MultipartFile multipartFile = videoForm.getVideoFile();

        /**
         * 获取视频时长
         */
        Long length = VideoUtil.getVideoDuration(multipartFile.getInputStream());

        /**
         * 上传文件至OSS服务
         */
        String originalFilename = multipartFile.getOriginalFilename();
        String videoUrl = "story/video/"+originalFilename;
        InputStream inputStream = multipartFile.getInputStream();
        OSSUtil.upload(videoUrl,inputStream);

        /**
         * 获取封面信息并上传志OSS服务
         */
        String coverUrl = "story/video/cover/"+originalFilename.substring(0,originalFilename.lastIndexOf('.'))+".jpg";
        InputStream coverFileInputStream = VideoUtil.getVideoPic(multipartFile.getInputStream());
        OSSUtil.upload(coverUrl,coverFileInputStream);

        /**
         * 关闭输入流
         */
        inputStream.close();

        /**
         * 构建对象并保存
         */
        Video video = new Video();
        video.setUrl("http://tpvillage.oss-cn-chengdu.aliyuncs.com/"+videoUrl);
        video.setDescribe(videoForm.getDescribe());
        video.setId(IdUtil.simpleUUID());
        video.setName(videoForm.getName());
        video.setSize(multipartFile.getSize());
        video.setLength(length);
        video.setCover("http://tpvillage.oss-cn-chengdu.aliyuncs.com/"+coverUrl);
        video.setDownload(0);
        video.setPlay(0);
        video.setSee(0);
        save(video);
        return video;
    }

    @Override
    public List<Video> selectPage(Integer current, Integer size) {
        IPage<Video> iPage = new Page<>(current,size);
        return baseMapper.selectPage(iPage,null).getRecords();
    }
}
