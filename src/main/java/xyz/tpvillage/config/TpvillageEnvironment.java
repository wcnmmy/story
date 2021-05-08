package xyz.tpvillage.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author: 朱兴平
 * @date: 2021/5/6
 */
@Component
@ConfigurationProperties(prefix = "tpvillage")
@Data
public class TpvillageEnvironment {
    /**
     * 当前项目根路径
     */
    private String TP_ROOT;

    /**
     * 静态资源根路径
     */
    private String TP_STATIC;

    /**
     * OSS服务器根路径
     */
    private String TP_OSS;

    /**
     * log图片uri
     */
    private String TP_LOGO;
}
