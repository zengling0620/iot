package com.it;

import cn.hutool.core.date.LocalDateTimeUtil;
import cn.hutool.core.lang.Console;
import cn.hutool.core.map.MapUtil;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Map;

/**
 * @author ZL
 * @menu todo
 * @date 2021/4/25 上午1:58
 */
public class HutoolTest {
    /***********************************************时间测试*****************************************/

    @Test
    public void of() {
        long time = new Date().getTime();
        LocalDateTime l = LocalDateTimeUtil.of(time);
        Console.print(l);
    }
    /***********************************************OptinalBean*****************************************/

    /***********************************************MapUtil*****************************************/

    @Test
    public void MapCreate(){
        User user = new User();
        Map<String, Object> map = MapUtil.createMap(user.getClass());
        System.out.println("map = " + map);
    }
}
