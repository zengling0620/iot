package com.it.iot.server.impl;

import com.alibaba.fastjson.JSON;
import com.it.iot.enums.ClientEnum;
import com.it.iot.model.dto.MessageRequest;
import com.it.iot.model.dto.PhmRequestDTO;
import com.it.iot.server.ISocketService;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author ZL
 * @menu todo
 * @date 2021/4/25 上午1:58
 */
@Slf4j
@Service
@AllArgsConstructor
@NoArgsConstructor
public class PhmServer implements ISocketService {

    private ChannelHandlerContext context;

    private MessageRequest<PhmRequestDTO> message;

    @Override
    public String getType() {
        return ClientEnum.PHM.getValue();
    }

    @Override
    public void run() {
        context.channel().writeAndFlush(new TextWebSocketFrame(JSON.toJSONString(message)));
    }
}
