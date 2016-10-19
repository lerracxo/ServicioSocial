package com.nielsen.monitor.dao.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.log4j.Logger;

import com.nielsen.monitor.common.Converter;
import com.nielsen.monitor.dao.ValidationDAO;
import com.nielsen.monitor.dto.FileValidationResultDTO;
import com.nielsen.monitor.dto.SystemSDTO;
import com.nielsen.monitor.entities.SystemS;
import com.nielsen.monitor.entities.eventlog.Eventlog;
import com.nielsen.monitor.entities.validation.FileValidationResult;

@Stateless
public class ValidationDAOBean extends GenericDAOBean<Eventlog, Long> implements ValidationDAO {
	public static Logger LOG = Logger.getLogger(ValidationDAOBean.class);
	@PersistenceContext(name = "hbl_ds")
	private EntityManager em;

	@SuppressWarnings("unchecked")
	@Override
	public List<FileValidationResultDTO> getFileValidationResultsByFilter(FileValidationResultDTO filter) {
		StringBuilder sb = new StringBuilder("SELECT e FROM ").append(FileValidationResult.class.getSimpleName());
		sb.append(" e ");
		// Append of specific filters
		if(filter != null){
			if(filter.getSystemFile().getId().getSystemCod() != null){
				sb.append(" e.systemFile.id.systemCod = ").append(filter.getSystemFile().getId().getSystemCod());
			}
		}
		
		Query query = em.createQuery(sb.toString());
			
		return Converter.toListFileValidationsResultDTO(query.getResultList());
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<FileValidationResultDTO> getFileValidationResultsBySystem(SystemSDTO filter) {
		StringBuilder sb = new StringBuilder("SELECT e FROM ").append(FileValidationResult.class.getSimpleName());
		sb.append(" e WHERE 1=1 ");
		// Append of specific filters
		if(filter != null){
			if(filter.getSystem_cod() != null){
				sb.append(" AND e.systemCod = '").append(filter.getSystem_cod()).append("' ");
			}
		}
		sb.append(" ORDER BY e.systemCod, e.regDte ");
		
		Query query = em.createQuery(sb.toString());
		//query.setMaxResults(10);
			
		return Converter.toListFileValidationsResultDTO(query.getResultList());
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<SystemSDTO> getSystemByFilter(SystemSDTO filter){
		
		StringBuilder sb = new StringBuilder("SELECT e FROM ").append(SystemS.class.getSimpleName()).append(" e ");
		sb.append(" WHERE 1=1 ");
		
		if(filter != null){
			if(filter.getSystem_cod() != null)
				sb.append(" AND e.systemCod ='").append(filter.getSystem_cod()).append("'");
			
		}
		
		Query query = em.createQuery(sb.toString());
		
		return Converter.toDTOSystemS(query.getResultList());
	}
	
	

	


	
}
