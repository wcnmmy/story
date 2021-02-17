package xyz.tpvillage.util;

import org.bytedeco.javacv.FFmpegFrameGrabber;
import org.bytedeco.javacv.Frame;
import org.bytedeco.javacv.FrameGrabber;
import org.bytedeco.javacv.Java2DFrameConverter;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;

/**
 * Java获取视频时长及截取帧截图详解_java_脚本之家 有改动
 * @see <a href='https://www.jb51.net/article/164207.htm'>Java获取视频时长及截取帧截图详解_java_脚本之家<a/>
 * @author: happyJared
 * @date: 2019/06/28 14:13:52
 */
public class VideoUtil {
    /**
     * 获取视频时长，单位为秒
     *
     * @param inputStream
     * @return 时长（s）
     */
    public static long getVideoDuration(InputStream inputStream) {
        long duration = 0L;
        FFmpegFrameGrabber ff = new FFmpegFrameGrabber(inputStream);
        try {
            ff.start();
            duration = ff.getLengthInTime() / (1000 * 1000);
            ff.stop();
        } catch (FrameGrabber.Exception e) {
            e.printStackTrace();
        }
        return duration;
    }

    /**
     * 截取视频获得指定帧的图片
     *
     * @param inputStream
     * @return
     */
    public static InputStream getVideoPic(InputStream inputStream) {
        InputStream ret = null;
        FFmpegFrameGrabber ff = new FFmpegFrameGrabber(inputStream);
        try {
            ff.start();
            // 截取中间帧图片(具体依实际情况而定)
            int i = 0;
            int length = ff.getLengthInFrames();
            int middleFrame = length / 2;
            Frame frame = null;
            while (i < length) {
                frame = ff.grabFrame();
                if ((i > middleFrame) && (frame.image != null)) {
                    break;
                }
                i++;
            }
            // 截取的帧图片
            Java2DFrameConverter converter = new Java2DFrameConverter();
            BufferedImage srcImage = converter.getBufferedImage(frame);
            int srcImageWidth = srcImage.getWidth();
            int srcImageHeight = srcImage.getHeight();
            // 对截图进行等比例缩放(缩略图)
            int width = 480;
            int height = (int) (((double) width / srcImageWidth) * srcImageHeight);
            BufferedImage thumbnailImage = new BufferedImage(width, height, BufferedImage.TYPE_3BYTE_BGR);
            thumbnailImage.getGraphics().drawImage(srcImage.getScaledInstance(width, height, Image.SCALE_SMOOTH), 0, 0, null);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ImageIO.write(thumbnailImage, "jpg", byteArrayOutputStream);
            ret = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
            ff.stop();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ret;
    }
}
