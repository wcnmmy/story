package xyz.tpvillage.controller.page;

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

    @GetMapping("/story-list")
    public String storyList(Model model){
        List<Story> storyList = storyService.list();
        model.addAttribute("storyList",storyList);
        return "story-list";
    }

    @GetMapping("/image-list")
    public String imageList(Integer current,Integer size,String typeId,Model model){
        List<Image> imageList = imageService.selectPageByType(current,size,typeId);
        model.addAttribute("current",current);
        model.addAttribute("size",size);
        model.addAttribute("typeId",typeId);
        model.addAttribute("imageList",imageList);
        return "image-list";
    }

    @GetMapping("/video/{videoId}")
    public String video(@PathVariable String videoId, Model model,HttpSession session){
        if(!SessionController.TP_UUID.equals(session.getAttribute(SessionController.SESSION_NAME))){
            return "40x/403";
        }
        List<Video> videoList = videoService.selectPage(1,40);
        Video video = videoList.stream().filter(video1 -> video1.getId().equals(videoId)).findFirst().get();
        videoList.remove(video);

        video.setSee(video.getSee()+1);
        videoService.updateById(video);
        model.addAttribute("video",video);
        model.addAttribute("videoList",videoList);
        return "video";
    }

    @GetMapping("/video-list")
    public String videoList(Model model){
        List<Video> videoList = videoService.selectPage(1,40);
        model.addAttribute("videoList",videoList);
        return "video-list";
    }

    @GetMapping("/message-list")
    public String messageList(Model model){
        List<Message> messageList = messageService.selectPage(1,10);
        model.addAttribute("messageList",messageList);
        return "message-list";
    }

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
