package xyz.tpvillage.entity;

import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 评论表
 * </p>
 *
 * @author mybatis-plus-generator
 * @since 2021-01-28
 */
@Data
  @EqualsAndHashCode(callSuper = false)
  @Accessors(chain = true)
public class Comment implements Serializable {

    private static final long serialVersionUID=1L;

      /**
     * 该条评论的编号
     */
        private String id;

      /**
     * 该条对应的模块，这里使用的值是数据表记录表中的记录编号
     */
      private String model;

      /**
     * 评论内容
     */
      private String content;

      /**
     * 评论人
     */
      private String user;

      /**
     * 评论时间
     */
      private LocalDateTime time;

  /**
   * 用于保存某张表某条数据的编号
   */
  private String target;
}
