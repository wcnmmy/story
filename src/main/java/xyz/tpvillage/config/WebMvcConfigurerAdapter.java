package xyz.tpvillage.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: 朱兴平
 * @date: 2021/1/28
 */
@Component
public class WebMvcConfigurerAdapter implements WebMvcConfigurer {

    @Autowired()
    ThymeleafViewResolver thymeleafViewResolver;

    /**
     * 静态资源全局变量
     */
    @Value("http://192.168.43.233/tpvillage/story/")
    private String staticPath;

    @Override
    public void configureViewResolvers(ViewResolverRegistry registry){
        /*
         * 为thymeleaf 定义static变量，在页面中访问静态资源时方便操作
         */
        if (thymeleafViewResolver != null) {
            Map<String, Object> vars = new HashMap<>(1);
            vars.put("static", staticPath);
            thymeleafViewResolver.setStaticVariables(vars);
        }
        WebMvcConfigurer.super.configureViewResolvers(registry);
    }
}
