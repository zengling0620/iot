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
        String builder = indent + "Application {} is running! Access URLs:" + crlf +
                indent + "Local:" + indent + indent + "{}://localhost:{}" + crlf +
                indent + "External:" + indent + "{}://{}:{}" + crlf +
                indent + "Context:" + indent + "{}" + crlf +
                indent + "Profile(s):" + indent + "{}" +
                lineSeparator;
        log.info(builder, appName, protocol, port, protocol, hostAddress, port, contextPath, activeProfiles);
    }
}
