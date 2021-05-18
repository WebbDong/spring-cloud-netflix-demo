package com.webbdong.userservice.web.controller;

import com.webbdong.common.model.vo.ResponseVO;
import com.webbdong.common.util.ResponseVOUtils;
import com.webbdong.userservice.hystrixcommand.GetOrderMainCommand;
import com.webbdong.userservice.model.entity.User;
import com.webbdong.userservice.model.mapper.UserModelMapper;
import com.webbdong.userservice.model.vo.UserVO;
import com.webbdong.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Webb Dong
 * @date 2021-05-09 2:13 PM
 */
@RestController
public class UserServiceController {

    private UserService userService;

    @Autowired
    public UserServiceController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user/{userId}")
    public ResponseVO<UserVO> getById(@PathVariable Long userId) {
        User user = userService.getById(userId);
        return ResponseVOUtils.success(UserModelMapper.INSTANCE.doToVO(user));
    }

    @GetMapping("/service/instances")
    public ResponseVO getServiceInstances() {
        return ResponseVOUtils.success(userService.getServiceInstances());
    }

    @GetMapping("/order/main")
    public ResponseVO getOrderMain() {
        // 编程式 HystrixCommand
        return ResponseVOUtils.success(new GetOrderMainCommand(userService).execute());
    }

    @GetMapping("/order/main2")
    public ResponseVO getOrderMain2() {
        // 注解式 HystrixCommand
        return ResponseVOUtils.success(userService.getOrderMain2());
    }

}
