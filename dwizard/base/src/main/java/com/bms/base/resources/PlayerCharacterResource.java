package com.bms.base.resources;

import io.dropwizard.hibernate.UnitOfWork;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.bms.base.core.PlayerCharacter;
import com.bms.base.db.PlayerCharacterDAO;



@Path("/api/playercharacters")
@Produces(MediaType.APPLICATION_JSON)
public class PlayerCharacterResource {
	
	private PlayerCharacterDAO dao;
	
	public PlayerCharacterResource(){}
	
	public PlayerCharacterResource(PlayerCharacterDAO dao) {
		this.dao = dao;
	}
	
    @GET
    @UnitOfWork
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPlayerCharacters() {
    	List<PlayerCharacter> list = dao.findAll();
    	for (PlayerCharacter pc : list) {
    		System.out.println(pc);
    	}
        return Response.ok(list).build();
    }
    
    @Path("/{name}")
    @GET
    @UnitOfWork
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPlayerCharacter(@PathParam("name") String name) {
    	return Response.ok(dao.findByName(name)).build();
    }

}
