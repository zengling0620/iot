package com.it.config;

import com.it.core.utils.Pretty;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.Environment;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author ZL
 * @menu todo
 * @date 2021/9/3 11:37
 */
@Slf4j
@EnableConfigServer
@EnableEurekaClient
@SpringBootApplication
public class ConfigApplication {

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        ConfigurableApplicationContext context = SpringApplication.run(ConfigApplication.class, args);
        ConfigurableEnvironment env = context.getEnvironment();
        Pretty.welcome(env);
        log.info("服务启动耗时：{}", (System.currentTimeMillis() - startTime) / 1000 + "秒");
    }

}
