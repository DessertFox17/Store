package com.Vicio.Games.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.FORBIDDEN)
public class Forbiden extends Exception{

    public Forbiden(String message) {
        super(message);
    }

    public Forbiden(String message, Throwable cause) {
        super(message, cause);
    }
}
