package xyz.tpvillage.controller.page;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 工具页面跳转Controller
 * @author: 朱兴平
 * @date: 2021/5/2
 */
@Slf4j
@Controller
@RequestMapping("/utils")
public class UtilPageController {

    /**
     * 图片浏览器
     * @param index
     * @param url
     * @param model
     * @return
     */
    @GetMapping("/image-view")
    public String imageView(Integer index, String url, Model model){
        model.addAttribute("index",index);
        model.addAttribute("url",url);
        return "util/image-view";
    }

}
