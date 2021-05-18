package com.webbdong.orderservice.api;

import com.webbdong.common.model.vo.ResponseVO;
import com.webbdong.orderservice.model.vo.OrderMainVO;
import org.springframework.stereotype.Component;

/**
 * @author Webb Dong
 * @date 2021-05-11 12:16 AM
 */
@Component
public class OrderServiceClientFallback implements OrderServiceClient {

    @Override
    public ResponseVO<OrderMainVO> getById(Long orderId) {
        return null;
    }

}
