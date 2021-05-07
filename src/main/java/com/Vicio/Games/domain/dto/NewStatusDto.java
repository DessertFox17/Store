package com.Vicio.Games.domain.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
public class NewStatusDto {
    @NotNull
    @Min(value = 1)
    private int stId;

    @NotNull
    private String name;
}
