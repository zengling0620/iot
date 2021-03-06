package com.it.iot.model.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class MessageRequest<R> implements Serializable {
    /**
     *
     */
    private Long unionId;
    private String unionType;
    /**
     * 推送频率
     */
    private Long period = 2000L;
    private R data;
}