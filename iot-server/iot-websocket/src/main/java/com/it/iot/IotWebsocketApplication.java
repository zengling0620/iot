package com.it.iot;

import com.it.core.Pretty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author ZL
 * @menu todo
 * @date 2021/9/19 10:06
 */
@Slf4j
@EnableEurekaClient
@SpringBootApplication
public class IotWebsocketApplication {

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        Pretty.welcome(SpringApplication.run(IotWebsocketApplication.class, args));
        log.info("websocket服务启动耗时：{}", (System.currentTimeMillis() - startTime) / 1000 + "秒");
    }

}
