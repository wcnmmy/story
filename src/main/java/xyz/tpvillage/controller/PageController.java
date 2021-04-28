package xyz.tpvillage.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import xyz.tpvillage.entity.*;
import xyz.tpvillage.service.*;

import javax.servlet.http.HttpSession;
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

    @Autowired
    MessageService messageService;

    @Autowired
    StoryImageRelationService storyImageRelationService;

    @ApiOperation(value = "故事详细页面")
    @GetMapping("/story/{pinyin}")
    public String story(@PathVariable String pinyin,Model model){

        /**
         * 根据拼音查出相关的故事信息
         */
        Story story = storyService.getByPinyin(pinyin);

        /**
         * 通过故事编号查询出相关的图片信息
         */
        List<Image> imageList = imageService.listByStory(story.getId());

        model.addAttribute("story",story);
        model.addAttribute("imageList",imageList);
        return "story";
    }

    @ApiOperation(value = "故事列表页面")
    @GetMapping("/story-list")
    public String storyList(Model model){
        List<Story> storyList = storyService.list();
        model.addAttribute("storyList",storyList);
        return "story-list";
    }

    @ApiOperation(value = "图片列表页面")
    @GetMapping("/image-list")
    public String imageList(Model model){
        List<Image> imageList = imageService.selectPage(1,36);

        model.addAttribute("imageList",imageList);
        return "image-list";
    }

    @GetMapping("/video/{videoId}")
    public String video(@PathVariable String videoId, Model model, HttpSession session){
        if(!SessionController.TP_UUID.equals(session.getAttribute("TP_UUID"))){
            return "40x/403";
        }
        List<Video> videoList = videoService.selectPage(1,20);
        Video video = videoList.stream().filter(video1 -> {
            return video1.getId().equals(videoId);
        }).findFirst().get();
        videoList.remove(video);
        model.addAttribute("video",video);
        model.addAttribute("videoList",videoList);
        return "video";
    }

    @ApiOperation(value = "视频列表页面")
    @GetMapping("/video-list")
    public String videoList(Model model){
        List<Video> videoList = videoService.selectPage(1,20);
        model.addAttribute("videoList",videoList);
        return "video-list";
    }

    @ApiOperation(value = "消息列表页面")
    @GetMapping("/message-list")
    public String messageList(Model model){
        List<Message> messageList = messageService.selectPage(1,10);
        model.addAttribute("messageList",messageList);
        return "message-list";
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
        List<Message> messageList = messageService.selectPage(1,4);
        log.info("message = {}",messageList.get(0));

        model.addAttribute("storyList",storyList);
        model.addAttribute("imageList",imageList);
        model.addAttribute("videoList",videoList);
        model.addAttribute("messageList",messageList);
        model.addAttribute("message",messageList.get(0));
        return "index";
    }

}
