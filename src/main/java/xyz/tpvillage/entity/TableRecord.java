package xyz.tpvillage.entity;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 数据表记录表。该表记录了该数据库中包含数据主表，便于其他操作
 * </p>
 *
 * @author mybatis-plus-generator
 * @since 2021-01-28
 */
@Data
  @EqualsAndHashCode(callSuper = false)
  @Accessors(chain = true)
public class TableRecord implements Serializable {

    private static final long serialVersionUID=1L;

      /**
     * 记录编号
     */
        private String id;

      /**
     * 数据表名称
     */
      private String tableName;

      /**
     * 数据表描述
     */
      private String tableDescribe;


}
