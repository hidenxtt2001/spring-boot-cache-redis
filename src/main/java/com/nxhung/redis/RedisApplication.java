package com.nxhung.redis;

import com.github.javafaker.Faker;
import com.nxhung.redis.domain.entities.UserEntity;
import com.nxhung.redis.domain.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@RequiredArgsConstructor
public class RedisApplication {
    private final UserRepository userRepository;

    public static void main(String[] args) {
        SpringApplication.run(RedisApplication.class, args);
    }

    @Bean
    public CommandLineRunner run() throws Exception {
        return args -> {
            List<UserEntity> users = new ArrayList<>();
            for (int i = 0; i < 3000; i++) {
                var user = new UserEntity();
                user.setId(Faker.instance().number().randomNumber());
                user.setUsername(Faker.instance().name().username());
                user.setName(Faker.instance().name().fullName());
                users.add(user);
            }
            userRepository.saveAll(users);
        };
    }


}
