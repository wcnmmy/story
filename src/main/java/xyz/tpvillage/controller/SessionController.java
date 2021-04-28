package xyz.tpvillage.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import xyz.tpvillage.util.IPUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author: 朱兴平
 * @date: 2021/4/27
 */
@RestController
@RequestMapping("/session")
@Slf4j
public class SessionController {

    /**
     * 用于播放视频时的身份认证
     */
    public static final String TP_UUID = "TP_VILLAGE";

    @PostMapping("/hello")
    public Object cookie(HttpServletRequest servletRequest, HttpSession session){
        String ip = IPUtils.getIpAddr(servletRequest);
        log.info("ip = "+ip);
        session.setAttribute("TP_UUID",TP_UUID);
        return "welcome to tp-village";
    }
}
