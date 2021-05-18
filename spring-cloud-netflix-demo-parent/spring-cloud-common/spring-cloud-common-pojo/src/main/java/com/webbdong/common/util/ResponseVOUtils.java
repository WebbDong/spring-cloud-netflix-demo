package com.webbdong.common.util;

import com.webbdong.common.model.vo.ResponseVO;

/**
 * @author Webb Dong
 * @date 2021-05-09 2:48 PM
 */
public interface ResponseVOUtils {

    static <T> ResponseVO success(T data) {
        return ResponseVO.builder()
                .code(200)
                .msg("success")
                .data(data)
                .build();
    }

}
