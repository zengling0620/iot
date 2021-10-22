package com.it.iot;

import com.it.core.Pretty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@Slf4j
@EnableEurekaClient
@SpringBootApplication
public class IotServerGeneratorApplication {

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        Pretty.welcome(SpringApplication.run(IotServerGeneratorApplication.class, args));
        log.info("代码生成器服务启动耗时：{}", (System.currentTimeMillis() - startTime) / 1000 + "秒");
    }

}
