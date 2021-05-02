package com.Vicio.Games.domain.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class NewCommentDto {
    private int coId;
    private int prId;
    private int usId;
    private String comment;
    private float qualification;
}
