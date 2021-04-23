package com.Vicio.Games.persistence.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "status")
public class StatusEntity {

    //----------------TABLE COLUMNS---------------------------

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "status_id")
    private Integer stId;

    @Column(name = "st_name")
    private String name;

    //----------------RELATIONSHIPS---------------------------

    @OneToMany(mappedBy = "status")
    private List<PurchaseEntity> purchases;

}
