package com.ipn.esca.bs;

import java.util.List;

import com.nielsen.monitor.dto.FileValidationResultDTO;
import com.nielsen.monitor.dto.SystemSDTO;

public interface ValidationIService {

	List<FileValidationResultDTO> getFileValidationResultsByFilter(FileValidationResultDTO filter);
	List<FileValidationResultDTO> getFileValidationResultsBySystem(SystemSDTO filter);
	List<SystemSDTO> getSystemByFilter(SystemSDTO filter);


}
