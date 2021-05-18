package com.webbdong.userservice.hystrixcommand;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandKey;
import com.netflix.hystrix.HystrixCommandProperties;
import com.netflix.hystrix.HystrixThreadPoolKey;
import com.netflix.hystrix.HystrixThreadPoolProperties;
import com.webbdong.orderservice.model.vo.OrderMainVO;
import com.webbdong.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 编程式 HystrixCommand 线程池隔离
 * @author Webb Dong
 * @date 2021-05-12 4:00 PM
 */
public class GetOrderMainCommand extends HystrixCommand<OrderMainVO> {

    private UserService userService;

    @Autowired
    public GetOrderMainCommand(UserService userService) {
        super(setter());
        this.userService = userService;
    }

    @Override
    public OrderMainVO run() throws Exception {
        return userService.getOrderMain();
    }

    // 降级方法
    @Override
    public OrderMainVO getFallback() {
        return OrderMainVO.builder()
                .name("Fallback")
                .build();
    }

    /**
     * 设置 Hystrix 与线程池
     */
    private static Setter setter() {
        // 服务分组
        HystrixCommandGroupKey groupKey = HystrixCommandGroupKey.Factory.asKey("get_order_main_group");
        // 服务标识
        HystrixCommandKey commandKey = HystrixCommandKey.Factory.asKey("get_order_main");
        // 线程池名称
        HystrixThreadPoolKey threadPoolKey = HystrixThreadPoolKey.Factory.asKey("get_order_main_pool");

        /*
         * 线程池配置
         *     withCoreSize : 线程池核心初始大小为10
         *     withKeepAliveTimeMinutes : 线程存活时间1分钟
         *     withQueueSizeRejectionThreshold : 队列等待的阈值为100,超过100执行拒绝策略
         */
        HystrixThreadPoolProperties.Setter threadPoolProperties = HystrixThreadPoolProperties
                .Setter()
                .withCoreSize(5)
                .withMaximumSize(5)
                .withMaxQueueSize(2)
                .withKeepAliveTimeMinutes(1)
                .withQueueSizeRejectionThreshold(100);

        // 命令属性配置 Hystrix 开启超时
        HystrixCommandProperties.Setter commandProperties = HystrixCommandProperties
                .Setter()
                // 采用线程池方式实现服务隔离
                .withExecutionIsolationStrategy(HystrixCommandProperties.ExecutionIsolationStrategy.THREAD)
                // 禁止
                .withExecutionTimeoutEnabled(false);

        return Setter.withGroupKey(groupKey)
                .andCommandKey(commandKey)
                .andThreadPoolKey(threadPoolKey)
                .andThreadPoolPropertiesDefaults(threadPoolProperties)
                .andCommandPropertiesDefaults(commandProperties);
    }

}
