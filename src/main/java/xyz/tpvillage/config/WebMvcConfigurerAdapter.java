package xyz.tpvillage.config;

import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    ThymeleafViewResolver thymeleafViewResolver;

    @Autowired
    TpvillageEnvironment environment;

    @Override
    public void configureViewResolvers(ViewResolverRegistry registry){
        /*
         * 为thymeleaf 定义static变量，在页面中访问静态资源时方便操作
         */
        if (thymeleafViewResolver != null) {
            Map<String, Object> vars = new HashMap<>(1);
            vars.put("static", environment.getTP_STATIC());
            vars.put("root", environment.getTP_ROOT());
            vars.put("logo",environment.getTP_LOGO());
            thymeleafViewResolver.setStaticVariables(vars);
        }
        WebMvcConfigurer.super.configureViewResolvers(registry);
    }
}
