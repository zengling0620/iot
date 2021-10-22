package com.it.iot.server;

import com.it.iot.core.WebsocketInitialization;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

/**
 * @author ZL
 * @menu websocket程序
 * @date 2021/9/23 14:42
 */
@Slf4j
@Component
public class WebsocketApplication {

    @Resource
    private WebsocketInitialization websocketInitialization;

    @PostConstruct
    public void start() {
        try {
            log.info("{}:websocket启动中......", Thread.currentThread().getName());
            websocketInitialization.init();
            log.info("{}:websocket启动成功!!!!!!", Thread.currentThread().getName());
        } catch (Exception e) {
            log.error("websocket发生错误: {}", e.getMessage());
        }
    }
}