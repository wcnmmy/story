package xyz.tpvillage.entity;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * 访问记录实体类
 * @author: 朱兴平
 * @date: 2021/5/8
 */
@Data
public class Visit {

    /**
     * 编号
     */
    private String id;

    /**
     * 访问者的ip地址
     */
    private String ip;

    /**
     * 访问时间
     */
    private LocalDateTime time;

}
