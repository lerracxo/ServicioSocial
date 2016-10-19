package com.nielsen.monitor.dto;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;

import com.nielsen.monitor.common.Constant;


/**
 * The persistent class for the file_validation_result database table.
 * 
 */

public class FileValidationResultDTO implements GenericDTO {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4300672721752368440L;
	private Integer executionId;
	private String systemCod;
	private String fileName;
	private Timestamp regDte;
	private Boolean statusBol;
	private String usrCode;
	private SystemFileDTO systemFile;

	private ValidationDTO validation;

	private List<FileValidationResultDetailDTO> fileValidationResultDetails;

	public FileValidationResultDTO() {
	}

	public String getFormatedDate(){
		return new SimpleDateFormat(Constant.TIME_MASK).format(getRegDte());
	}
	
	public Integer getExecutionId() {
		return this.executionId;
	}

	public void setExecutionId(Integer executionId) {
		this.executionId = executionId;
	}

	public String getFileName() {
		return this.fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public Timestamp getRegDte() {
		return this.regDte;
	}

	public void setRegDte(Timestamp regDte) {
		this.regDte = regDte;
	}

	public Boolean getStatusBol() {
		return this.statusBol;
	}

	public void setStatusBol(Boolean statusBol) {
		this.statusBol = statusBol;
	}

	public String getUsrCode() {
		return this.usrCode;
	}

	public void setUsrCode(String usrCode) {
		this.usrCode = usrCode;
	}

	public SystemFileDTO getSystemFile() {
		return this.systemFile;
	}

	public void setSystemFile(SystemFileDTO systemFile) {
		this.systemFile = systemFile;
	}

	public ValidationDTO getValidation() {
		return this.validation;
	}

	public void setValidation(ValidationDTO validation) {
		this.validation = validation;
	}

	public List<FileValidationResultDetailDTO> getFileValidationResultDetails() {
		return this.fileValidationResultDetails;
	}

	public void setFileValidationResultDetails(List<FileValidationResultDetailDTO> fileValidationResultDetails) {
		this.fileValidationResultDetails = fileValidationResultDetails;
	}

	@Override
	public GenericDTO newInstance(Object[] l) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @return the systemCod
	 */
	public String getSystemCod() {
		return systemCod;
	}

	/**
	 * @param systemCod the systemCod to set
	 */
	public void setSystemCod(String systemCod) {
		this.systemCod = systemCod;
	}

}