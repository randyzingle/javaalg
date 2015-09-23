package com.bms.base.resources;

import io.dropwizard.hibernate.UnitOfWork;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.bms.base.core.Pet;
import com.bms.base.db.PetDAO;

@Path("/api/pets")
@Produces(MediaType.APPLICATION_JSON)
public class PetResource {
	
	private PetDAO dao;
	
	public PetResource(){}
	
	public PetResource(PetDAO dao) {
		this.dao = dao;
	}
	
    @GET
    @UnitOfWork
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPets() {
    	List<Pet> list = dao.findAll();
    	for (Pet p : list) {
    		System.out.println(p);
    	}
        return Response.ok(list).build();
    }
    
    @Path("/{name}")
    @GET
    @UnitOfWork
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPet(@PathParam("name") String name) {
    	return Response.ok(dao.findByName(name)).build();
    }

}
