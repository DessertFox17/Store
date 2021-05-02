package com.Vicio.Games.domain.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ShowSubcategoryDto {

    private String name;
    private ShowCategoryDto category;
}
