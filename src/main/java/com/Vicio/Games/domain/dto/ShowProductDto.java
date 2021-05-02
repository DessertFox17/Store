package com.Vicio.Games.domain.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ShowProductDto {
    private String name;
    private double price;
    private double shipCost;
    private String tumbnail;
}
