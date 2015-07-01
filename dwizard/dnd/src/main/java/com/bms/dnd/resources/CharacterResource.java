package com.bms.dnd.resources;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.annotation.*;
import com.codahale.metrics.annotation.Timed;

@Path("/character")
@Produces(MediaType.APPLICATION_JSON)
public class CharacterResource {

	private String name;

	@GET
	@Path("/{id}")
	@Timed
	public String getName(@PathParam("id") int id) {
		String s = "Thief";
		if (id == 1) s = "Paladin";
		if (id == 2) s = "Wizard";
		if (id == 3) s = "Cleric";
		
		return "{\"type\": \"" + s + "\"}";
	}

	@POST
	@Path("/{name}")
	public String createCharacter(@PathParam("name") String name) {
		return "{\"message\": \"The character " + name + " was created.\"}";
	}

	@GET
	@Path("/full")
	public String getFull() {
		FullChar fc = new FullChar("Baldur", "Druid", 5);
		ObjectMapper mapper = new ObjectMapper();
		String s = null;
		try {
			s = mapper.writeValueAsString(fc);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return s;
	}

	private class FullChar {
		private String name;
		private String type;
		private Integer level;
		FullChar(String name, String type, Integer level) {
			this.name = name;
			this.type = type;
			this.level = level;
		}
		@JsonProperty("name")
		public String getName() { return name; }
		@JsonProperty("type")
		public String getType() { return type; }
		@JsonProperty("level")
		public Integer getLevel() { return level; }
	}
}

