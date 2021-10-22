package com.it.iot.context;

import com.it.iot.model.dto.MessageRequest;
import com.it.iot.model.dto.PhmRequestDTO;
import com.it.iot.model.dto.WebRequestDTO;
import com.it.iot.server.ISocketService;
import com.it.iot.server.impl.PhmServer;
import com.it.iot.server.impl.WebServer;
import io.netty.channel.ChannelHandlerContext;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author ZL
 * @menu todo
 * @date 2021/4/25 上午1:58
 */
@Component
public class SocketContext {

    Map<String, ISocketService> serviceMap = new ConcurrentHashMap<>();

    public SocketContext(List<ISocketService> list) {
        list.forEach(item -> serviceMap.put(item.getType(), item));
    }

    public ISocketService getBean(String type, ChannelHandlerContext context, MessageRequest<?> message) {
        ISocketService socketService = Optional.ofNullable(serviceMap.get(type)).orElseThrow(() -> new RuntimeException("参数 [" + type + "]错误 server实例化失败"));
        if (socketService instanceof WebServer) {
            MessageRequest<WebRequestDTO> web = (MessageRequest<WebRequestDTO>) message;
            socketService = new WebServer(context, web);
        } else if (socketService instanceof PhmServer) {
            MessageRequest<PhmRequestDTO> phm = (MessageRequest<PhmRequestDTO>) message;
            socketService = new PhmServer(context, phm);
        } else {
            throw new RuntimeException("");
        }
        return socketService;
    }
}
