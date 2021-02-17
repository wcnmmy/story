package xyz.tpvillage.entity.form;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

/**
 * 添加视频表单
 * @author: 朱兴平
 * @date: 2021/2/8
 */
@Data
public class VideoForm {

    /**
     * 视频名称
     */
    private String name;

    /**
     * 视频描述
     */
    private String describe;

    /**
     * 视频文件
     */
    private MultipartFile videoFile;
}
