package com.nielsen.monitor.sb;
 
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.ipn2.esca.bs.ValidationServiceLocal;
import com.ipn2.esca.bs.ValidationServiceRemote;
import com.nielsen.monitor.dao.ValidationDAO;
import com.nielsen.monitor.dto.FileValidationResultDTO;
import com.nielsen.monitor.dto.SystemSDTO;
 
@Stateless
public class ValidationServiceBean implements ValidationServiceLocal, ValidationServiceRemote{
  
	@EJB(lookup="java:module/ValidationDAOBean")
	private ValidationDAO service; 
	
	@Override
	public List<FileValidationResultDTO> getFileValidationResultsByFilter(FileValidationResultDTO filter){
		return service.getFileValidationResultsByFilter(filter);
	}
	
	@Override
	public List<FileValidationResultDTO> getFileValidationResultsBySystem(SystemSDTO filter){
		List<FileValidationResultDTO> result = service.getFileValidationResultsBySystem(filter);
		return result;
	}
	
	@Override
	public List<SystemSDTO> getSystemByFilter(SystemSDTO filter){
		return service.getSystemByFilter(filter);
	}
	
}