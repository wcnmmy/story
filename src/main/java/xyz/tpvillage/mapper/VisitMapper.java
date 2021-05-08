package xyz.tpvillage.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import xyz.tpvillage.entity.Visit;

/**
 * 访问记录 Mapper
 * @author: 朱兴平
 * @date: 2021/5/8
 */
@Mapper
public interface VisitMapper extends BaseMapper<Visit> {
}
