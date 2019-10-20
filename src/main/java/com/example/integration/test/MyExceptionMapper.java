package com.example.integration.test;

import javax.ws.rs.ProcessingException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class MyExceptionMapper implements ExceptionMapper<ProcessingException> {
    @Override
    public Response toResponse(ProcessingException exception) {
        System.out.println("exception = " + exception);
        exception.printStackTrace();
        return Response.serverError().entity("failed").build();
    }
}
