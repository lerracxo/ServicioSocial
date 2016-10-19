package com.nielsen.monitor.dto;

import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the validation database table.
 * 
 */
public class ValidationDTO implements GenericDTO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5388112271074546834L;
	private Integer validationId;
	private Timestamp regDte;
	private String usrCode;
	private String validationDsc;
	private String validationName;

	private List<FileValidationResultDTO> fileValidationResults;

	private List<FileValidationResultDetailDTO> fileValidationResultDetails;

	public ValidationDTO() {
	}

	public Integer getValidationId() {
		return this.validationId;
	}

	public void setValidationId(Integer validationId) {
		this.validationId = validationId;
	}

	public Timestamp getRegDte() {
		return this.regDte;
	}

	public void setRegDte(Timestamp regDte) {
		this.regDte = regDte;
	}

	public String getUsrCode() {
		return this.usrCode;
	}

	public void setUsrCode(String usrCode) {
		this.usrCode = usrCode;
	}

	public String getValidationDsc() {
		return this.validationDsc;
	}

	public void setValidationDsc(String validationDsc) {
		this.validationDsc = validationDsc;
	}

	public String getValidationName() {
		return this.validationName;
	}

	public void setValidationName(String validationName) {
		this.validationName = validationName;
	}

	public List<FileValidationResultDTO> getFileValidationResults() {
		return this.fileValidationResults;
	}

	public void setFileValidationResults(List<FileValidationResultDTO> fileValidationResults) {
		this.fileValidationResults = fileValidationResults;
	}

//	public FileValidationResultDTO addFileValidationResult(FileValidationResultDTO fileValidationResult) {
//		getFileValidationResults().add(fileValidationResult);
//		fileValidationResult.setValidation(this);
//
//		return fileValidationResult;
//	}
//
//	public FileValidationResultDTO removeFileValidationResult(FileValidationResultDTO fileValidationResult) {
//		getFileValidationResults().remove(fileValidationResult);
//		fileValidationResult.setValidation(null);
//
//		return fileValidationResult;
//	}

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

//	public FileValidationResultDetail addFileValidationResultDetail(FileValidationResultDetail fileValidationResultDetail) {
//		getFileValidationResultDetails().add(fileValidationResultDetail);
//		fileValidationResultDetail.setValidation(this);
//
//		return fileValidationResultDetail;
//	}
//
//	public FileValidationResultDetail removeFileValidationResultDetail(FileValidationResultDetail fileValidationResultDetail) {
//		getFileValidationResultDetails().remove(fileValidationResultDetail);
//		fileValidationResultDetail.setValidation(null);
//
//		return fileValidationResultDetail;
//	}

}