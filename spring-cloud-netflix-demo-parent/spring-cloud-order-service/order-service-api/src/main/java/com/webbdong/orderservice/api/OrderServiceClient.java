package com.webbdong.orderservice.api;

import com.webbdong.common.model.vo.ResponseVO;
import com.webbdong.orderservice.model.vo.OrderMainVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author Webb Dong
 * @date 2021-05-11 12:15 AM
 */
@FeignClient(name = "order-service", fallback = OrderServiceClientFallback.class)
public interface OrderServiceClient {

    @GetMapping("/order/{orderId}")
    ResponseVO<OrderMainVO> getById(@PathVariable("orderId") Long orderId);

}
