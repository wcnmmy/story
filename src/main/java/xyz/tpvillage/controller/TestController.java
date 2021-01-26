package xyz.tpvillage.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import xyz.tpvillage.entity.Story;
import xyz.tpvillage.service.StoryService;

import java.util.List;

/**
 * @author: 朱兴平
 * @date: 2021/1/24
 */
@Controller
@Slf4j
public class TestController {

    @Autowired
    StoryService storyService;

    @GetMapping("/test")
    public String test(Model model){
        List<Story> storyList = storyService.getList();
        model.addAttribute("storyList",storyList);
        return "list";
    }
    @GetMapping("/list")
    public String list(Model model){
        List<Story> storyList = storyService.getList();
        model.addAttribute("storyList",storyList);
        return "story-list";
    }

}
