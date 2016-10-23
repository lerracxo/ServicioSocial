package com.nielsen.monitor.dto;

import java.sql.Timestamp;
import java.util.List;


public class FileColumnDTO implements GenericDTO {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = -7003009640928624034L;
	private Integer columnId;
	private String columnName;
	private Integer columnOrder;
	private Boolean nullable;
	private Timestamp regDte;
	private String usrCode;
	private SystemFileDTO systemFile;
	private List<FileValidationResultDetailDTO> fileValidationResultDetails;

	public FileColumnDTO() {
	}

	public Integer getColumnId() {
		return this.columnId;
	}

	public void setColumnId(Integer columnId) {
		this.columnId = columnId;
	}

	public String getColumnName() {
		return this.columnName;
	}

	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}

	public Integer getColumnOrder() {
		return this.columnOrder;
	}

	public void setColumnOrder(Integer columnOrder) {
		this.columnOrder = columnOrder;
	}

	public Boolean getNullable() {
		return this.nullable;
	}

	public void setNullable(Boolean nullable) {
		this.nullable = nullable;
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

	public SystemFileDTO getSystemFile() {
		return this.systemFile;
	}

	public void setSystemFile(SystemFileDTO systemFile) {
		this.systemFile = systemFile;
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

//	public FileValidationResultDetail addFileValidationResultDetail(FileValidationResultDetail fileValidationResultDetail) {
//		getFileValidationResultDetails().add(fileValidationResultDetail);
//		fileValidationResultDetail.setFileColumn(this);
//
//		return fileValidationResultDetail;
//	}
//
//	public FileValidationResultDetail removeFileValidationResultDetail(FileValidationResultDetail fileValidationResultDetail) {
//		getFileValidationResultDetails().remove(fileValidationResultDetail);
//		fileValidationResultDetail.setFileColumn(null);
//
//		return fileValidationResultDetail;
//	}

}