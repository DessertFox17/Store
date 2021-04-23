package com.Vicio.Games.domain.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CommentsListDto {
    private UserListDto user;
    private String comment;
    private float qualification;
}
