package com.nielsen.monitor.dto;

import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the file_validation_result_detail database table.
 * 
 */
public class FileValidationResultDetailDTO implements GenericDTO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3460752735134602085L;
	private FileValidationResultDetailPKDTO id;
	private Integer invalidRecordsNum;
	private Timestamp regDte;
	private Boolean statusBol;
	private String usrCode;
	private FileColumnDTO fileColumn;

	private FileValidationResultDTO fileValidationResult;

	private ValidationDTO validation;

	private List<FileValidationResultIdDTO> fileValidationResultIds;

	public FileValidationResultDetailDTO() {
	}

	public FileValidationResultDetailPKDTO getId() {
		return this.id;
	}

	public void setId(FileValidationResultDetailPKDTO id) {
		this.id = id;
	}

	public Integer getInvalidRecordsNum() {
		return this.invalidRecordsNum;
	}

	public void setInvalidRecordsNum(Integer invalidRecordsNum) {
		this.invalidRecordsNum = invalidRecordsNum;
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

	public FileColumnDTO getFileColumn() {
		return this.fileColumn;
	}

	public void setFileColumn(FileColumnDTO fileColumn) {
		this.fileColumn = fileColumn;
	}

	public FileValidationResultDTO getFileValidationResult() {
		return this.fileValidationResult;
	}

	public void setFileValidationResult(FileValidationResultDTO fileValidationResult) {
		this.fileValidationResult = fileValidationResult;
	}

	public ValidationDTO getValidation() {
		return this.validation;
	}

	public void setValidation(ValidationDTO validation) {
		this.validation = validation;
	}

	public List<FileValidationResultIdDTO> getFileValidationResultIds() {
		return this.fileValidationResultIds;
	}

	public void setFileValidationResultIds(List<FileValidationResultIdDTO> fileValidationResultIds) {
		this.fileValidationResultIds = fileValidationResultIds;
	}

	@Override
	public GenericDTO newInstance(Object[] l) {
		// TODO Auto-generated method stub
		return null;
	}

//	public FileValidationResultId addFileValidationResultId(FileValidationResultId fileValidationResultId) {
//		getFileValidationResultIds().add(fileValidationResultId);
//		fileValidationResultId.setFileValidationResultDetail(this);
//
//		return fileValidationResultId;
//	}
//
//	public FileValidationResultId removeFileValidationResultId(FileValidationResultId fileValidationResultId) {
//		getFileValidationResultIds().remove(fileValidationResultId);
//		fileValidationResultId.setFileValidationResultDetail(null);
//
//		return fileValidationResultId;
//	}

}