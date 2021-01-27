package xyz.tpvillage.entity;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 图片类型表
 * </p>
 *
 * @author mybatis-plus-generator
 * @since 2021-01-28
 */
@Data
  @EqualsAndHashCode(callSuper = false)
  @Accessors(chain = true)
public class ImageType implements Serializable {

    private static final long serialVersionUID=1L;

      /**
     * 图片类型编号
     */
        private String id;

      /**
     * 图片类型名称
     */
      private String name;

      /**
     * 图片类型描述
     */
      private String describe;


}
