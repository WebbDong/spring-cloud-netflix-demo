package com.webbdong.gateway.predicate;

import lombok.Data;
import org.springframework.cloud.gateway.handler.predicate.AbstractRoutePredicateFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * @author Webb Dong
 * @date 2021-09-26 4:32 PM
 */
@Component
public class GatherListTailFlagRoutePredicateFactory extends AbstractRoutePredicateFactory<GatherListTailFlagRoutePredicateFactory.Config> {

    public static final String LIST_KEY = "list";

    public static final String FLAG_KEY = "flag";

    public GatherListTailFlagRoutePredicateFactory() {
        super(Config.class);
    }

    @Override
    public Predicate<ServerWebExchange> apply(Config config) {
        return exchange -> {
            System.out.println("GatherListTailFlagRoutePredicateFactory.apply() ----- config = " + config);
            return true;
        };
    }

    @Override
    public List<String> shortcutFieldOrder() {
        return Arrays.asList(LIST_KEY, FLAG_KEY);
    }

    @Override
    public ShortcutType shortcutType() {
        return ShortcutType.GATHER_LIST_TAIL_FLAG;
    }

    @Data
    public static class Config {
        private String[] list;
        private Boolean flag;
    }

}
