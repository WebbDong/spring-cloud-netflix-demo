package com.webbdong.gateway.config;

import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Mono;

/**
 * 限流配置
 * Spring Cloud Gateway 默认使用 redis 的 RateLimiter 限流算法来实现
 *
 * @author Webb Dong
 * @date 2021-09-30 12:00 AM
 */
@Configuration
public class CurrentLimitingConfig {

    @Bean(name = "ipKeyResolver")
    public KeyResolver ipKeyResolver() {
        return exchange -> {
            // 获取远程客户端IP
            String hostName = exchange.getRequest().getRemoteAddress().getAddress().getHostAddress();
            System.out.println("ipKeyResolver hostName:" + hostName);
            return Mono.just(hostName);
        };
    }

}
