package com.jackson.demo.jacksonannotations.entity.repository;

import com.jackson.demo.jacksonannotations.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    UserEntity findByUserId(long userId);
}
