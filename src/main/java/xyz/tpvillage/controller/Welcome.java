package xyz.tpvillage.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: 朱兴平
 * @date: 2021/1/24
 */
@RestController
@RequestMapping("welcome")
public class Welcome {

    @GetMapping
    public String welcome(){
        return "Hello";
    }
}
