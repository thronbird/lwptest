package com.liwanping.xxl_job;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @author liwanping
 * @since 2019-06-24
 */
@SpringBootApplication(scanBasePackages = { "com.liwanping.xxl_job" }, exclude = { DataSourceAutoConfiguration.class })
public class XxlJobAppplication {
    public static void main (String[] args ){
        new SpringApplication(XxlJobAppplication.class).run(args);
    }
}
