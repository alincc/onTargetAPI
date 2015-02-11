package com.ontarget.exception;

import org.codehaus.jackson.map.JsonMappingException;
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
