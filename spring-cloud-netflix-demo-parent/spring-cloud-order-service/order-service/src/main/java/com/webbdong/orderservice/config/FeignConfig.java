package com.webbdong.orderservice.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Webb Dong
 * @date 2021-09-30 11:54 PM
 */
@Configuration
public class FeignConfig {

    /**
     * Feign日志级别配置
     * @return
     */
    @Bean
    public Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }

}
