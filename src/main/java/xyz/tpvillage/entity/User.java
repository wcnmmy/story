package xyz.tpvillage.entity;

import cn.hutool.core.date.DateTime;
import lombok.Data;

/**
 * 用户表
 * @author: 朱兴平
 * @date: 2021/2/18
 */
@Data
public class User {

    /**
     * 用户编号
     */
    private String id;

    /**
     * 用户名称
     */
    private String name;

    /**
     * 注册时间
     */
    private DateTime register;

    /**
     * 头像地址
     */
    private String cover;

    /**
     * 相关联的故事
     */
    private String story;
}
