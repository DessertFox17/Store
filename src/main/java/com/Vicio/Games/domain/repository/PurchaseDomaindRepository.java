package com.Vicio.Games.domain.repository;

import com.Vicio.Games.persistence.entity.PurchaseEntity;
import java.util.List;
import java.util.Optional;

public interface PurchaseDomaindRepository {
    List<PurchaseEntity> getByClient(int usId);
    List<PurchaseEntity> getByUserandStatus(int usId, int stId);
    Optional<PurchaseEntity> getById(int puId);
    PurchaseEntity newPurchase(PurchaseEntity purchaseEntity);
    PurchaseEntity updatePurchase(PurchaseEntity purchaseEntity);
}
