package com.nielsen.monitor.dto;

import java.sql.Timestamp;

import com.nielsen.monitor.common.Constant;
import java.text.SimpleDateFormat;


/**
 * The persistent class for the file_validation_result_ids database table.
 * 
 */
public class FileValidationResultIdDTO implements GenericDTO {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9140415850672713605L;
	private Long serialId;
	private String primaryContent;
	private Timestamp regDte;
	private String usrCode;
	private FileValidationResultDetailDTO fileValidationResultDetail;
	
	

	public FileValidationResultIdDTO() {
	}

	public Long getSerialId() {
		return this.serialId;
	}

	public void setSerialId(Long serialId) {
		this.serialId = serialId;
	}

	public String getPrimaryContent() {
		return this.primaryContent;
	}

	public void setPrimaryContent(String primaryContent) {
		this.primaryContent = primaryContent;
	}

	public String getFormatedDate(){
		return new SimpleDateFormat(Constant.TIME_MASK).format(getRegDte());
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

	public FileValidationResultDetailDTO getFileValidationResultDetail() {
		return this.fileValidationResultDetail;
	}

	public void setFileValidationResultDetail(FileValidationResultDetailDTO fileValidationResultDetail) {
		this.fileValidationResultDetail = fileValidationResultDetail;
	}

	@Override
	public GenericDTO newInstance(Object[] l) {
		// TODO Auto-generated method stub
		return null;
	}

}