package com.webbdong.orderservice.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.webbdong.orderservice.model.entity.OrderMain;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Webb Dong
 * @date 2021-05-09 4:32 PM
 */
@Mapper
public interface OrderMainMapper extends BaseMapper<OrderMain> {
}
