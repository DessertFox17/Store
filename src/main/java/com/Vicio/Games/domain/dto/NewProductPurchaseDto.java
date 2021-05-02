package com.Vicio.Games.domain.dto;

import com.Vicio.Games.persistence.repository.ProductPersisteceRepository;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class NewProductPurchaseDto {
    private int prId;
    private int quantity;
    private double totShipCost;
    private double totProdsCost;
    private double purchaseCost;
}
