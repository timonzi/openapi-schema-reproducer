package org.acme;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import org.acme.types.UseNativeType;
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
    public void useSchemaImplementationType(final UseSchemaImplementationType type) {
        logger.info(type.toString());
    }


    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/UseSchemaRefType")
    public void useSchemaRefType(final UseSchemaRefType type) {
        logger.info(type.toString());
    }


    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/UseNativeType")
    public void useNativeType(final UseNativeType type) {
        logger.info(type.toString());
    }
}
