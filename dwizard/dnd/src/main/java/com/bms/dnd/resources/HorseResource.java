package com.bms.dnd.resources;

import com.bms.dnd.core.Horse;
import com.bms.dnd.db.HorseDAO;
import io.dropwizard.hibernate.UnitOfWork;
import com.google.common.base.Optional;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import java.util.List;

@Path("/course")
@Produces(MediaType.APPLICATION_JSON)
public class HorseResource {

    private final HorseDAO horseDAO;

    public HorseResource(HorseDAO horseDAO) {
        this.horseDAO = horseDAO;
    }

    @GET
    @Path("/{id}")
    @UnitOfWork
    public Horse getCourse(@PathParam("id") long id) {
        Horse rc = findSafely(id);
        return rc;
    }

    @DELETE
    @Path("/{id}")
    @UnitOfWork
    public void deleteCourse(@PathParam("id") long id) {
        Horse rc = findSafely(id);
        horseDAO.delete(rc);
    }

    @GET
    @UnitOfWork
    public List<Horse> listCourses() {
        return horseDAO.findAll();
    }

    @POST
    @UnitOfWork
    public Horse createCourse(Horse course) {
        return horseDAO.create(course);
    }

    private Horse findSafely(long id) {
        final Optional<Horse> course = horseDAO.findById(id);
        if (!course.isPresent()) {
            throw new NotFoundException("No such course.");
        }
        return course.get();
    }
}
