package xyz.tpvillage.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import xyz.tpvillage.entity.Story;
import xyz.tpvillage.mapper.StoryMapper;
import xyz.tpvillage.service.StoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 故事主表 服务实现类
 * </p>
 *
 * @author mybatis-plus-generator
 * @since 2021-01-28
 */
@Service
public class StoryServiceImpl extends ServiceImpl<StoryMapper, Story> implements StoryService {

    @Override
    public List<Story> selectPage(Integer current, Integer size) {
        Page<Story> iPage = new Page<>(current,size);
        List<Story> storyList = baseMapper.selectPage(iPage,null).getRecords();
        System.out.println("storyList size = "+storyList.size());
        return storyList;
    }

    @Override
    public Story getByPinyin(String pinyin) {
        QueryWrapper<Story> wrapper = new QueryWrapper<>();
        wrapper.eq("pinyin",pinyin);
        return getOne(wrapper);
    }
}
