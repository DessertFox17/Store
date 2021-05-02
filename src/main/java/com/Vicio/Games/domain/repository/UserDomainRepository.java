package com.Vicio.Games.domain.repository;

import com.Vicio.Games.persistence.entity.UserEntity;

import java.util.List;
import java.util.Optional;


public interface UserDomainRepository {
    List<UserEntity> findAllUsers();
    UserEntity newUser(UserEntity userEntity);
    Optional<UserEntity> findUserByID(int uId);
    UserEntity updateUser(UserEntity userEntity);
    void deleteUser(int prId);
}
