package com.it.core.netty.model;

import lombok.Data;

/**
 * @author ZL
 * @menu netty 基础响应
 * @date 2021/4/25 上午1:58
 */
@Data
public class NettyGlobalResponse<R> {
    /**
     * 响应数据
     */
    private R data;
    /**
     * 数据下发时间
     */
    private Long timestamp;
}
