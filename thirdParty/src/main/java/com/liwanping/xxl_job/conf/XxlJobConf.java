package com.liwanping.xxl_job.conf;

import com.xxl.job.core.executor.XxlJobExecutor;
import com.xxl.job.core.executor.impl.XxlJobSpringExecutor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
@Slf4j
@Configuration
@ComponentScan(basePackages = "com.tff.creditpay.channel.job")
public class XxlJobConf {

    @Value("${tff.job.admin.addresses}")
    private String adminAddresses;

    @Value("${tff.job.executor.appname}")
    private String appName;

    @Value("${tff.job.executor.ip}")
    private String ip;

    @Value("${tff.job.executor.port}")
    private int port;

    @Value("${tff.job.accessToken}")
    private String accessToken;

    @Value("${tff.job.executor.logpath}")
    private String logPath;

    @Value("${tff.job.executor.logretentiondays}")
    private int logRetentionDays;


    @Bean(initMethod = "start", destroyMethod = "destroy")
    public XxlJobSpringExecutor xxlJobExecutor() {
        log.info(">>>>>>>>>>> tff-job config init.");
        XxlJobSpringExecutor xxlJobExecutor = new XxlJobSpringExecutor();
        xxlJobExecutor.setAdminAddresses(adminAddresses);
        xxlJobExecutor.setAppName(appName);
        xxlJobExecutor.setIp(ip);
        xxlJobExecutor.setPort(port);
        xxlJobExecutor.setAccessToken(accessToken);
        xxlJobExecutor.setLogPath(logPath);
        xxlJobExecutor.setLogRetentionDays(logRetentionDays);
        return xxlJobExecutor;
    }
}