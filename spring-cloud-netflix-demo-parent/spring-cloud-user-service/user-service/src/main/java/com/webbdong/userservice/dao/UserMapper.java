package com.webbdong.userservice.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.webbdong.userservice.model.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Webb Dong
 * @date 2021-05-09 2:11 PM
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
}
