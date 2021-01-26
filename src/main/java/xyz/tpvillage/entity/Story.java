package xyz.tpvillage.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author: 朱兴平
 * @date: 2021/1/24
 */
@TableName("student")
@Data
public class Story {
    /**
     * 编号
     */
    @TableId
    private String id;

    /**
     * 名字
     */
    private String name;

    /**
     * 头像地址
     */
    private String headIcon;

    /**
     * 座右铭
     */
    private String motto;

    /**
     * 爱好
     */
    private String hobby;

    /**
     * 梦想
     */
    private String dream;

    /**
     * 崇拜的人
     */
    private String idolize;

    /**
     * 名字对应的汉语拼音
     */
    private String pinyin;
}
