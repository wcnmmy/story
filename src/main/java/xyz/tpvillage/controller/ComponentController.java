package xyz.tpvillage.controller;

import io.swagger.annotations.Api;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 组件控制器
 * @author: 朱兴平
 * @date: 2021/2/5
 */
@Controller
@RequestMapping("/component")
@Api(tags = "组件控制器",value = "这个页面只返回html代码片段")
public class ComponentController {

    @RequestMapping(method = {RequestMethod.GET,RequestMethod.POST},path = "/add-image")
    public String addImage(){
        return "component/add-image";
    }

}
