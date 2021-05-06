package com.Vicio.Games.domain.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
public class NewImageDto {

    private int imId;

    @NotNull
    @Min(value = 1, message = "Mandatory field")
    private int prId;

    @NotNull(message = "Mandatory field")
    private String url;

}
