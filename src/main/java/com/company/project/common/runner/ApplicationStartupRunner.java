package com.company.project.common.runner;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

import java.net.InetAddress;

/**
 * @author Ray。
 */
@Component
@Slf4j
public class ApplicationStartupRunner implements ApplicationRunner {

    @Autowired
    private ConfigurableApplicationContext context;

    @Value("${server.port}")
    private String port;

    @Value("${server.servlet.context-path:}")
    private String contextPath;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        if (context.isActive()) {
            InetAddress address = InetAddress.getLocalHost();
            String url = String.format("http://%s:%s", address.getHostAddress(), port);
            if (StringUtils.isNotBlank(contextPath)) {
                url += contextPath;
            }
//            log.info("seed 权限系统启动完毕，地址：{}", url);
        }
    }
}
