package com.webbdong.orderservice;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author Webb Dong
 * @date 2021-05-09 1:02 PM
 */
@SpringCloudApplication
@EnableFeignClients(basePackages = "com.webbdong")
@EnableHystrixDashboard
@ComponentScan("com.webbdong")
public class OrderServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderServiceApplication.class, args);
    }

}
