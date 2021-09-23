package com.it.iot.server;

import lombok.extern.slf4j.Slf4j;

/**
 * @author ZL
 * @menu todo
 * @date 2021/4/25 上午1:58
 */
@Slf4j
public class WebServer implements Runnable {

    @Override
    public void run() {
        log.info("web");
        log.info("当前时间: {}", System.currentTimeMillis());
    }
}
