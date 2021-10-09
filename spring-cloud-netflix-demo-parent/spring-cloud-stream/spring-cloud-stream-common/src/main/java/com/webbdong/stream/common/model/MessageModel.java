package com.webbdong.stream.common.model;

import lombok.Data;
import lombok.experimental.SuperBuilder;

/**
 * @author Webb Dong
 * @date 2021-10-09 4:25 PM
 */
@Data
@SuperBuilder
public class MessageModel {

    private Long id;

    private String data;

}
