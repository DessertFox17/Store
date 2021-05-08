package com.Vicio.Games.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorStatus{
    private LocalDateTime timestamp;
    private int code;
    private String status;
    private String message;
}
