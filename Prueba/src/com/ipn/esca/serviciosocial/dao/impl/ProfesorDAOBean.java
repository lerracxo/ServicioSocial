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
