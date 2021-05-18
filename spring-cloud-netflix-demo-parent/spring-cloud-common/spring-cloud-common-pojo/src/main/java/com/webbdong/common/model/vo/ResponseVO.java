package com.webbdong.common.model.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Webb Dong
 * @date 2021-05-09 2:24 PM
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class ResponseVO<T> {

    private int code;

    private String msg;

    private T data;

}
