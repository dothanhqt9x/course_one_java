package com.btspring.btspring2.convert;

import com.btspring.btspring2.model.dto.request.UserRequestDTO;
import com.btspring.btspring2.model.dto.request.UserSearchRequestDTO;

import com.btspring.btspring2.model.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


@Mapper(componentModel = "spring")
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserEntity toUserEntity(UserRequestDTO userRequestDTO);
    UserRequestDTO toUserRequestDTO(UserEntity userEntity);
    UserEntity userSearchToUserEntity(UserSearchRequestDTO userSearchRequestDTO);
}