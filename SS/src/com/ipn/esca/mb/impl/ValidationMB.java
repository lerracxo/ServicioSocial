package com.nielsen.monitor.mb.impl;


import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.apache.log4j.Logger;

import com.ipn2.esca.bs.ReportIService;
import com.ipn2.esca.bs.ValidationIService;
import com.nielsen.monitor.dto.FileValidationResultDTO;
import com.nielsen.monitor.dto.SystemSDTO;

@ManagedBean(name = "validationMB")
@ViewScoped
public class ValidationMB extends GenericMB implements Serializable {
	
	private static final long serialVersionUID = -7613979662410783496L;
	private static Logger LOG = Logger.getLogger(ValidationMB.class);
	
	@EJB(lookup="java:module/ReportServiceBean!com.nielsen.monitor.bs.ReportServiceLocal")
	private ReportIService serviceReport;
	
	@EJB(lookup="java:module/ValidationServiceBean!com.nielsen.monitor.bs.ValidationServiceLocal")
	private ValidationIService serviceValidation;
	
	private List<FileValidationResultDTO> listValidationResult;
	private SystemSDTO systemFilter;
	private List<SystemSDTO> listSystemFilter;
	
	@PostConstruct
	private void init(){
		if(LOG.isDebugEnabled()){
			LOG.debug("Prueba :)"); 
		}
		systemFilter = new SystemSDTO();
		listSystemFilter = serviceValidation.getSystemByFilter(null);
	}
	
	public void populateValidations(){
		if(systemFilter != null && systemFilter.getSystem_cod() != null)
		listValidationResult = serviceValidation.getFileValidationResultsBySystem(systemFilter);
	}
	
	
	
	
	/**
	 * @return the systemFilter
	 */
	public SystemSDTO getSystemFilter() {
		return systemFilter;
	}

	/**
	 * @param systemFilter the systemFilter to set
	 */
	public void setSystemFilter(SystemSDTO systemFilter) {
		this.systemFilter = systemFilter;
	}

	/**
	 * @return the listSystemFilter
	 */
	public List<SystemSDTO> getListSystemFilter() {
		return listSystemFilter;
	}

	/**
	 * @param listSystemFilter the listSystemFilter to set
	 */
	public void setListSystemFilter(List<SystemSDTO> listSystemFilter) {
		this.listSystemFilter = listSystemFilter;
	}

	/**
	 * @return the listValidationResult
	 */
	public List<FileValidationResultDTO> getListValidationResult() {
		return listValidationResult;
	}

	/**
	 * @param listValidationResult the listValidationResult to set
	 */
	public void setListValidationResult(List<FileValidationResultDTO> listValidationResult) {
		this.listValidationResult = listValidationResult;
	}
}
