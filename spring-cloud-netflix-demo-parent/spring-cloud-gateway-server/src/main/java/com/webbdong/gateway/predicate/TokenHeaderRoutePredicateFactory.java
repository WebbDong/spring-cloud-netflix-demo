package com.webbdong.gateway.predicate;

import lombok.Data;
import org.springframework.cloud.gateway.handler.predicate.AbstractRoutePredicateFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * 自定义Token Header断言
 * @author Webb Dong
 * @date 2021-09-26 1:00 PM
 */
@Component
public class TokenHeaderRoutePredicateFactory extends AbstractRoutePredicateFactory<TokenHeaderRoutePredicateFactory.Config> {

    public static final String TOKEN_HEADER_NAME_KEY = "tokenHeaderName";

    public TokenHeaderRoutePredicateFactory() {
        super(Config.class);
    }

    @Override
    public Predicate<ServerWebExchange> apply(Config config) {
        return exchange -> {
            List<String> tokenHeaderNameList = exchange.getRequest().getHeaders().get(config.getTokenHeaderName());
            System.out.println(config.getTokenHeaderName() + " = " + tokenHeaderNameList);
            return tokenHeaderNameList != null && !tokenHeaderNameList.isEmpty();
        };
    }

    @Override
    public ShortcutType shortcutType() {
        return ShortcutType.DEFAULT;
    }

    @Override
    public List<String> shortcutFieldOrder() {
        return Arrays.asList(TOKEN_HEADER_NAME_KEY);
    }

    @Data
    public static class Config {
        private String tokenHeaderName;
    }

}
