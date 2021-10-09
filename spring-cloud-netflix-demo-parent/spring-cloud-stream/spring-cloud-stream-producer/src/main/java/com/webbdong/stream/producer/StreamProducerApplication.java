package com.webbdong.stream.producer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author Webb Dong
 * @date 2021-10-09 3:46 PM
 */
@SpringBootApplication
@ComponentScan("com.webbdong")
public class StreamProducerApplication {

    public static void main(String[] args) {
        SpringApplication.run(StreamProducerApplication.class, args);
    }

}
