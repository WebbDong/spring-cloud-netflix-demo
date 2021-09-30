package com.webbdong.gateway.config;

import com.webbdong.gateway.filter.PayFilter;
import com.webbdong.gateway.filter.PayMethodHeaderGatewayFilterFactory;
import com.webbdong.gateway.predicate.GatherListTailFlagRoutePredicateFactory;
import com.webbdong.gateway.predicate.MyMethodRoutePredicateFactory;
import com.webbdong.gateway.predicate.TokenHeaderRoutePredicateFactory;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

/**
 * 代码方式路由配置
 * @author Webb Dong
 * @date 2021-09-25 2:12 PM
 */
//@Configuration
public class RoutesConfig {

    @Bean
    public RouteLocator routeLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("order-service", r -> r
                        .path("/api/order/**").and()
                        .cookie("CookieToken", "123456").and()
                        .header("Access-Token", "^(?!\\d+$)[\\da-zA-Z]+$").and()
                        .method("GET", "POST").and()
                        .host("localhost").and()
                        // 自定义断言
                        .asyncPredicate(tokenHeaderRoutePredicateFactory()
                                .applyAsync(config -> config.setTokenHeaderName("Authorization"))).and()
                        .asyncPredicate(myMethodRoutePredicateFactory()
                                .applyAsync(config -> config.setMethods(Arrays.asList("GET", "POST")))).and()
                        .asyncPredicate(gatherListTailFlagRoutePredicateFactory()
                                .applyAsync(config -> {
                                    config.setList(new String[] {"param1", "param2"});
                                    config.setFlag(true);
                                }))
                        // 配置局部过滤器
                        .filters(f -> {
                            // 默认过滤器
                            f.stripPrefix(1);
                            f.addResponseHeader("X-Response-Default-Name", "Ferrari");

                            // 自定义过滤器
                            f.filter(new PayFilter());
                            return f;
                        })
                        .uri("lb://order-service"))
                .route("user-service", r -> r.path("/user/**").uri("lb://user-service"))
                .build();
    }

    @Bean
    public TokenHeaderRoutePredicateFactory tokenHeaderRoutePredicateFactory() {
        return new TokenHeaderRoutePredicateFactory();
    }

    @Bean
    public MyMethodRoutePredicateFactory myMethodRoutePredicateFactory() {
        return new MyMethodRoutePredicateFactory();
    }

    @Bean
    public GatherListTailFlagRoutePredicateFactory gatherListTailFlagRoutePredicateFactory() {
        return new GatherListTailFlagRoutePredicateFactory();
    }

}
