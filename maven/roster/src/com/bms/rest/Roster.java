package com.bms.rest;

import javax.ws.rs.*;
import javax.ws.rs.core.*;

@javax.ws.rs.Path("/roster")
public class Roster {
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String getTPRoster() {
		String s = "[{\"name\":\"teachanator\", \"role\":\"ROLE_TEACHER\"},"
				+ "{\"name\":\"mymir\", \"role\":\"ROLE_STUDENT\"},"
				+ "{\"name\":\"baldur\", \"role\":\"ROLE_STUDENT\"}]";
		return s;
	}

}
