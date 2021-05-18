package com.webbdong.common.web.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author Webb Dong
 * @date 2021-05-09 10:36 PM
 */
@Configuration
public class RestTemplateConfig {

    // 开启负载均衡网络调用
    @LoadBalanced
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
