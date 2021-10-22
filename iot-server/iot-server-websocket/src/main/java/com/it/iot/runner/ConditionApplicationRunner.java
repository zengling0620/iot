package com.it.iot.runner;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

/**
 * @author ZL
 * @menu todo
 * @date 2021/4/25 上午1:58
 */
@Slf4j
@Component
@ConditionalOnProperty(prefix = "ws.pis",value = "enable",havingValue = "true")
public class ConditionApplicationRunner implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) {
        try {
            log.info("ConditionApplicationRunner start......");
            log.info("ConditionApplicationRunner end......");
        } catch (Exception e) {
            log.error("按需加载配置异常:", e);
        }
    }
}
