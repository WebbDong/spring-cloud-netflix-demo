package com.webbdong.userservice.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.webbdong.orderservice.model.vo.OrderMainVO;
import com.webbdong.userservice.model.entity.User;
import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @author Webb Dong
 * @date 2021-05-09 2:12 PM
 */
public interface UserService extends IService<User> {

    OrderMainVO getOrderMain();

    OrderMainVO getOrderMain2();

    List<ServiceInstance> getServiceInstances();

}
