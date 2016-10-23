package com.nielsen.monitor.entities.validation;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the file_validation_result_ids database table.
 * 
 */
@Entity
@Table(name="file_validation_result_ids", schema="config")
@NamedQuery(name="FileValidationResultId.findAll", query="SELECT f FROM FileValidationResultId f")
public class FileValidationResultId implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="serial_id")
	private Long serialId;

	@Column(name="primary_content")
	private String primaryContent;

	@Column(name="reg_dte")
	private Timestamp regDte;

	@Column(name="usr_code")
	private String usrCode;

	//bi-directional many-to-one association to FileValidationResultDetail
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumns({
		@JoinColumn(name="execution_id", referencedColumnName="execution_id"),
		@JoinColumn(name="constraint_id", referencedColumnName="constraint_id"),
		@JoinColumn(name="column_id", referencedColumnName="column_id"),
		@JoinColumn(name="validation_id", referencedColumnName="validation_id")
		})
	private FileValidationResultDetail fileValidationResultDetail;

	public FileValidationResultId() {
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

	public FileValidationResultDetail getFileValidationResultDetail() {
		return this.fileValidationResultDetail;
	}

	public void setFileValidationResultDetail(FileValidationResultDetail fileValidationResultDetail) {
		this.fileValidationResultDetail = fileValidationResultDetail;
	}

}