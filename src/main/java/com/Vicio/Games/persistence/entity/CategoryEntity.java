package com.Vicio.Games.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "category")
public class CategoryEntity {

    //----------------TABLE COLUMNS-------------------------

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private Integer catId;

    @Column(name = "cat_name")
    private String name;

    @Column(name = "cat_descript")
    private String description;

    @Column(name = "cat_status")
    private Boolean active;

    //----------------RELATIONSHIPS--------------------------

    @OneToMany(mappedBy = "category")
    private List<SubcategoryEntity> subcategories;
}