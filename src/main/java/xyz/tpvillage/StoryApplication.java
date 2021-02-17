package xyz.tpvillage;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 *
 * @author Administrator
 */
@SpringBootApplication
@Slf4j
public class StoryApplication {

    public static void main(String[] args) {
        SpringApplication.run(StoryApplication.class, args);
        log.info("tpvillage 直达：http://localhost:9090/tp/");
        log.info("tpvillage Swagger直达：http://localhost:9090/tp/swagger-ui.html");
    }

}
