package com.webbdong.gateway.filter;

import lombok.Data;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * 自定义 GatewayFilter，继承 AbstractGatewayFilterFactory 可以在配置文件中配置使用
 * @author Webb Dong
 * @date 2021-09-27 11:58 AM
 */
@Component
public class PayMethodHeaderGatewayFilterFactory extends AbstractGatewayFilterFactory<PayMethodHeaderGatewayFilterFactory.Config> implements Ordered {

    public static final String PAY_METHOD_KEY = "payMethod";

    public PayMethodHeaderGatewayFilterFactory() {
        super(Config.class);
    }

    @Override
    public GatewayFilter apply(Config config) {
        return (exchange, chain) -> {
            System.out.println("PayMethodHeaderGatewayFilterFactory payMethod = " + config.getPayMethod());
            exchange.getRequest().mutate().header("pay-method", config.getPayMethod());
            exchange.getResponse().getHeaders().add("pay-method", config.getPayMethod());
            return chain.filter(exchange);
        };
    }

    @Override
    public List<String> shortcutFieldOrder() {
        return Arrays.asList(PAY_METHOD_KEY);
    }

    @Override
    public ShortcutType shortcutType() {
        return ShortcutType.DEFAULT;
    }

    @Override
    public int getOrder() {
        return 0;
    }

    @Data
    public static class Config {
        private String payMethod;
    }

}
