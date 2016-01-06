package com.ontarget.api.config;

import org.apache.log4j.Logger;

import javax.inject.Singleton;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * Created by sanjeevghimire on 1/5/16.
 */
@Provider
@Singleton
public class JsonProcessingExceptionMapper implements ExceptionMapper<Exception>{

    private Logger logger = Logger.getLogger(JsonProcessingExceptionMapper.class);

    public static class Error {
        public String key;
        public String message;
    }

    @Override
    public Response toResponse(Exception exception) {
        logger.error("Bad Json",exception);
        Error error = new Error();
        error.key = "bad-json";
        error.message = exception.getMessage();
        return Response.status(Response.Status.BAD_REQUEST).entity(error).build();
    }

}
