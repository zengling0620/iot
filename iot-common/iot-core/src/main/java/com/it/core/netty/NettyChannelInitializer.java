package com.it.core.netty;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import lombok.extern.slf4j.Slf4j;

/**
 * @author ZL
 * @menu 初始化
 * @date 2021/4/25 上午1:58
 */
@Slf4j
public class NettyChannelInitializer extends ChannelInitializer<SocketChannel> {

    private static final String WEBSOCKET_PATH = "/websocket";

    @Override
    protected void initChannel(SocketChannel socketChannel) {
        try {

        } catch (Exception e) {
            log.error("NettyChannelInitializer error:", e);
        }
    }
}
