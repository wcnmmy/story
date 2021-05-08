package xyz.tpvillage.controller.page;

import cn.hutool.core.util.IdUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xyz.tpvillage.entity.Visit;
import xyz.tpvillage.service.VisitService;
import xyz.tpvillage.util.IPUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;

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

    public static final String SESSION_NAME = "TP_UUID";

    @Autowired
    VisitService visitService;

    @PostMapping("/hello")
    public Object cookie(HttpServletRequest servletRequest,HttpSession session){
        if(!TP_UUID.equals(session.getAttribute(SESSION_NAME))){
            // 访问者初次访问
            String ip = IPUtils.getIpAddr(servletRequest);
            log.info("ip = "+ip);

            /**
             * 构建访问对象并且保存
             */
            Visit visit = new Visit();
            visit.setId(IdUtil.simpleUUID());
            visit.setIp(ip);
            visit.setTime(LocalDateTime.now());
            visitService.save(visit);

            session.setAttribute(SESSION_NAME,TP_UUID);
            return "welcome to tp-village";
        }else{
            // 访问者再次访问
            return "welcome to tp-village again";
        }
    }
}
