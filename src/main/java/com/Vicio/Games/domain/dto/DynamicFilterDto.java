package com.Vicio.Games.domain.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DynamicFilterDto {
    private int prId;
    private String name;
    private int stock;
    private double price;
    private String tumbnail;
}
