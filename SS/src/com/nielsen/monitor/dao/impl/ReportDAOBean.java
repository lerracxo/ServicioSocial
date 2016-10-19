package com.nielsen.monitor.dao.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.log4j.Logger;

import com.nielsen.monitor.common.Converter;
import com.nielsen.monitor.dao.ReportDAO;
import com.nielsen.monitor.dto.EventlogDTO;
import com.nielsen.monitor.dto.GenericDTO;
import com.nielsen.monitor.dto.ProcessSDTO;
import com.nielsen.monitor.dto.ProcessStepsDTO;
import com.nielsen.monitor.dto.SystemSDTO;
import com.nielsen.monitor.entities.SystemS;
import com.nielsen.monitor.entities.eventlog.Eventlog;
import com.nielsen.monitor.entities.eventlog.ProcessS;
import com.nielsen.monitor.entities.eventlog.ProcessSteps;

@Stateless
public class ReportDAOBean extends GenericDAOBean<Eventlog, Long> implements ReportDAO {
	public static Logger LOG = Logger.getLogger(ReportDAOBean.class);
	@PersistenceContext(name = "hbl_ds")
	private EntityManager em;

//	@Override
//	@Deprecated
//	public List<EventlogDTO> getAllEvents() {
//		StringBuilder sq = new StringBuilder("SELECT e FROM Eventlog e");
//		Query query = this.em.createQuery(sq.toString()).setMaxResults(1000);
//		List<Eventlog> list = query.getResultList();
//		return toDTOListEventlogDTO(list);
//	}
	
	@SuppressWarnings("unchecked")
	@Override 
	@Deprecated
	public List<String> getAllSystems() {
		StringBuilder sq = new StringBuilder("SELECT DISTINCT e.system_cod FROM Eventlog e");
		Query query = this.em.createQuery(sq.toString());
		return query.getResultList()== null || query.getResultList().isEmpty()? null : query.getResultList();
	} 
	
	@SuppressWarnings("unchecked")
	@Override 
	public List<SystemSDTO> getAllSystems(SystemSDTO filter){
		StringBuilder sq = new StringBuilder("SELECT a FROM ");
		sq.append(SystemS.class.getSimpleName()).append(" a ");
		sq.append(" WHERE 1=1 ");
		
		// Validate generally for the filter
		if(filter !=null ){
			if(filter.getSystem_dsc() !=null && !filter.getSystem_dsc().isEmpty())
				sq.append(" AND systemDsc LIKE '%").append(filter.getSystem_dsc()).append("%' ");
		}
		sq.append(" ORDER BY a.systemDsc ");
		Query query = this.em.createQuery(sq.toString());
		return Converter.toDTOSystemS(query.getResultList());
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<ProcessStepsDTO> getProcessSteps(ProcessStepsDTO filter){
		StringBuilder sq = new StringBuilder(" SELECT DISTINCT e FROM ");
		sq.append(ProcessSteps.class.getSimpleName()).append(" e ");
		sq.append(" WHERE 1=1 ");
		if(filter != null){
			if(filter.getProcess_id() != null && filter.getProcess_id() != 0)
				sq.append(" AND e.process_id =").append(filter.getProcess_id());
//			if(filter.getStep_order() != null && filter.getStep_order() !=0)
//				sq.append(" AND e.step_order=").append(filter.getStep_order());
			if(filter.getStep_name() != null && !filter.getStep_name().isEmpty()){
				sq.append(" AND e.step_name = '").append(filter.getStep_name()).append("'");
			}
		}
		
		sq.append(" ORDER BY e.step_order ");
		Query query = this.em.createQuery(sq.toString());
		return Converter.toDTOListProcessSteps(query.getResultList());
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<ProcessSDTO> getProcess(ProcessSDTO filter){
		StringBuilder sq = new StringBuilder(" SELECT e FROM ");
		sq.append(ProcessS.class.getSimpleName());
		sq.append(" e WHERE 1=1 ");
		
		if(filter != null){
			if(filter.getSystem_cod() != null && !filter.getSystem_cod().isEmpty()){
				sq.append(" AND system_cod = '").append(filter.getSystem_cod()).append("' ");
			}
		}
		
		sq.append(" ORDER BY process_name");
		Query query = this.em.createQuery(sq.toString());
		
		return Converter.toDTOListProcessSDTO(query.getResultList());
	} 


	@SuppressWarnings("unchecked")
	@Override
	public List<EventlogDTO> getEventsByFilter(EventlogDTO filter) {
		StringBuilder sq = new StringBuilder("SELECT country_id,system_cod,process_id,step,periodid,eventtype,source,")
				.append("servername,database,message,time,severity ")
				.append(" FROM config.eventlog e WHERE 1=1 ");
		if(filter != null){
			if(filter.getSystem_cod() != null && !filter.getSystem_cod().isEmpty())
				sq.append(" AND e.system_cod = '").append(filter.getSystem_cod().trim()).append("'");
			if(filter.getProcess_id() !=null && filter.getProcess_id() != 0)
				sq.append(" AND e.process_id = ").append(filter.getProcess_id());
			if(filter.getStep() != null && filter.getStep() != 0)
				sq.append(" AND e.step = ").append(filter.getStep());
		}
		
		sq.append(" ORDER BY e.time DESC");
		Query query = this.em.createNativeQuery(sq.toString());
		
		
		return Converter.toDTOListEventlogDTO(query.getResultList());
	}
	
	@SuppressWarnings("unchecked")
	public List<GenericDTO> getDTOBySQL(GenericDTO arg, String sql){
		Query query = this.em.createNativeQuery(sql);
		return Converter.toGenericDTO(arg,query.getResultList());
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
