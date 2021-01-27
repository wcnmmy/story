package xyz.tpvillage.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import xyz.tpvillage.entity.Story;
import xyz.tpvillage.service.StoryService;

/**
 * <p>
 * 故事主表 前端控制器
 * </p>
 *
 * @author mybatis-plus-generator
 * @since 2021-01-28
 */
@RestController
@RequestMapping("/story")
public class StoryController {

    @Autowired
    StoryService storyService;

    @PutMapping
    public Object addStory(Story story){
        return storyService.save(story);
    }

    @GetMapping
    public Object getStory(){
        return storyService.list();
    }

}

