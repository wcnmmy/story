package xyz.tpvillage.entity;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 留言主表
 * </p>
 *
 * @author mybatis-plus-generator
 * @since 2021-01-28
 */
@Data
  @EqualsAndHashCode(callSuper = false)
  @Accessors(chain = true)
public class Message implements Serializable {

    private static final long serialVersionUID=1L;

      /**
     * 留言编号
     */
        private String id;

      /**
     * 留言标题
     */
      private String title;

      /**
     * 留言内容
     */
      private String content;

      /**
     * 观察次数
     */
      private Integer see;

  /**
   * 留言者
   */
  private String user;

}
