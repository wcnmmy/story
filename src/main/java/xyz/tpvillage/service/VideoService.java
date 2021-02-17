package xyz.tpvillage.service;

import xyz.tpvillage.entity.Video;
import com.baomidou.mybatisplus.extension.service.IService;
import xyz.tpvillage.entity.form.VideoForm;

import java.io.IOException;
import java.util.List;

/**
 * <p>
 * 视频主表 服务类
 * </p>
 *
 * @author mybatis-plus-generator
 * @since 2021-01-28
 */
public interface VideoService extends IService<Video> {

    /**
     * 根据视频文件保存
     * @param videoForm
     * @return
     * @exception
     */
    Video saveFromVideoForm(VideoForm videoForm) throws IOException;

    /**
     *
     * @param current
     * @param size
     * @return
     */
    List<Video> selectPage(Integer current, Integer size);
}
