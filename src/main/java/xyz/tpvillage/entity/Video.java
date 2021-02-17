package xyz.tpvillage.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
* <p>
* 视频主表
* </p>
*
* @author mybatis-plus-generator
* @since 2021-01-28
*/
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Video implements Serializable {

  private static final long serialVersionUID=1L;
  /**
  * 视频编号
  */
  private String id;

  /**
  * 视频名称
  */
  @TableField("`name`")
  private String name;

  /**
   * 视频地址
   */
  private String url;

  /**
  * 视频文件大小
  */
  private Long size;

  /**
  * 视频时长
  */
  private Long length;

  /**
  * 封面图片地址
  */
  private String cover;

  /**
  * 观看次数
  */
  private Integer see;

  /**
  * 下载次数
  */
  private Integer download;

  /**
   * 视频播放量
   */
  private Integer play;

  /**
  * 视频描述
  */
  @TableField("`describe`")
  private String describe;


}
