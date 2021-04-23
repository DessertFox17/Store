package com.Vicio.Games.persistence.entity;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class UserEntity {

    //----------------TABLE COLUMNS-------------------------

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Integer uId;

    @Column(name = "role_id")
    private Integer rId;

    @Column(name = "u_fname")
    private String firstName;

    @Column(name = "u_lname")
    private String lastName;

    @Column(name = "u_dninumbr")
    private Integer idNumber;

    @Column(name = "u_dnitype")
    private String idType;

    @Column(name = "u_birthdate")
    private LocalDateTime birthDate;

    @Column(name = "u_regdate")
    private LocalDateTime regDate;

    @Column(name = "u_address")
    private String address;

    @Column(name = "u_phonenumbr")
    private Long phoneNumber;

    @Column(name = "u_email")
    private String email;

    @Column(name = "u_password")
    private String password;

    @Column(name = "u_status")
    private Boolean active;

    //----------------RELATIONSHIPS--------------------------

    @ManyToOne
    @JoinColumn(name = "role_id", updatable = false, insertable = false)
    private RoleEntity role;

/*    @OneToMany(mappedBy = "pUser")
    private List<PurchaseEntity> pPurchases;*/

    @OneToMany(mappedBy = "user")
    private List<CommentEntity> comments;
}