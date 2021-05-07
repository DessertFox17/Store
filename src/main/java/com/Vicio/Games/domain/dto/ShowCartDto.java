package com.Vicio.Games.domain.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@NoArgsConstructor
public class ShowCartDto {
    private List<ShowCartProductsDto> products;
}
