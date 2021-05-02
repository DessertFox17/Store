package com.Vicio.Games.domain.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ShowCommentsDto {
    private ShowUserDto user;
    private String comment;
    private float qualification;
}
