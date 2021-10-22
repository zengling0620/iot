package com.it.iot.runner;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
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
class InitApplicationRunner implements ApplicationRunner {

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
