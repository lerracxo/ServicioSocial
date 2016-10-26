package com.nielsen.monitor.dao;

import java.util.List;

import com.nielsen.monitor.dto.FileValidationResultDTO;
import com.nielsen.monitor.dto.SystemSDTO;
import com.nielsen.monitor.entities.eventlog.Eventlog;


public interface PersonaDAO extends GenericDAO<Eventlog, Long> {
	
	
	
	List<FileValidationResultDTO> getFileValidationResultsByFilter(FileValidationResultDTO filter);

	List<FileValidationResultDTO> getFileValidationResultsBySystem(SystemSDTO filter);

	List<SystemSDTO> getSystemByFilter(SystemSDTO filter);

	
}