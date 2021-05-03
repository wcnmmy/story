package xyz.tpvillage.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 路径变量
 * @author: 朱兴平
 * @date: 2021/5/2
 */
@RestController
@RequestMapping("/path")
public class PathController {

    /**
     * 根路径
     * @return
     */
    @GetMapping("/root")
    public String root(){
        return "";
    }

}
