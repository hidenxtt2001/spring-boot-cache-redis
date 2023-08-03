package com.nxhung.redis.domain.repositories;

import com.nxhung.redis.domain.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<UserEntity,Long> {

    @Modifying(clearAutomatically = true)
    @Query(value = "UPDATE UserEntity u SET u.name=:name WHERE u.id = :id")
    Long updateById(@Param("id") Long id, @Param("name") String name);
}
