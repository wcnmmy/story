package xyz.tpvillage.service.impl;

import xyz.tpvillage.entity.TableRecord;
import xyz.tpvillage.mapper.TableRecordMapper;
import xyz.tpvillage.service.TableRecordService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 数据表记录表。该表记录了该数据库中包含数据主表，便于其他操作 服务实现类
 * </p>
 *
 * @author mybatis-plus-generator
 * @since 2021-01-28
 */
@Service
public class TableRecordServiceImpl extends ServiceImpl<TableRecordMapper, TableRecord> implements TableRecordService {

}
