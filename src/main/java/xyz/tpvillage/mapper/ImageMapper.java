package xyz.tpvillage.mapper;

import xyz.tpvillage.entity.Image;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 * 图片主表 Mapper 接口
 * </p>
 *
 * @author mybatis-plus-generator
 * @since 2021-01-28
 */
@Mapper
public interface ImageMapper extends BaseMapper<Image> {

    /**
     * 通过故事编号查询图片列表
     * @param storyId
     * @return
     */
    List<Image> selectListByStory(String storyId);
}
