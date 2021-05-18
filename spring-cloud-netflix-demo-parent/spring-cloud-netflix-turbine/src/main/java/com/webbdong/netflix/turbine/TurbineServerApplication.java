package com.webbdong.netflix.turbine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

/**
 * http://localhost:8031/hystrix
 * http://localhost:8031/turbine.stream
 * @author Webb Dong
 * @date 2021-05-13 1:54 PM
 */
@SpringBootApplication
@EnableTurbine
@EnableHystrixDashboard
public class TurbineServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(TurbineServerApplication.class, args);
    }

}
