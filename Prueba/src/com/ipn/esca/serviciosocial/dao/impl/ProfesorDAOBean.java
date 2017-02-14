package com.ipn.esca.serviciosocial.dao.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;

import com.ipn.esca.serviciosocial.dao.ProfesorDAO;
import com.ipn.esca.serviciosocial.entities.Profesor;

@Stateless
public class ProfesorDAOBean extends GenericDAOBean<Profesor, Long> implements ProfesorDAO {
	public static Logger LOG = Logger.getLogger(ProfesorDAOBean.class);
	
	@PersistenceContext(name = "serviciosocial_ds")
	private EntityManager em;


	@Override
	public List<Profesor> getAllProfesores() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Profesor> getProfessorById(String id){
		String sql = new StringBuilder().append(" SELECT e FROM ").append(Profesor.class.getSimpleName())
				.append(" e ").append(" WHERE e.persona.id = '").append(id).append("'").toString();
		System.out.println("SQL by ID "+sql);
		return em.createQuery(sql,Profesor.class).getResultList();
	}


	@Override
	public List<Profesor> getProfesoresByFilter(String filter) {
		StringBuilder bs = new StringBuilder();
		bs.append(" SELECT e FROM ").append(Profesor.class.getSimpleName())
		.append(" e ")
		.append(" WHERE 1=1 ");
		if(filter != null){
			String likeStmt = "LIKE '%".concat(filter.trim()).concat("%'");
			bs.append(" AND ( ")
			.append(" e.persona.nombres ").append(likeStmt)
			.append(" OR ")
			.append(" e.persona.aMaterno ").append(likeStmt)
			.append(" OR ")
			.append(" e.persona.aPaterno ").append(likeStmt)
			.append("OR")
			.append(" e.persona.nacionalidad ").append(likeStmt)
			.append(" ) ");
		}
		return  em.createQuery(bs.toString(),Profesor.class).getResultList();
	}

//	private List<EventlogDTO> toDTOListEventlogDTO(List<Eventlog> list) {
//		if (list == null || list.isEmpty())
//			return null;
//
//		List<EventlogDTO> result = new ArrayList<EventlogDTO>();
//		for (Eventlog l : list) {
//			result.add(new EventlogDTO(l));
//		}
//		return result;
//	}
	

	
}
