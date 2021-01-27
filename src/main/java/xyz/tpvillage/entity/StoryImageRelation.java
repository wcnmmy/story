package xyz.tpvillage.entity;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 故事-图片关系表
 * </p>
 *
 * @author mybatis-plus-generator
 * @since 2021-01-28
 */
@Data
  @EqualsAndHashCode(callSuper = false)
  @Accessors(chain = true)
public class StoryImageRelation implements Serializable {

    private static final long serialVersionUID=1L;

      /**
     * 故事图片关系表
     */
        private String id;

      /**
     * 故事编号
     */
      private String storyId;

      /**
     * 图片编号
     */
      private String imageId;


}
