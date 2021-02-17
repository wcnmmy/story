package xyz.tpvillage.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import xyz.tpvillage.entity.Image;
import xyz.tpvillage.entity.Story;
import xyz.tpvillage.entity.Video;
import xyz.tpvillage.service.ImageService;
import xyz.tpvillage.service.StoryService;
import xyz.tpvillage.service.VideoService;

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

    @Autowired
    ImageService imageService;

    @Autowired
    VideoService videoService;

    @ApiOperation(value = "故事列表页面")
    @GetMapping("/story-list")
    public String list(Model model){
        List<Story> storyList = storyService.list();
        model.addAttribute("storyList",storyList);
        return "story-list";
    }

    @ApiOperation(value = "故事模板首页")
    @GetMapping({"","/index"})
    public String index(Model model){
        /*
         * 取一部分数据在首页展示
         */
        List<Story> storyList = storyService.selectPage(1,8);
        List<Image> imageList = imageService.selectPage(1,12);
        List<Video> videoList = videoService.selectPage(1,4);

        model.addAttribute("storyList",storyList);
        model.addAttribute("imageList",imageList);
        model.addAttribute("videoList",videoList);
        return "index";
    }

}
