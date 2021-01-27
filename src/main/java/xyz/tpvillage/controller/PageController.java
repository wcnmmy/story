package xyz.tpvillage.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
@Api(tags = "Html页面控制器",value = "这个控制器只返回HTML页面")
@Controller
@Slf4j
public class PageController {

    @Autowired
    StoryService storyService;

    @ApiOperation(value = "故事列表页面")
    @GetMapping("/story-list")
    public String list(Model model){
        List<Story> storyList = storyService.list();
        model.addAttribute("storyList",storyList);
        return "story-list";
    }

}