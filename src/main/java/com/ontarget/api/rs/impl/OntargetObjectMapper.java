package com.ontarget.api.rs.impl;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.stereotype.Component;

import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;
import java.text.SimpleDateFormat;

/**
 * Created by Owner on 12/24/14.
 */
@Component
@Provider
public class OntargetObjectMapper implements ContextResolver<ObjectMapper> {

    private final ObjectMapper mapper;

    public OntargetObjectMapper() {
        this.mapper = createObjectMapper();
    }

    private static ObjectMapper createObjectMapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, true);
        mapper.setDateFormat(new SimpleDateFormat("MMM dd, yyyy HH:mm:ss"));
        mapper.configure(SerializationFeature.INDENT_OUTPUT, true);
        return mapper;
    }

    @Override
    public ObjectMapper getContext(Class<?> aClass) {
        return this.mapper;
    }


}
