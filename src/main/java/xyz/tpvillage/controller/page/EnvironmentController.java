package xyz.tpvillage.controller.page;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.tpvillage.config.TpvillageEnvironment;

/**
 * @author: 朱兴平
 * @date: 2021/5/6
 */
@RestController
@RequestMapping(value = "/environment.js",produces = "application/javascript;charset=utf-8")
public class EnvironmentController {

    private static final String SCRIPT = "const TP_ROOT = \"%s\";const TP_STATIC = \"%s\";const TP_OSS = \"%s\";";

    @Autowired
    TpvillageEnvironment environment;

    @GetMapping
    public String environment(){
        String script = String.format(SCRIPT,
                environment.getTP_ROOT(),
                environment.getTP_STATIC(),
                environment.getTP_OSS());

        return script;
    }

}
