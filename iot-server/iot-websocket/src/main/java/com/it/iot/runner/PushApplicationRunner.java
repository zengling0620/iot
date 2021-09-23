package com.it.iot.runner;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author ZL
 * @menu 推送
 * @date 2021/4/25 上午1:58
 */
@Slf4j
@Order(2)
@Component
public class PushApplicationRunner implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) {
        try {
            log.info("PushApplicationRunner start......");
            log.info("PushApplicationRunner end......");
        } catch (Exception e) {
            log.error("推送异常:", e);
        }
    }
}
