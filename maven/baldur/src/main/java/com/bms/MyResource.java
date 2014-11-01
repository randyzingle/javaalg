package com.bms;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("myresource/{name}")
public class MyResource {

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt(@PathParam("name") String name) {
    	if (name == null) name = "baldur";
        return "Got it " + name +"!";
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getItJson() {
        return "{\"value\":\"Got it!\"}";
    }
}
