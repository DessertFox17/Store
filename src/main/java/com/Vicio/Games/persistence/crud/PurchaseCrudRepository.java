package com.Vicio.Games.persistence.crud;

import com.Vicio.Games.persistence.entity.PurchaseEntity;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface PurchaseCrudRepository extends CrudRepository<PurchaseEntity, Integer> {
    List<PurchaseEntity> findByUsId(int usId);
}
