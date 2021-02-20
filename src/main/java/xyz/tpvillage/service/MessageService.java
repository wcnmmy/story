package xyz.tpvillage.service;

import xyz.tpvillage.entity.Message;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 留言主表 服务类
 * </p>
 *
 * @author mybatis-plus-generator
 * @since 2021-01-28
 */
public interface MessageService extends IService<Message> {

    /**
     *
     * @param current
     * @param size
     * @return
     */
    List<Message> selectPage(Integer current, Integer size);
}
