package com.ipn.esca.serviciosocial.sb;

import com.ipn.esca.serviciosocial.bs.ProfesorIService;
import com.ipn.esca.serviciosocial.entities.Profesor;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import java.util.List;
import javax.ws.rs.core.MediaType;


/**
 *
 * Created by omar on 2/13/17.
 */
@Path("/professor")
public class ProfessorService {

    @EJB(lookup = "java:module/ProfesorServiceBean!com.ipn.esca.serviciosocial.bs.ProfesorIService")
    @Inject
    private ProfesorIService service;

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Profesor> getProfessorById(@PathParam("id") String id ) {
        return service.getProfesorById(id);
    }

    @GET
    @Path("/generic/{string}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Profesor> getProfessorByGenericFilter(@PathParam("string") String string ) {
        return service.getProfesoresByFilter(string);
    }



}
