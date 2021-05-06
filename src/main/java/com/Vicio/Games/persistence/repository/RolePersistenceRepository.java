package com.Vicio.Games.persistence.repository;

import com.Vicio.Games.domain.repository.RoleDomainRepository;
import com.Vicio.Games.persistence.crud.RoleCrudRepository;
import com.Vicio.Games.persistence.entity.RoleEntity;
import jdk.jfr.Registered;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

@Repository
public class RolePersistenceRepository implements RoleDomainRepository {

    @Autowired
    private RoleCrudRepository roleCrudRepository;


    @Override
    public Optional<RoleEntity> getByRoleId(int roId) {
        return roleCrudRepository.findById(roId);
    }
}
