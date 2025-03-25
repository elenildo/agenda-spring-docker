package com.elenildo.agenda_docker.exception;

public class DuplicatedEntityException extends RuntimeException{
    public DuplicatedEntityException(String message) {
        super(message);
    }
}
