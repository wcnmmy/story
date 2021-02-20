package xyz.tpvillage.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import xyz.tpvillage.entity.Message;
import xyz.tpvillage.mapper.MessageMapper;
import xyz.tpvillage.service.MessageService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 留言主表 服务实现类
 * </p>
 *
 * @author mybatis-plus-generator
 * @since 2021-01-28
 */
@Service
public class MessageServiceImpl extends ServiceImpl<MessageMapper, Message> implements MessageService {

    @Override
    public List<Message> selectPage(Integer current, Integer size) {
        IPage<Message> iPage = new Page<>(current,size);
        return baseMapper.selectPage(iPage,null).getRecords();
    }
}
