package com.Vicio.Games.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "purchase")
public class PurchaseEntity {

    //----------------TABLE COLUMNS-------------------------

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Purchase_id")
    private Integer puId;

    @Column(name = "status_id")
    private Integer stId;

    @Column(name = "user_id")
    private Integer uId;

    @Column(name = "p_date")
    private LocalDateTime date;

    @Column(name = "p_paymeth")
    private String payMethod;

    @Column(name = "p_comment")
    private String comment;

    //----------------RELATIONSHIPS--------------------------

    @ManyToOne
    @JoinColumn(name = "status_id", insertable = false, updatable = false)
    private StatusEntity status;

    @ManyToOne
    @JoinColumn(name = "user_id",insertable = false, updatable = false)
    private UserEntity user;

    @OneToMany(mappedBy = "purchase", cascade = {CascadeType.ALL})
    private List<ProductPurchaseEntity> products;

}
