package xyz.tpvillage.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import xyz.tpvillage.entity.Image;
import xyz.tpvillage.mapper.ImageMapper;
import xyz.tpvillage.service.ImageService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 图片主表 服务实现类
 * </p>
 *
 * @author mybatis-plus-generator
 * @since 2021-01-28
 */
@Service
public class ImageServiceImpl extends ServiceImpl<ImageMapper, Image> implements ImageService {

    @Override
    public List<Image> selectPage(Integer current, Integer size) {
        IPage<Image> iPage = new Page<>(current,size);
        return baseMapper.selectPage(iPage,null).getRecords();
    }

    @Override
    public List<Image> selectPageByType(Integer current, Integer size, String typeId) {
        IPage<Image> iPage = new Page<>(current,size);
        QueryWrapper<Image> wrapper = new QueryWrapper<>();
        wrapper.eq("type",typeId);
        return baseMapper.selectPage(iPage,wrapper).getRecords();
    }

    @Override
    public List<Image> listByStory(String storyId) {
        return baseMapper.selectListByStory(storyId);
    }
}
