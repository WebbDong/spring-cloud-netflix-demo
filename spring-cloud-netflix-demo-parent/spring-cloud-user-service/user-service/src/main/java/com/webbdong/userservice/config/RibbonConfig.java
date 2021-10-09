package com.webbdong.userservice.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Webb Dong
 * @date 2021-10-02 2:29 PM
 */
@Configuration
public class RibbonConfig {

    /**
     * Ribbon负载均衡算法配置
     * @return
     */
    @Bean
    public IRule loadBalanceRule() {
        return new RandomRule();
    }

}
