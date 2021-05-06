package com.Vicio.Games.domain.repository;

import com.Vicio.Games.persistence.entity.RoleEntity;

import java.util.Optional;


public interface RoleDomainRepository {
    Optional<RoleEntity> getByRoleId(int roId);
}
