package com.ontarget.api.config;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.ontarget.api.filter.AuthorizationFilter;
import org.apache.log4j.Logger;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * Created by sanjeevghimire on 1/5/16.
 */
@Provider
public class JsonProcessingExceptionMapper implements ExceptionMapper<JsonProcessingException>{

    private Logger logger = Logger.getLogger(AuthorizationFilter.class);

    public static class Error {
        public String key;
        public String message;
    }

    @Override
    public Response toResponse(JsonProcessingException exception) {
        logger.error("Bad Json",exception);
        Error error = new Error();
        error.key = "bad-json";
        error.message = exception.getMessage();
        return Response.status(Response.Status.BAD_REQUEST).entity(error).build();
    }

}
