package com.Vicio.Games.domain.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class UserDto {

    private int uId;
    private String firstName;
    private String lastName;
    private int idNumber;
    private String idType;
    private LocalDateTime birthDate;
    private LocalDateTime regDate;
    private String address;
    private long phoneNumber;
    private String email;
    private String password;
    private Boolean active;
    private int rId;
}
