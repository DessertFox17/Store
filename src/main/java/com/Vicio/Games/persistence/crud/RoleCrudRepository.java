package com.Vicio.Games.persistence.crud;

import com.Vicio.Games.persistence.entity.RoleEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface RoleCrudRepository extends CrudRepository<RoleEntity, Integer> {
}
