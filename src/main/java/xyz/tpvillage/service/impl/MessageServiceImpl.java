package xyz.tpvillage.service.impl;

import xyz.tpvillage.entity.Message;
import xyz.tpvillage.mapper.MessageMapper;
import xyz.tpvillage.service.MessageService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

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

}
