package com.Vicio.Games.domain.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.AssertTrue;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class NewUserDto {

    private int usId;

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    @Min(value = 1)
    @NotNull
    private int idNumber;

    @NotNull
    private String idType;

    @NotNull
    private LocalDateTime birthDate;

    @NotNull
    private LocalDateTime regDate;

    @NotNull
    private String address;

    @Min(value = 1)
    @NotNull
    private long phoneNumber;

    @NotNull
    @Email
    private String email;

    @NotNull
    private String password;

    @NotNull
    @AssertTrue
    private Boolean active;

    @NotNull
    private int roId;
}
