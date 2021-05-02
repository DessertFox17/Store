package com.Vicio.Games.domain.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
public class NewPurchaseDto {

    private int puId;
    private int stId;
    private int usId;
    private LocalDateTime date;
    private String payMethod;
    private String comment;
    private List<NewProductPurchaseDto> products;
    private NewStatusDto status;
}
