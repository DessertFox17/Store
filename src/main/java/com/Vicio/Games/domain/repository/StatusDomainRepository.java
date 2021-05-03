package com.Vicio.Games.domain.repository;

import com.Vicio.Games.persistence.entity.StatusEntity;

import java.util.Optional;

public interface StatusDomainRepository {
    Optional<StatusEntity> findStatusById(int stId);
}
