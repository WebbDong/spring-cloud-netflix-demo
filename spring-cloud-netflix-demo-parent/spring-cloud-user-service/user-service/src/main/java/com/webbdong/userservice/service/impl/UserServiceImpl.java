package com.webbdong.userservice.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.webbdong.common.model.vo.ResponseVO;
import com.webbdong.orderservice.api.OrderServiceClient;
import com.webbdong.orderservice.model.vo.OrderMainVO;
import com.webbdong.userservice.dao.UserMapper;
import com.webbdong.userservice.model.entity.User;
import com.webbdong.userservice.service.UserService;
import lombok.SneakyThrows;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author Webb Dong
 * @date 2021-05-09 2:12 PM
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    private DiscoveryClient discoveryClient;

    private RestTemplate restTemplate;

    private OrderServiceClient orderServiceClient;

    public UserServiceImpl(DiscoveryClient discoveryClient,
                           RestTemplate restTemplate,
                           OrderServiceClient orderServiceClient) {
        this.discoveryClient = discoveryClient;
        this.restTemplate = restTemplate;
        this.orderServiceClient = orderServiceClient;
    }

    @Override
    public List<ServiceInstance> getServiceInstances() {
        List<ServiceInstance> instanceList = discoveryClient.getInstances("order-service");
        ServiceInstance serviceInstance = instanceList.get(0);

        // 单节点直接调用
//        ResponseVO responseVO = restTemplate.getForObject("http://" + serviceInstance.getHost()
//                + ":" + serviceInstance.getPort() + "/order/1", ResponseVO.class);
//        System.out.println(responseVO);

        // 负载均衡调用，需使用 @LoadBalanced
        ResponseVO responseVO = restTemplate.getForObject("http://order-service/order/1", ResponseVO.class);
        System.out.println(responseVO);
        System.out.println(responseVO.getData().getClass());
        return instanceList;
    }

    @SneakyThrows
    @Override
    public OrderMainVO getOrderMain() {
        TimeUnit.SECONDS.sleep(5);
        ResponseVO<OrderMainVO> vo = orderServiceClient.getById(1L);
        System.out.println(vo);
        return vo.getData();
    }

    // 注解式 HystrixCommand 线程池隔离
    @HystrixCommand(
        groupKey = "get_order_main2_group",
        commandKey = "get_order_main2",
        threadPoolKey = "get_order_main2_pool",
        fallbackMethod = "getOrderMain2Fallback",
        threadPoolProperties = {
//            @HystrixProperty(name = "allowMaximumSizeToDivergeFromCoreSize", value = "true"),
            @HystrixProperty(name = "coreSize", value = "5"),
//            @HystrixProperty(name = "maximumSize", value = "5"),
            @HystrixProperty(name = "maxQueueSize", value = "1"),
            @HystrixProperty(name = "keepAliveTimeMinutes", value = "1"),
        },
        commandProperties = {
            // 超时时间
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000"),
            // 熔断触发的最小个数，默认是 20，代表每 10秒 超过 20 个请求就会触发熔断
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "1000"),
        }
    )
    @SneakyThrows
    @Override
    public OrderMainVO getOrderMain2() {
        TimeUnit.SECONDS.sleep(2);
        ResponseVO<OrderMainVO> vo = orderServiceClient.getById(1L);
        System.out.println(vo);
        return vo.getData();
    }

    public OrderMainVO getOrderMain2Fallback() {
        return OrderMainVO.builder()
                .name("降级")
                .build();
    }

}
