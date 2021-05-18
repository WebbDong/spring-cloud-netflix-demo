package com.webbdong.orderservice.model.mapper;

import com.webbdong.orderservice.model.dto.OrderMainDTO;
import com.webbdong.orderservice.model.entity.OrderMain;
import com.webbdong.orderservice.model.vo.OrderMainVO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

/**
 * @author Webb Dong
 * @date 2021-05-09 4:40 PM
 */
@Mapper
public interface OrderMainModelMapper {

    OrderMainModelMapper INSTANCE = Mappers.getMapper(OrderMainModelMapper.class);

    @Mappings({
        @Mapping(source = "createTime", target = "createTime", dateFormat = "yyyy-MM-dd HH:mm:ss"),
        @Mapping(source = "updateTime", target = "updateTime", dateFormat = "yyyy-MM-dd HH:mm:ss")
    })
    OrderMainDTO voToDTO(OrderMainVO vo);

    @Mappings({
        @Mapping(source = "createTime", target = "createTime", dateFormat = "yyyy-MM-dd HH:mm:ss"),
        @Mapping(source = "updateTime", target = "updateTime", dateFormat = "yyyy-MM-dd HH:mm:ss")
    })
    OrderMainVO doToVO(OrderMain user);

}
