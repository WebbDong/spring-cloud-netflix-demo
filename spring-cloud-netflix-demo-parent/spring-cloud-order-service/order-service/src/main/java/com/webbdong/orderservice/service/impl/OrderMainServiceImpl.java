package com.webbdong.orderservice.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.webbdong.orderservice.dao.OrderMainMapper;
import com.webbdong.orderservice.model.entity.OrderMain;
import com.webbdong.orderservice.service.OrderMainService;
import org.springframework.stereotype.Service;

/**
 * @author Webb Dong
 * @date 2021-05-09 4:42 PM
 */
@Service
public class OrderMainServiceImpl extends ServiceImpl<OrderMainMapper, OrderMain> implements OrderMainService {
}
