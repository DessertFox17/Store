package com.Vicio.Games.domain.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
public class ShowPurchaseDto {
    private int puId;
    private LocalDateTime date;
    private String payMethod;
    private String comment;
    private ShowStatusDto status;
    private List<ShowProductPurchaseDto> products;

}
