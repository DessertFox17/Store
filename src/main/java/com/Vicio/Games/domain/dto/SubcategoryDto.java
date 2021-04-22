package com.Vicio.Games.domain.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SubcategoryDto {

    private String name;
    private String description;
    private CategoryDto category;
}
