package com.it;

import cn.hutool.core.bean.OptionalBean;
import cn.hutool.core.date.LocalDateTimeUtil;
import cn.hutool.core.lang.Console;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Optional;

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
}
