package com.Vicio.Games.persistence.repository;

import com.Vicio.Games.domain.repository.StatusDomainRepository;
import com.Vicio.Games.persistence.crud.StatusCrudRepository;
import com.Vicio.Games.persistence.entity.StatusEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class StatusPersistenceRepository implements StatusDomainRepository {

    @Autowired
    private StatusCrudRepository statusCrudRepository;

    @Override
    public Optional<StatusEntity> findStatusById(int stId) {
        return statusCrudRepository.findById(stId);
    }
}
