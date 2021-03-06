package xyz.tpvillage.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 故事主表
 * </p>
 *
 * @author mybatis-plus-generator
 * @since 2021-01-28
 */
@Data
  @EqualsAndHashCode(callSuper = false)
  @Accessors(chain = true)
public class Story implements Serializable {

    private static final long serialVersionUID=1L;

      /**
     * 故事编号
     */
        private String id;

      /**
     * 故事名称
     */
      @TableField("`name`")
      private String name;

      /**
     * 头像
     */
      private String icon;

      /**
     * 座右铭
     */
      private String motto;

      /**
     * 梦想
     */
      private String dream;

      /**
     * 爱好
     */
      private String hobby;

      /**
     * 崇拜的人
     */
      private String idolize;

      /**
     * 名字拼音
     */
      private String pinyin;

      /**
     * 主页
     */
      @TableField("`index`")
      private String index;


}
