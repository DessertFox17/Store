package com.Vicio.Games.domain.repository;

import com.Vicio.Games.persistence.entity.PurchaseEntity;
import java.util.List;

public interface PurchaseDomaindRepository {
    List<PurchaseEntity> getByClient(int usId);
    PurchaseEntity newPurchase(PurchaseEntity purchaseEntity);
}
