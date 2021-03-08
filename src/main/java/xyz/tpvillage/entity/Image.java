package xyz.tpvillage.entity;

import java.time.LocalDateTime;
import java.io.Serializable;

import cn.hutool.core.util.IdUtil;
import com.baomidou.mybatisplus.annotation.TableField;
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
      @TableField("`create`")
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

    /**
     * 图片url
     */
    private String url;

    /**
     * 图片缩略图url
     */
    private String icon;


  /**
   * 初始化
   * @return
   */
  public static Image initialize(){
        Image image = new Image();
        image.setId(IdUtil.simpleUUID());
        image.setCreate(LocalDateTime.now());
        image.setDownload(0);
        image.setSee(0);
        image.setName(null);
        image.setHeight(0);
        image.setWidth(0);
        image.setType(null);
        image.setSize(0L);
        return image;
      }

}
