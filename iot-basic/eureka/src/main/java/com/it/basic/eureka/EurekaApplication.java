package com.it.basic.eureka;

import com.it.core.Pretty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 * @author ZL
 * @menu todo
 * @date 2021/9/2 17:35
 */
@Slf4j
@EnableEurekaServer
@SpringBootApplication
public class EurekaApplication {

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        Pretty.welcome(SpringApplication.run(EurekaApplication.class, args));
        log.info("注册中心服务启动耗时：{}", (System.currentTimeMillis() - startTime) / 1000 + "秒");
    }
}
