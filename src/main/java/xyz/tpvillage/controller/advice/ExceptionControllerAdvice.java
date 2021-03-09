package xyz.tpvillage.controller.advice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import xyz.tpvillage.common.ResultVO;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 * @author: 朱兴平
 * @date: 2020/11/8
 */
@RestControllerAdvice
@Slf4j
public class ExceptionControllerAdvice {

    /**
     * @param e
     * @return
     */
    @ExceptionHandler({Exception.class})
    public ResultVO exception(Exception e) {
        e.printStackTrace();
        log.error(e.toString());
        return ResultVO.failed("服务器出现错误");
    }

    /**
     * @param e
     * @return
     */
    @ExceptionHandler({BindException.class})
    public ResultVO bindException(BindException e){
        e.printStackTrace();
        // 获取校验消息
        String message = e.getBindingResult().getFieldError().getDefaultMessage();
        log.error(message);
        return ResultVO.failed(message);
    }

    /**
     * 获取控制台错误信息
     * @param ex
     * @return
     */
    private static String getExceptionInfo(Exception ex) {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(out);
        ex.printStackTrace(printStream);
        String rs = new String(out.toByteArray());
        try {
            printStream.close();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }
}