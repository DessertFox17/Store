package com.Vicio.Games.domain.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class UpdateUserDto {
    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
    @NotNull
    private LocalDateTime birthDate;
    @NotNull
    private String address;
    @NotNull
    @Min(value = 1)
    private long phoneNumber;
}
