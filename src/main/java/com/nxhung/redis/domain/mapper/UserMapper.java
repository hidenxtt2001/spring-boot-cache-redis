package com.nxhung.redis.domain.mapper;

import com.nxhung.redis.domain.dtos.UserEntityDto;
import com.nxhung.redis.domain.entities.UserEntity;
import org.springframework.stereotype.Service;

public interface UserMapper {
    public UserEntityDto toDto(UserEntity user);
}
