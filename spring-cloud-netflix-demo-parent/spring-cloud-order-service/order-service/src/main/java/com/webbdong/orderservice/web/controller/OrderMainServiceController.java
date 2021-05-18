package com.webbdong.orderservice.web.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.webbdong.common.model.vo.ResponseVO;
import com.webbdong.common.util.ResponseVOUtils;
import com.webbdong.orderservice.model.entity.OrderMain;
import com.webbdong.orderservice.model.mapper.OrderMainModelMapper;
import com.webbdong.orderservice.model.vo.OrderMainVO;
import com.webbdong.orderservice.service.OrderMainService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Webb Dong
 * @date 2021-05-09 4:43 PM
 */
@RestController
public class OrderMainServiceController {

    private OrderMainService orderMainService;

    @Autowired
    public OrderMainServiceController(OrderMainService orderMainService) {
        this.orderMainService = orderMainService;
    }

    @HystrixCommand(
        groupKey = "get_by_id_group",
        commandKey = "get_by_id",
        threadPoolKey = "get_by_id_pool",
        fallbackMethod = "getByIdFallback",
        threadPoolProperties = {
            @HystrixProperty(name = "coreSize", value = "5"),
            @HystrixProperty(name = "maxQueueSize", value = "1"),
            @HystrixProperty(name = "keepAliveTimeMinutes", value = "1"),
        },
        commandProperties = {
            // 超时时间
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000"),
            // 熔断触发的最小个数
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "1000"),
        }
    )
    @SneakyThrows
    @GetMapping("/order/{orderId}")
    public ResponseVO<OrderMainVO> getById(@PathVariable Long orderId) {
        OrderMain orderMain = orderMainService.getById(orderId);
        return ResponseVOUtils.success(OrderMainModelMapper.INSTANCE.doToVO(orderMain));
    }

    public ResponseVO<OrderMainVO> getByIdFallback(Long orderId) {
        ResponseVO<OrderMainVO> responseVO = new ResponseVO<>();
        responseVO.setCode(200);
        responseVO.setMsg("降级");
        return responseVO;
    }

}
