package com.elenildo.agenda_docker.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Instant;

@RestControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<?> entityNotFound(EntityNotFoundException e, HttpServletRequest request){
        DefaultError error = this.exceptionBodyBuider(e, request);
        error.setStatus(HttpStatus.NOT_FOUND.value());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    @ExceptionHandler(DuplicatedEntityException.class)
    public ResponseEntity<?> duplicatedEntity(DuplicatedEntityException e, HttpServletRequest request){
        DefaultError error = this.exceptionBodyBuider(e, request);
        error.setStatus(HttpStatus.CONFLICT.value());

        return ResponseEntity.status(HttpStatus.CONFLICT).body(error);
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<?> badRequest(BadRequestException e, HttpServletRequest request){
        DefaultError error = this.exceptionBodyBuider(e, request);
        error.setStatus(HttpStatus.BAD_REQUEST.value());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    private DefaultError exceptionBodyBuider(RuntimeException e, HttpServletRequest request){
        DefaultError error = new DefaultError();
        error.setTimestamp(Instant.now());
        error.setPath(request.getRequestURI());
        error.setMessage(e.getMessage());
        return error;
    }
}
