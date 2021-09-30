package com.webbdong.gateway.filter;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.List;

/**
 * 全局过滤器
 * @author Webb Dong
 * @date 2021-09-28 8:52 PM
 */
@Component
public class MyGlobalFilter implements GlobalFilter, Ordered {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        System.out.println("MyGlobalFilter");
//        List<String> tokenList = exchange.getRequest().getHeaders().get("Token");
        List<String> tokenList = exchange.getRequest().getQueryParams().get("Token");
        if (tokenList == null || tokenList.isEmpty()) {
            exchange.getResponse().setStatusCode(HttpStatus.FORBIDDEN);
            // 结束请求
            return exchange.getResponse().setComplete();
        }
        // 放行
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return 0;
    }

}
