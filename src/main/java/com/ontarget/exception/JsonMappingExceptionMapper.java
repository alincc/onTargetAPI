package com.ontarget.exception;

import com.fasterxml.jackson.databind.JsonMappingException;
import org.springframework.validation.Errors;

@SuppressWarnings("serial")
public class JsonMappingExceptionMapper extends JsonMappingException {
    private Errors errors;

    public JsonMappingExceptionMapper(String message, Errors errors) {
        super(message);
        this.errors = errors;
    }

    public Errors getErrors() { return errors; }
}
