package com.it.core;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import java.net.InetAddress;

/**
 * @author ZL
 * @menu todo
 * @date 2021/9/6 13:59
 */
@Slf4j
public class Pretty {

    @SneakyThrows
    public static void welcome(final ConfigurableApplicationContext context) {
        ConfigurableEnvironment env = context.getEnvironment();
        String protocol = env.getProperty("server.ssl.key-store") == null ? "http" : "https";
        final String crlf = "\n";
        String indent = "\t";
        final String lineSeparator = crlf + "--------------------------------------------------------" + crlf;
        String appName = env.getProperty("spring.application.name");
        String port = env.getProperty("local.server.port");
        String contextPath = env.getProperty("server.servlet.context-path");
        String[] activeProfiles = env.getActiveProfiles();
        String hostAddress = InetAddress.getLocalHost().getHostAddress();
        StringBuilder builder = new StringBuilder();
        builder.append(indent).append("Application {} is running! Access URLs:").append(crlf);
        builder.append(indent).append("Local:").append(indent).append(indent).append("{}://localhost:{}").append(crlf);
        builder.append(indent).append("External:").append(indent).append("{}://{}:{}").append(crlf);
        builder.append(indent).append("Context:").append(indent).append("{}").append(crlf);
        builder.append(indent).append("Profile(s):").append(indent).append("{}");
        builder.append(lineSeparator);
        log.info(builder.toString(), appName, protocol, port, protocol, hostAddress, port, contextPath, activeProfiles);
    }
}
