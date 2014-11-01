package com.bms.rest;

import javax.ws.rs.*;
import javax.ws.rs.core.*;

@Path("hello")
public class Hello {
	
	@GET
	@Produces(MediaType.TEXT_HTML)
	public String sayHtmlHello() {
		return "<html><body><h2>Hello from Jersey</h2></body></html>";
	}
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String sayTextHello() {
		return "Hello there from Jersey's text engine!";
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String sayJSONHello() {
		return "{\"name\":\"baldur\"}";
	}

}
