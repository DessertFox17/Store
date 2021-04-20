package com.Vicio.Games.persistence.crud;

import com.Vicio.Games.persistence.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserCrudRepository extends CrudRepository<UserEntity, Integer> {
}
