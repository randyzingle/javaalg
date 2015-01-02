package com.bms.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Root resource (exposed at "roster" path)
 */
@Path("roster")
public class Resources {

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "application/json" media type.
     *
     * @return String that will be returned as json roster data.
     */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String getTPRoster() {
		String s = "[{\"name\":\"teachanator\", \"role\":\"ROLE_TEACHER\"},"
				+ "{\"name\":\"mymir\", \"role\":\"ROLE_STUDENT\"},"
				+ "{\"name\":\"baldur\", \"role\":\"ROLE_STUDENT\"}]";
		return s;
	}
}
