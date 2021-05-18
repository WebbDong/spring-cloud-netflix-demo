package com.webbdong.userservice;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * http://localhost:10006/hystrix
 * http://localhost:10006/actuator/hystrix.stream
 * @author Webb Dong
 * @date 2021-05-08 7:42 PM
 */
@SpringCloudApplication
@EnableFeignClients(basePackages = "com.webbdong")
@EnableHystrixDashboard
@ComponentScan("com.webbdong")
public class UserServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserServiceApplication.class, args);
    }

}
