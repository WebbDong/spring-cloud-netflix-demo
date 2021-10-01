package com.webbdong.userservice.api;

import com.webbdong.common.model.vo.ResponseVO;
import com.webbdong.userservice.model.vo.UserVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author Webb Dong
 * @date 2021-05-09 4:24 PM
 */
@FeignClient(name = "user-service"/*, fallback = UserServiceClientFallback.class*/)
public interface UserServiceClient {

    @GetMapping("/user/{userId}")
    ResponseVO<UserVO> getById(@PathVariable("userId") Long userId);

    @GetMapping("/discovery/instances")
    ResponseVO discoveryClientGetInstances();

}
