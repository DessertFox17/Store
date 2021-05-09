package com.Vicio.Games.exceptions;

import com.Vicio.Games.domain.dto.ErrorStatus;
import io.jsonwebtoken.ExpiredJwtException;
import javassist.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;

@RestControllerAdvice
@CrossOrigin(origins = "*", methods = {RequestMethod.POST, RequestMethod.GET, RequestMethod.PUT,
        RequestMethod.DELETE, RequestMethod.OPTIONS, RequestMethod.HEAD, RequestMethod.PATCH,
        RequestMethod.TRACE}, allowedHeaders = "*")
public class ErrorHandler extends Exception{

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NotFoundException.class)
    public Object notFound(NotFoundException e){

        ErrorStatus status = new ErrorStatus();

        status.setTimestamp(LocalDateTime.now());
        status.setCode(404);
        status.setStatus("Bad Request");
        status.setMessage(e.getMessage());

        return status;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(IllegalArgumentException.class)
    public Object badRequest(IllegalArgumentException e){

        ErrorStatus status = new ErrorStatus();

        status.setTimestamp(LocalDateTime.now());
        status.setCode(400);
        status.setStatus("Bad Request");
        status.setMessage(e.getMessage());

        return status;
    }

    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(SecurityException.class)
    public Object badRequest(SecurityException e){

        ErrorStatus status = new ErrorStatus();

        status.setTimestamp(LocalDateTime.now());
        status.setCode(401);
        status.setStatus("Unathorized");
        status.setMessage(e.getMessage());

        return status;
    }

    @ResponseStatus(HttpStatus.FORBIDDEN)
    @ExceptionHandler({IllegalAccessException.class,ExpiredJwtException.class})
    public Object badRequest(IllegalAccessException e){

        ErrorStatus status = new ErrorStatus();

        status.setTimestamp(LocalDateTime.now());
        status.setCode(403);
        status.setStatus("Forbiden");
        status.setMessage(e.getMessage());

        return status;
    }

}
