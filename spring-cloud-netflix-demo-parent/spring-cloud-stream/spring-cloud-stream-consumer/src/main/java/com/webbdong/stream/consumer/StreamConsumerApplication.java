package com.webbdong.stream.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author Webb Dong
 * @date 2021-10-09 4:49 PM
 */
@SpringBootApplication
@ComponentScan("com.webbdong")
public class StreamConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(StreamConsumerApplication.class, args);
    }

}
