package com.Vicio.Games.persistence.repository;

import com.Vicio.Games.domain.repository.PurchaseDomaindRepository;
import com.Vicio.Games.persistence.crud.PurchaseCrudRepository;
import com.Vicio.Games.persistence.entity.PurchaseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class PurchasePersistenceRepository implements PurchaseDomaindRepository {

    @Autowired
    private PurchaseCrudRepository purchaseCrudRepository;

    @Override
    public List<PurchaseEntity> getByClient(int usId) {
        return purchaseCrudRepository.findByUsId(usId);
    }

    @Override
    public PurchaseEntity newPurchase(PurchaseEntity purchaseEntity) {
        return purchaseCrudRepository.save(purchaseEntity);
    }
}
