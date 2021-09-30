package com.webbdong.gateway.filter;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.core.Ordered;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * 自定义 GatewayFilter，直接实现 GatewayFilter 接口，将不能在配置文件中使用，只能在代码中配置
 * @author Webb Dong
 * @date 2021-09-27 12:12 AM
 */
public class PayFilter implements GatewayFilter, Ordered {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        System.out.println("PayFilter pre");
        return chain.filter(exchange)
                // 后置执行逻辑
                .then(Mono.fromRunnable(() -> System.out.println("PayFilter post")));
    }

    @Override
    public int getOrder() {
        return 0;
    }

}
