package xyz.tpvillage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.multipart.MultipartFile;
import xyz.tpvillage.entity.Image;
import xyz.tpvillage.service.ImageService;
import xyz.tpvillage.util.OSSUtil;

import java.io.IOException;
import java.util.List;

/**
 * <p>
 * 图片主表 前端控制器
 * </p>
 *
 * @author mybatis-plus-generator
 * @since 2021-01-28
 */
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

    @GetMapping("/{id}")
    public Image getImage(@PathVariable String id){
        return service.getById(id);
    }


    /**
     * 分页查询图片信息
     * @param current
     * @param size
     * @return
     */
    @GetMapping("")
    public List<Image> getImages(Integer current,Integer size){
        return this.service.selectPage(current, size);
    }

    /**
     * 根据故事编号查询图片列表
     * @param id
     * @return
     */
    @GetMapping("/by-story/{id}")
    public List<Image> getImagesByStory(@PathVariable String id){
        return service.listByStory(id);
    };

    /**
     * 根据类型分页查询
     * @param current
     * @param size
     * @param typeId
     * @return
     */
    @GetMapping("/by-type")
    public List<Image> getImagesByType(Integer current,Integer size,String typeId){
        return service.selectPageByType(current, size, typeId);
    }
}

