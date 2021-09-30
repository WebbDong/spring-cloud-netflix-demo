package com.webbdong.gateway.filter;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractNameValueGatewayFilterFactory;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

/**
 * 自定义 AbstractNameValueGatewayFilterFactory
 * @author Webb Dong
 * @date 2021-09-27 12:35 PM
 */
@Component
public class MyNameValueGatewayFilterFactory extends AbstractNameValueGatewayFilterFactory implements Ordered {

    @Override
    public GatewayFilter apply(NameValueConfig config) {
        System.out.println("name = " + config.getName() + ", value = " + config.getValue());
        return (exchange, chain) -> chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return 0;
    }

}
