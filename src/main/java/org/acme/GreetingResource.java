package org.acme;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.acme.types.first.FirstExampleType;
import org.acme.types.second.SecondExampleType;
import org.acme.types.third.ThirdExampleType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Path("/hello")
public class GreetingResource {

    private final Logger logger = LoggerFactory.getLogger(getClass());


    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello from Quarkus REST";
    }


    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/first")
    public void first(final FirstExampleType firstExampleType) {
        logger.info(firstExampleType.toString());
    }


    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/second")
    public void second(final SecondExampleType secondExampleType) {
        logger.info(secondExampleType.toString());
    }


    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/third")
    public void third(final ThirdExampleType thirdExampleType) {
        logger.info(thirdExampleType.toString());
    }
}
