package com.nxhung.redis.adapters;

import com.nxhung.redis.domain.dtos.UserEntityDto;
import com.nxhung.redis.domain.dtos.UserUpdateRequest;
import com.nxhung.redis.domain.mapper.UserMapper;
import com.nxhung.redis.domain.services.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
@Slf4j
public class UserController {
    private final UserService userService;

    @GetMapping
    public Collection<UserEntityDto> getAllUser() {
        return userService.getAllUsers();
    }

    @PutMapping("/{id}")
    public UserEntityDto updateUser(@PathVariable("id") Long id, @RequestBody UserUpdateRequest data) {
        return userService.updateUser(id, data);
    }

    @GetMapping("/{id}")
    public UserEntityDto getUserById(@PathVariable("id") Long id) {
        return userService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteUserById(@PathVariable("id") Long id) {
        userService.deleteUserById(id);
    }


}
