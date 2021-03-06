package com.Vicio.Games.domain.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
public class NewPurchaseDto {

    private int puId;

    @NotNull
    @Min(value = 1)
    private int stId;

    @NotNull
    @Min(value = 1)
    private int usId;

    @NotNull
    private LocalDateTime date;

    @NotNull
    private String payMethod;

    @NotNull
    private String comment;

    @NotNull
    private List<NewProductPurchaseDto> products;

}
