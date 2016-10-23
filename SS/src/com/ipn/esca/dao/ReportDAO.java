package com.nielsen.monitor.dao;

import java.util.List;

import com.nielsen.monitor.dto.EventlogDTO;
import com.nielsen.monitor.dto.ProcessSDTO;
import com.nielsen.monitor.dto.ProcessStepsDTO;
import com.nielsen.monitor.dto.SystemSDTO;
import com.nielsen.monitor.entities.eventlog.Eventlog;


public interface ReportDAO extends GenericDAO<Eventlog, Long> {
	
	List<String> getAllSystems();
	List<SystemSDTO> getAllSystems(SystemSDTO filter);
	List<EventlogDTO> getEventsByFilter(EventlogDTO filter);
	List<ProcessSDTO> getProcess(ProcessSDTO filter);
	List<ProcessStepsDTO> getProcessSteps(ProcessStepsDTO filter);
	
}