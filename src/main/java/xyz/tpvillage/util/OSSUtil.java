package xyz.tpvillage.util;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.model.PutObjectResult;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

/**
 * OSS工具类
 * @author: 朱兴平
 * @date: 2021/2/5
 */
public class OSSUtil {
    // Endpoint以杭州为例，其它Region请按实际情况填写。
    private static final String ENDPOINT = "https://oss-cn-chengdu.aliyuncs.com";
    // 阿里云主账号AccessKey拥有所有API的访问权限，风险很高。强烈建议您创建并使用RAM账号进行API访问或日常运维，请登录RAM控制台创建RAM账号。
    private static final String ACCESS_KEY_ID = "LTAI4GAESAZDmuzhiYUkdgUx";
    private static final String ACCESS_KEY_SECRET = "cDUN3D3LCZl0VpJPyT99Z2U0wXWXHQ";
    private static final String BUCKET_NAME = "tpvillage";

    /**
     * 上传对象
     * @param objectName 对象名称
     * @param data
     * @return
     */
    public static Object upload(String objectName,byte[] data){
        return upload(objectName,new ByteArrayInputStream(data));
    }

    /**
     * 上传对象
     * @param objectName 对象名称
     * @param inputStream 输入流
     * @return
     */
    public static Object upload(String objectName, InputStream inputStream){
        // 创建OSSClient实例
        OSS ossClient = new OSSClientBuilder().build(ENDPOINT, ACCESS_KEY_ID, ACCESS_KEY_SECRET);
        PutObjectResult putObjectResult = ossClient.putObject(BUCKET_NAME,objectName,inputStream);
        return putObjectResult;
    }

}
