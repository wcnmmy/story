package xyz.tpvillage.service;

import xyz.tpvillage.entity.Story;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 故事主表 服务类
 * </p>
 *
 * @author mybatis-plus-generator
 * @since 2021-01-28
 */
public interface StoryService extends IService<Story> {

    List<Story> selectPage(Integer current, Integer size);

    /**
     * 通过故事的拼音查找一个故事信息
     * @param pinyin
     * @return
     */
    Story getByPinyin(String pinyin);
}
