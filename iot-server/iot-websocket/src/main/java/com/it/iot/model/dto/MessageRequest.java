package com.it.iot.model.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class MessageRequest implements Serializable {

    private Long unionId;

    private Integer current = 1;

    private Integer size = 10;
}