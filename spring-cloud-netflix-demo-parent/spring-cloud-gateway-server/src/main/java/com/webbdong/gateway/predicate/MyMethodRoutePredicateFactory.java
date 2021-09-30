package com.webbdong.gateway.predicate;

import lombok.Data;
import org.springframework.cloud.gateway.handler.predicate.AbstractRoutePredicateFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * 自定义请求方式断言
 * @author Webb Dong
 * @date 2021-09-26 2:44 PM
 */
@Component
public class MyMethodRoutePredicateFactory extends AbstractRoutePredicateFactory<MyMethodRoutePredicateFactory.Config> {

    public static final String METHODS_KEY = "methods";

    public MyMethodRoutePredicateFactory() {
        super(Config.class);
    }

    @Override
    public Predicate<ServerWebExchange> apply(Config config) {
        return exchange -> {
            String requestMethod = exchange.getRequest().getMethod().name();
            return config.getMethods().stream().anyMatch(m -> m.equals(requestMethod));
        };
    }

    @Override
    public ShortcutType shortcutType() {
        return ShortcutType.GATHER_LIST;
    }

    @Override
    public List<String> shortcutFieldOrder() {
        return Arrays.asList(METHODS_KEY);
    }

    @Data
    public static class Config {
        private List<String> methods;
    }

}
