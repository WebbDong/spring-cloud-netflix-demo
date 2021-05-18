package com.webbdong.userservice.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @author Webb Dong
 * @date 2021-05-09 2:58 PM
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class UserDTO {

    private Long id;

    private String userName;

    private String password;

    private Integer gender;

    private LocalDateTime lastLoginTime;

}
