package com.Vicio.Games.domain.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
public class ProductDto {
    private int prId;
    private int scId;
    private String name;
    private double price;
    private int stock;
    private double shipCost;
    private String tumbnail;
    private LocalDateTime publicDate;
    private String description;
    private String details;
    private int searchCounter;
    private boolean active;
    private List<CommentsListDto> comments;
    private List<ImageListDto> images;
    private SubcategoryDto subcategory;
}
