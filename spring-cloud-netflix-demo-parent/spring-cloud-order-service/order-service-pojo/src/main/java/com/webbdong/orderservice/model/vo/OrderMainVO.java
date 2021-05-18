package com.webbdong.orderservice.model.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @author Webb Dong
 * @date 2021-05-09 4:36 PM
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class OrderMainVO {

    private Long id;

    private String name;

    private BigDecimal fee;

    private String currency;

    private String createTime;

    private String updateTime;

    private Boolean deleted;

    private Integer version;

}
