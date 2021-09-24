package com.it.iot.handle;

import com.alibaba.fastjson.JSON;
import com.it.iot.context.SocketContext;
import com.it.iot.model.dto.MessageRequest;
import com.it.iot.server.ISocketService;
import com.it.iot.server.impl.PhmServer;
import io.netty.channel.*;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GlobalEventExecutor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.net.SocketAddress;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

/**
 * @author ZL
 * @menu websocket 入站处理器
 * @date 2021/9/23 14:30
 */
@Slf4j
@Component
@ChannelHandler.Sharable//保证处理器，在整个生命周期中就是以单例的形式存在，方便统计客户端的在线数量
public class WebSocketHandler extends SimpleChannelInboundHandler<TextWebSocketFrame> {

    //通道map，存储channel，用于群发消息，以及统计客户端的在线数量，解决问题问题三，如果是集群环境使用redis的hash数据类型存储即可
    private static final Map<String, Channel> channelMap = new ConcurrentHashMap<>();
    //任务map，存储future，用于停止队列任务
    private static final Map<String, Future<?>> futureMap = new ConcurrentHashMap<>();
    //存储channel的id和用户主键的映射，客户端保证用户主键传入的是唯一值，解决问题四，如果是集群中需要换成redis的hash数据类型存储即可
    private static final Map<String, Long> clientMap = new ConcurrentHashMap<>();

    //所有正在连接的channel都会存在这里面，所以也可以间接代表在线的客户端
    public static ChannelGroup channelGroup = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);
    //在线人数
    public static int online;

    @Resource
    private SocketContext context;

    /**
     * 客户端发送给服务端的消息
     *
     * @param ctx
     * @param msg
     */
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, TextWebSocketFrame msg) {
        try {
            //接受客户端发送的消息
            MessageRequest<?> request = JSON.parseObject(msg.text(), MessageRequest.class);
            Long unionId = request.getUnionId();
            //请求连接类型
            String unionType = request.getUnionType();
            ISocketService bean = context.getBean(unionType, ctx, request);
            //每个channel都有id，asLongText是全局channel唯一id
            String key = ctx.channel().id().asLongText();
            //存储channel的id和用户的主键
            clientMap.put(key, unionId);
            log.info("接受客户端的消息......{}-参数[{}]", ctx.channel().remoteAddress(), unionId);
            if (!channelMap.containsKey(key)) {
                //使用channel中的任务队列，做周期循环推送客户端消息，解决问题二和问题五
                Future<?> future = ctx.channel().eventLoop().scheduleAtFixedRate(bean, 0, request.getPeriod(), TimeUnit.MILLISECONDS);
                //存储客户端和服务的通信的Chanel
                channelMap.put(key, ctx.channel());
                //存储每个channel中的future，保证每个channel中有一个定时任务在执行
                futureMap.put(key, future);
            } else {
                //每次客户端和服务的主动通信，和服务端周期向客户端推送消息互不影响 解决问题一
                ctx.channel().writeAndFlush(new TextWebSocketFrame(Thread.currentThread().getName() + "服务器时间" + LocalDateTime.now() + "wdy"));
            }
        } catch (Exception e) {
            log.error("websocket服务器推送消息发生错误：", e);
        }
    }

    /**
     * 客户端连接时候的操作
     *
     * @param ctx
     */
    @Override
    public void handlerAdded(ChannelHandlerContext ctx) {
        channelGroup.add(ctx.channel());
        online = channelGroup.size();
        log.info("加入一个客户端连接......[{}] ThreadName [{}]", ctx.channel().remoteAddress(), Thread.currentThread().getName());
        log.info("当前连接数 {}", online);
    }

    /**
     * 客户端掉线时的操作
     *
     * @param ctx
     */
    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) {
        closeOrException(ctx);
        channelGroup.remove(ctx.channel());
        online = channelGroup.size();
        log.info("移除一个客户端连接......[{}] ThreadName [{}]", ctx.channel().remoteAddress(), Thread.currentThread().getName());
        log.info("当前连接数 {}", online);
    }

    /**
     * 发生异常时执行的操作
     *
     * @param ctx
     * @param cause
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        closeOrException(ctx);
        log.info("异常发生 {}", cause.getMessage());
    }


    private void closeOrException(ChannelHandlerContext ctx) {
        String key = ctx.channel().id().asLongText();
        //移除通信过的channel
        channelMap.remove(key);
        //移除和用户绑定的channel
        clientMap.remove(key);
        //移除定时任务
        Optional.ofNullable(futureMap.get(key)).ifPresent(future -> {
            future.cancel(true);
            futureMap.remove(key);
        });
        //关闭长连接
        ctx.close();
    }

    public static Map<String, Channel> getChannelMap() {
        return channelMap;
    }

    public static Map<String, Future<?>> getFutureMap() {
        return futureMap;
    }

    public static Map<String, Long> getClientMap() {
        return clientMap;
    }
}