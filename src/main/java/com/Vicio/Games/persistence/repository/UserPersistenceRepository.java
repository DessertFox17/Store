package com.Vicio.Games.persistence.repository;

import com.Vicio.Games.domain.repository.UserDomainRepository;
import com.Vicio.Games.persistence.crud.UserCrudRepository;
import com.Vicio.Games.persistence.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UserPersistenceRepository implements UserDomainRepository {

    @Autowired
    private UserCrudRepository userCrudRepository;

    @Override
    public List<UserEntity> findAllUsers() {
        return (List<UserEntity>) userCrudRepository.findAll();
    }

    @Override
    public UserEntity newUser(UserEntity userEntity) {
        return userCrudRepository.save(userEntity);
    }

    @Override
    public Optional<UserEntity> findUserByID(int uId) {
        return userCrudRepository.findById(uId);
    }

    @Override
    public UserEntity updateUser(UserEntity userEntity) {
        return userCrudRepository.save(userEntity);
    }

    @Override
    public Optional<UserEntity> getByEmail(String email) {
        return userCrudRepository.findByEmail(email);
    }

    @Override
    public void deleteUser(int prId) {
        userCrudRepository.deleteById(prId);
    }


}
