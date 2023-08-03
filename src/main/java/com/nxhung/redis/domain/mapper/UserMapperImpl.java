package com.nxhung.redis.domain.mapper;

import com.nxhung.redis.domain.dtos.UserEntityDto;
import com.nxhung.redis.domain.entities.UserEntity;
import org.springframework.stereotype.Service;

@Service
public class UserMapperImpl implements UserMapper {
    @Override
    public UserEntityDto toDto(UserEntity user) {
        var dto = new UserEntityDto();
        dto.setId(user.getId());
        dto.setUsername(user.getUsername());
        dto.setName(user.getName());
        return dto;
    }
}
