package xyz.tpvillage.service;

import xyz.tpvillage.entity.Image;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 图片主表 服务类
 * </p>
 *
 * @author mybatis-plus-generator
 * @since 2021-01-28
 */
public interface ImageService extends IService<Image> {

    List<Image> selectPage(Integer current, Integer size);

    /**
     * 通过故事编号查询相关故事信息
     * @param storyId
     * @return
     */
    List<Image> listByStory(String storyId);
}
