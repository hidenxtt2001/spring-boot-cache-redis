package com.nxhung.redis.domain.services;

import com.nxhung.redis.domain.dtos.UserEntityDto;
import com.nxhung.redis.domain.dtos.UserUpdateRequest;
import com.nxhung.redis.domain.mapper.UserMapper;
import com.nxhung.redis.domain.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Objects;

@Servi
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final RedisTemplate<String, Object> redisTemplate;

    @Override
    public Collection<UserEntityDto> getAllUsers() {
        doLongRunningTask();
        return userRepository.findAll().stream().map(userMapper::toDto).toList();
    }

    @Override
    public UserEntityDto updateUser(Long id, UserUpdateRequest data) {
        doLongRunningTask();
        userRepository.updateById(id, data.getName());
        return userMapper.toDto(userRepository.findById(id).get());

    }

    @Override
    public UserEntityDto findById(Long id) {
        doLongRunningTask();
        return userMapper.toDto(userRepository.findById(id).get());
    }

    @Override
    public void deleteUserById(Long id) {
        doLongRunningTask();
        userRepository.deleteById(id);
    }

    private void doLongRunningTask() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
