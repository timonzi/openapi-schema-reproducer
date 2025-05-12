package org.acme;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import org.acme.types.UseNativeTypeType;
import org.acme.types.UseSchemaImplementationType;
import org.acme.types.UseSchemaRefType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Path("/schema")
public class GreetingResource {

    private final Logger logger = LoggerFactory.getLogger(getClass());


    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/UseSchemaImplementationType")
    public void first(final UseSchemaImplementationType type) {
        logger.info(type.toString());
    }


    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/UseSchemaRefType")
    public void second(final UseSchemaRefType type) {
        logger.info(type.toString());
    }


    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/UseNativeTypeType")
    public void third(final UseNativeTypeType type) {
        logger.info(type.toString());
    }
}
