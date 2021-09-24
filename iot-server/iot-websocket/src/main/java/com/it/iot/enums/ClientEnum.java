package com.it.iot.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author ZL
 * @menu todo
 * @date 2021/4/25 上午1:58
 */
@Getter
@AllArgsConstructor
public enum ClientEnum {
    WEB(1, "web", "客户端基础数据交互"),
    PHM(2, "phm", "客户端phm数据交互"),
    ;

    private Integer code;
    private String value;
    private String desc;
}
