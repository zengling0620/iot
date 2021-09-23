package com.it.iot.server.impl;

import com.it.iot.server.IWebsocketService;
import lombok.extern.slf4j.Slf4j;

/**
 * @author ZL
 * @menu todo
 * @date 2021/4/25 上午1:58
 */
@Slf4j
public class PhmServer implements IWebsocketService {

    @Override
    public void run() {
        log.info("phm");
        log.info("当前时间: {}", System.currentTimeMillis());
    }
}
