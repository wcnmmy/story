package xyz.tpvillage.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import xyz.tpvillage.entity.form.VideoForm;
import xyz.tpvillage.service.VideoService;

import java.io.*;

/**
 * <p>
 * 视频主表 前端控制器
 * </p>
 *
 * @author mybatis-plus-generator
 * @since 2021-01-28
 */
@RestController
@RequestMapping("/video")
@Slf4j
public class VideoController {

    @Autowired
    VideoService videoService;

    /**
     * 添加视频信息
     * @param videoForm
     * @return
     */
    @PostMapping
    public Object add(VideoForm videoForm) throws IOException {
        return videoService.saveFromVideoForm(videoForm);
    }

}

