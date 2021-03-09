package xyz.tpvillage.controller;


import cn.hutool.core.util.IdUtil;
import com.aliyun.oss.OSS;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.multipart.MultipartFile;
import xyz.tpvillage.entity.Image;
import xyz.tpvillage.service.ImageService;
import xyz.tpvillage.util.OSSUtil;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * 图片主表 前端控制器
 * </p>
 *
 * @author mybatis-plus-generator
 * @since 2021-01-28
 */
@Api(tags = "图片信息Controller")
@RestController
@RequestMapping("/image")
public class ImageController {

    @Autowired
    ImageService service;

    /**
     * 添加图片信息
     * @param file
     * @return
     */
    @PostMapping ()
    public Object addImage(MultipartFile file) throws IOException {
        String fileName = file.getOriginalFilename();
        Long fileSize = file.getSize();
        Image image = Image.initialize();
        image.setName(fileName);
        image.setSize(fileSize);
        OSSUtil.upload("story/image-min-test/"+fileName,file.getInputStream());
        service.save(image);
        return image;
    }

    @GetMapping()
    public Image getImage(String id){
        return service.getById(id);
    }
}

