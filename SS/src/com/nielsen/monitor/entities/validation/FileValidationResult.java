package com.nielsen.monitor.entities.validation;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.nielsen.monitor.entities.SystemFile;
import com.nielsen.monitor.entities.SystemS;


/**
 * The persistent class for the file_validation_result database table.
 * 
 */
@Entity
@Table(name="file_validation_result", schema="config")
@NamedQuery(name="FileValidationResult.findAll", query="SELECT f FROM FileValidationResult f")
public class FileValidationResult implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="execution_id")
	private Integer executionId;
	
	@Column(name="system_cod",insertable=false,updatable=false)
	private String systemCod;

	@Column(name="file_name")
	private String fileName;

	@Column(name="reg_dte")
	private Timestamp regDte;

	@Column(name="status_bol")
	private Boolean statusBol;

	@Column(name="usr_code")
	private String usrCode;

	//bi-directional many-to-one association to SystemFile
	@ManyToOne(fetch=FetchType.LAZY,optional=true)
	@JoinColumns({
		@JoinColumn(name="file_id", referencedColumnName="file_id"),
		@JoinColumn(name="system_cod", referencedColumnName="system_cod")
		})
	private SystemFile systemFile;
	
	//bi-directional many-to-one association to System
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="system_cod",insertable=false,updatable=false) //,referencedColumnName="system_cod"
	private SystemS systemS;

	//bi-directional many-to-one association to Validation
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="validation_id")
	private Validation validation;

	//bi-directional many-to-one association to FileValidationResultDetail
	@OneToMany(fetch=FetchType.EAGER,mappedBy="fileValidationResult")
	private List<FileValidationResultDetail> fileValidationResultDetails;

	public FileValidationResult() {
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

	public SystemFile getSystemFile() {
		return this.systemFile;
	}

	public void setSystemFile(SystemFile systemFile) {
		this.systemFile = systemFile;
	}

	public Validation getValidation() {
		return this.validation;
	}

	public void setValidation(Validation validation) {
		this.validation = validation;
	}

	public List<FileValidationResultDetail> getFileValidationResultDetails() {
		return this.fileValidationResultDetails;
	}

	public void setFileValidationResultDetails(List<FileValidationResultDetail> fileValidationResultDetails) {
		this.fileValidationResultDetails = fileValidationResultDetails;
	}

	public FileValidationResultDetail addFileValidationResultDetail(FileValidationResultDetail fileValidationResultDetail) {
		getFileValidationResultDetails().add(fileValidationResultDetail);
		fileValidationResultDetail.setFileValidationResult(this);

		return fileValidationResultDetail;
	}

	public FileValidationResultDetail removeFileValidationResultDetail(FileValidationResultDetail fileValidationResultDetail) {
		getFileValidationResultDetails().remove(fileValidationResultDetail);
		fileValidationResultDetail.setFileValidationResult(null);

		return fileValidationResultDetail;
	}

	/**
	 * @return the systemS
	 */
	public SystemS getSystemS() {
		return systemS;
	}

	/**
	 * @param systemS the systemS to set
	 */
	public void setSystemS(SystemS systemS) {
		this.systemS = systemS;
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