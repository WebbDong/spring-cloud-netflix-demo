package com.webbdong.userservice.api;

import com.webbdong.common.model.vo.ResponseVO;
import com.webbdong.userservice.model.vo.UserVO;
import org.springframework.stereotype.Component;

/**
 * @author Webb Dong
 * @date 2021-05-09 4:26 PM
 */
@Component
public class UserServiceClientFallback implements UserServiceClient {

    @Override
    public ResponseVO<UserVO> getById(Long userId) {
        return null;
    }

    @Override
    public ResponseVO discoveryClientGetInstances() {
        return null;
    }

}
