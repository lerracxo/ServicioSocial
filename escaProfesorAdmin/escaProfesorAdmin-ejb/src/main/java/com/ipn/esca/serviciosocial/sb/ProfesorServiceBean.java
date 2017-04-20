package com.ipn.esca.serviciosocial.sb;

import com.ipn.esca.serviciosocial.bs.ProfesorIService;
import com.ipn.esca.serviciosocial.dao.ProfesorDAO;
import com.ipn.esca.serviciosocial.entities.Profesor;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.inject.Inject;

@Stateless
@Default
public class ProfesorServiceBean implements ProfesorIService {

    @EJB //(lookup="java:module/ProfesorDAOBean!com.ipn.esca.serviciosocial.dao.ProfesorDAO")
    @Inject
    private ProfesorDAO service;

    @Override
    public List<Profesor> getProfesoresByFilter(Profesor filter) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Profesor> getProfesoresByFilter(String filterProfessor) {
        return service.getProfesoresByFilter(filterProfessor);
    }

    @Override
    public List<Profesor> getProfesorById(String id) {
        return service.getProfessorById(id);
    }

    @Override
    public Profesor getProfessorDetail(Integer idPersona) {
        return service.getProfessorDetail(idPersona);
    }

}
