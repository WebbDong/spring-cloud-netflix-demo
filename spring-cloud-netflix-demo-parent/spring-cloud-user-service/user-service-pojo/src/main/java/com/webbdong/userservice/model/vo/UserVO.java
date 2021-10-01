package com.webbdong.userservice.model.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @author Webb Dong
 * @date 2021-05-09 2:57 PM
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class UserVO {

    private Long id;

    private String userName;

    private String password;

    private Integer gender;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime lastLoginTime;

}
