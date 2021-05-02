package com.Vicio.Games.domain.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class NewImageDto {
    private int imId;
    private int prId;
    private String url;

}
