package com.it.core.netty.model;

import lombok.Data;

/**
 * @author ZL
 * @menu netty 基础请求
 * @date 2021/4/25 上午1:58
 */
@Data
public class NettyGlobalRequest<R> {
    /**
     * 请求连接类型
     */
    private Integer connectType;
    /**
     * 刷新推送间隔(为0则推送一次)
     */
    private Long period = 2000L;
    /**
     * 请求数据
     */
    private R data;
}
