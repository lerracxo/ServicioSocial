package com.ipn.esca.serviciosocial.dao.impl;

import java.util.List;
import org.apache.log4j.Logger;
import com.ipn.esca.serviciosocial.dao.ProfesorDAO;
import com.ipn.esca.serviciosocial.entities.Profesor;
import java.util.ArrayList;
import javax.ejb.Stateless;

@Stateless
public class ProfesorDAOBean extends GenericDAOBean<ProfesorDAOBean, Object> implements ProfesorDAO {

    public static Logger LOG = Logger.getLogger(ProfesorDAOBean.class);

    @Override
    public List<Profesor> getProfessorById(String id) {
        String sql = new StringBuilder().append(" SELECT e FROM ").append(Profesor.class.getSimpleName())
                .append(" e ").append(" WHERE e.persona.id = '").append(id).append("'").toString();
        System.out.println("SQL by ID " + sql);
        return em.createQuery(sql, Profesor.class).getResultList();
    }

    @Override
    public List<Profesor> getProfesoresByFilter(String filter) {
        if (filter == null || filter.length() == 0) {
            return new ArrayList<>();
        }
        String likeStmt = "'";
        for (String word : filter.trim().toUpperCase().split(" ")) {
            likeStmt = likeStmt + ".*"+word;
        }
        likeStmt = likeStmt + ".*'";

        StringBuilder bs = new StringBuilder();
        bs.append(" SELECT e FROM ").append(Profesor.class.getSimpleName())
                .append(" e ")
                .append(" WHERE ")
                .append(" CONCAT( ")
                .append(" COALESCE(UPPER(e.persona.nombres),'') ").append(",")
                .append(" COALESCE(UPPER(e.persona.aMaterno),'') ").append(",")
                .append(" COALESCE(UPPER(e.persona.aPaterno),'') ").append(",")
                .append(" COALESCE(UPPER(e.persona.nacionalidad),'') ")
                .append(")")
                .append(" REGEXP ")
                .append(likeStmt) 
                ;
        System.out.println("SQL: " + bs.toString());

        return em.createQuery(bs.toString(), Profesor.class).getResultList();
    }

    @Override
    public Profesor getProfessorDetail(Integer idProfesor) {
        if(idProfesor == null)
            return null;
        return em.find(Profesor.class,idProfesor);
    }
}
