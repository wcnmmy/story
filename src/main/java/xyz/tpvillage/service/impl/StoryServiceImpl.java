package xyz.tpvillage.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import xyz.tpvillage.entity.Story;
import xyz.tpvillage.mapper.StoryMapper;
import xyz.tpvillage.service.StoryService;

import java.util.List;

/**
 * @author: 朱兴平
 * @date: 2021/1/24
 */
@Service
public class StoryServiceImpl extends ServiceImpl<StoryMapper, Story> implements StoryService {

    @Override
    public List<Story> getList() {
        return baseMapper.selectList(null);
    }
}
