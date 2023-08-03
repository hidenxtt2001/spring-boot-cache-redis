package com.nxhung.redis.domain.dtos;

import lombok.Data;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link com.nxhung.redis.domain.entities.UserEntity}
 */
@Data
public class UserEntityDto implements Serializable {
    Long id;
    String username;
    String name;
}