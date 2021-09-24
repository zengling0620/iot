package com.it.core.netty;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Configuration;

/**
 * @author ZL
 * @menu 注册
 * @date 2021/4/25 上午1:58
 */
@Slf4j
@Configuration
@ConditionalOnClass(NettyServiceAdapter.class)
public class NettyServiceInitializer implements InitializingBean {
    @Override
    public void afterPropertiesSet() throws Exception {

    }
}
