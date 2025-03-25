package com.elenildo.agenda_docker.exception;

import java.io.Serializable;

public class FieldMessage {
    private String fieldName;
    private String message;

    /**************************************/

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
