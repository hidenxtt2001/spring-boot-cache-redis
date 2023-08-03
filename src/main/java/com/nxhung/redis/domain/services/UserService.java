package com.nxhung.redis.domain.services;

import com.nxhung.redis.domain.dtos.UserEntityDto;
import com.nxhung.redis.domain.dtos.UserUpdateRequest;
import com.nxhung.redis.domain.entities.UserEntity;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Collection;

public interface UserService {
    @Cacheable(value = "users")
    Collection<UserEntityDto> getAllUsers();

    @CachePut(value = "users", key = "#id")
    UserEntityDto updateUser(Long id, UserUpdateRequest data);

    @Cacheable(value = "users", key = "#id")
    UserEntityDto findById(Long id);

    @CacheEvict(value = "users", key = "#id")
    void deleteUserById(Long id);

}
