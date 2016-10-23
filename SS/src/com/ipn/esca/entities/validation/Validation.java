package com.nielsen.monitor.entities.validation;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the validation database table.
 * 
 */
@Entity
@Table(name="validation",schema="config")
@NamedQuery(name="Validation.findAll", query="SELECT v FROM Validation v")
public class Validation implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="validation_id")
	private Integer validationId;

	@Column(name="reg_dte")
	private Timestamp regDte;

	@Column(name="usr_code")
	private String usrCode;

	@Column(name="validation_dsc")
	private String validationDsc;

	@Column(name="validation_name")
	private String validationName;

	//bi-directional many-to-one association to FileValidationResult
	@OneToMany(mappedBy="validation")
	private List<FileValidationResult> fileValidationResults;

	//bi-directional many-to-one association to FileValidationResultDetail
	@OneToMany(mappedBy="validation")
	private List<FileValidationResultDetail> fileValidationResultDetails;

	public Validation() {
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

	public List<FileValidationResult> getFileValidationResults() {
		return this.fileValidationResults;
	}

	public void setFileValidationResults(List<FileValidationResult> fileValidationResults) {
		this.fileValidationResults = fileValidationResults;
	}

	public FileValidationResult addFileValidationResult(FileValidationResult fileValidationResult) {
		getFileValidationResults().add(fileValidationResult);
		fileValidationResult.setValidation(this);

		return fileValidationResult;
	}

	public FileValidationResult removeFileValidationResult(FileValidationResult fileValidationResult) {
		getFileValidationResults().remove(fileValidationResult);
		fileValidationResult.setValidation(null);

		return fileValidationResult;
	}

	public List<FileValidationResultDetail> getFileValidationResultDetails() {
		return this.fileValidationResultDetails;
	}

	public void setFileValidationResultDetails(List<FileValidationResultDetail> fileValidationResultDetails) {
		this.fileValidationResultDetails = fileValidationResultDetails;
	}

	public FileValidationResultDetail addFileValidationResultDetail(FileValidationResultDetail fileValidationResultDetail) {
		getFileValidationResultDetails().add(fileValidationResultDetail);
		fileValidationResultDetail.setValidation(this);

		return fileValidationResultDetail;
	}

	public FileValidationResultDetail removeFileValidationResultDetail(FileValidationResultDetail fileValidationResultDetail) {
		getFileValidationResultDetails().remove(fileValidationResultDetail);
		fileValidationResultDetail.setValidation(null);

		return fileValidationResultDetail;
	}

}