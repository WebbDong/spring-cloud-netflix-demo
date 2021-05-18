package com.webbdong.userservice.model.mapper;

import com.webbdong.userservice.model.dto.UserDTO;
import com.webbdong.userservice.model.entity.User;
import com.webbdong.userservice.model.vo.UserVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author Webb Dong
 * @date 2021-05-09 3:00 PM
 */
@Mapper
public interface UserModelMapper {

    UserModelMapper INSTANCE = Mappers.getMapper(UserModelMapper.class);

    UserDTO voToDTO(UserVO vo);

    UserVO doToVO(User user);

}
