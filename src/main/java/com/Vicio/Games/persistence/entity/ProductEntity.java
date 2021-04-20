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
@Table(name = "product")
public class ProductEntity {

    //----------------TABLE COLUMNS-------------------------

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Integer prId;

    @Column(name = "subcategory_id")
    private Integer scId;

    @Column(name = "pr_name")
    private String name;

    @Column(name = "pr_price")
    private Double price;

    @Column(name = "pr_stock")
    private Integer stock;

    @Column(name = "pr_sendcost")
    private Double shipCost;

    @Column(name = "pr_tumbnail")
    private String tumbnail;

    @Column(name = "pr_publicdate")
    private LocalDateTime publicDate;

    @Column(name = "pr_descript")
    private String description;

    @Column(name = "pr_details")
    private String details;

    @Column(name = "pr_searchcount")
    private Integer searchCounter;

    @Column(name = "pr_status")
    private Boolean active;

    //----------------RELATIONSHIPS--------------------------

/*    @ManyToOne
    @JoinColumn(name = "subcategory_id", insertable = false, updatable = false)
    private SubcategoryEntity pSubcategory;

    @OneToMany(mappedBy = "pProduct" )
    private List<ImageEntity> pImages;*/

    @OneToMany(mappedBy = "product" )
    private List<CommentEntity> comments;

/*    @OneToMany(mappedBy = "pProduct")
    private List<ProductPurchaseEntity> pPurchases;*/
}
