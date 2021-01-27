package xyz.tpvillage.mapper;

import xyz.tpvillage.entity.TableRecord;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 数据表记录表。该表记录了该数据库中包含数据主表，便于其他操作 Mapper 接口
 * </p>
 *
 * @author mybatis-plus-generator
 * @since 2021-01-28
 */
@Mapper
public interface TableRecordMapper extends BaseMapper<TableRecord> {

        }
