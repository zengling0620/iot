package com.it.core.netty;

import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;
import io.netty.util.concurrent.ScheduledFuture;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author ZL
 * @menu Netty Server 连接通道
 * @date 2021/4/25 上午1:58
 */
public class NettyChannelGroup {
    /**
     * 存储每一个客户端接入进来时的channel对象
     */
    public static ChannelGroup GROUP = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);
    /**
     * 会话中所以已保存至定时任务的管道
     */
    public static Map<String, ScheduledFuture<?>> SCHEDULED_FUTURE = new ConcurrentHashMap<>();
}
