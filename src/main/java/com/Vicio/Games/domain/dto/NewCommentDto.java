package com.Vicio.Games.domain.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Min;

@Data
@NoArgsConstructor
public class NewCommentDto {

    private int coId;

    @NotNull
    @Min(value = 1, message = "Mandatory field")
    private int prId;

    @NotNull
    @Min(value = 1, message = "Mandatory field")
    private int usId;

    @NotNull(message = "Mandatory field")
    private String comment;

    @NotNull
    @Min(value = 0, message = "Mandatory field")
    private float qualification;
}
