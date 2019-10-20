package com.example.integration.test;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@RegisterRestClient
public interface FaqServiceClient {
    @GET
    @Path("answers")
    String getAnswers();
}