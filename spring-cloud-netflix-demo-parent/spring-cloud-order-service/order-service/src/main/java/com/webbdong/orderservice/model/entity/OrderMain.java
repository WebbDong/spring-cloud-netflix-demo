package com.webbdong.orderservice.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author Webb Dong
 * @date 2021-05-09 4:33 PM
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class OrderMain {

    private Long id;

    private String name;

    private BigDecimal fee;

    private String currency;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    private Boolean deleted;

    private Integer version;

}
