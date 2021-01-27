package xyz.tpvillage.entity;

import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 图片主表
 * </p>
 *
 * @author mybatis-plus-generator
 * @since 2021-01-28
 */
@Data
  @EqualsAndHashCode(callSuper = false)
  @Accessors(chain = true)
public class Image implements Serializable {

    private static final long serialVersionUID=1L;

      /**
     * 图片编号
     */
        private String id;

      /**
     * 图片名称
     */
      private String name;

      /**
     * 图片地址
     */
      private String url;

      /**
     * 图片宽度
     */
      private Integer width;

      /**
     * 图片高度
     */
      private Integer height;

      /**
     * 文件大小
     */
      private Long size;

      /**
     * 图片创建时间
     */
      private LocalDateTime create;

      /**
     * 图片类型，与图片类型表相关联
     */
      private String type;

      /**
     * 查看次数
     */
      private Integer see;

      /**
     * 下载次数
     */
      private Integer download;


}
