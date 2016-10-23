package com.nielsen.monitor.sb;
 
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.ipn2.esca.bs.ReportServiceLocal;
import com.ipn2.esca.bs.ReportServiceRemote;
import com.nielsen.monitor.dao.ReportDAO;
import com.nielsen.monitor.dto.EventlogDTO;
import com.nielsen.monitor.dto.ProcessSDTO;
import com.nielsen.monitor.dto.ProcessStepsDTO;
import com.nielsen.monitor.dto.SystemSDTO;
 
@Stateless
public class ReportServiceBean implements ReportServiceLocal, ReportServiceRemote{
  
	@EJB(lookup="java:module/ReportDAOBean")
	private ReportDAO service;
	

	@Override
	public List<EventlogDTO> getEvents(EventlogDTO filter) {
		return service.getEventsByFilter(filter);
	}
	
	@Override
	public List<SystemSDTO> getSystems(SystemSDTO filter){
		return service.getAllSystems(filter);
	}

	@Override
	public List<ProcessSDTO> getProcess(ProcessSDTO processFilter) {
		return service.getProcess(processFilter);
	}
	
	@Override 
	public List<ProcessStepsDTO> getProcessSteps(ProcessStepsDTO processStepsFilter){
		return service.getProcessSteps(processStepsFilter);
	}


	
 
}