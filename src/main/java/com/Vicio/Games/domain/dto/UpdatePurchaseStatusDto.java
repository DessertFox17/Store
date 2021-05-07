package com.Vicio.Games.domain.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
public class UpdatePurchaseStatusDto {
    @NotNull
    @Min(value = 1)
    private int puId;
    @NotNull
    @Min(value = 1)
    private int stId;
    @NotNull
    @Min(value = 1)
    private int usId;
}
