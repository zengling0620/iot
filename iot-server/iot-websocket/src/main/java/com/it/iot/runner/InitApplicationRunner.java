package com.it.iot.runner;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author ZL
 * @menu 项目启动后 初始化配置
 * @date 2021/4/25 上午1:58
 */
@Slf4j
@Component
@Order(1)
public class InitApplicationRunner implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) {
        try {
            log.info("InitApplicationRunner start......");

            log.info("InitApplicationRunner end......");
        } catch (Exception e) {
            log.error("初始化配置异常:", e);
        }
    }
}
