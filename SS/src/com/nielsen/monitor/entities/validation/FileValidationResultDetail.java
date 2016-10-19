package com.nielsen.monitor.entities.validation;

import java.io.Serializable;
import javax.persistence.*;

import com.nielsen.monitor.entities.FileColumn;

import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the file_validation_result_detail database table.
 * 
 */
@Entity
@Table(name="file_validation_result_detail", schema="config")
@NamedQuery(name="FileValidationResultDetail.findAll", query="SELECT f FROM FileValidationResultDetail f")
public class FileValidationResultDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private FileValidationResultDetailPK id;

	@Column(name="invalid_records_num")
	private Integer invalidRecordsNum;

	@Column(name="reg_dte")
	private Timestamp regDte;

	@Column(name="status_bol")
	private Boolean statusBol;

	@Column(name="usr_code")
	private String usrCode;

	//bi-directional many-to-one association to FileColumn
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="column_id", insertable=false, updatable=false)
	private FileColumn fileColumn;

	//bi-directional many-to-one association to FileValidationResult
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="execution_id", insertable=false, updatable=false)
	private FileValidationResult fileValidationResult;

	//bi-directional many-to-one association to Validation
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="validation_id", insertable=false, updatable=false)
	private Validation validation;

	//bi-directional many-to-one association to FileValidationResultId
	@OneToMany(mappedBy="fileValidationResultDetail",fetch=FetchType.EAGER)
	private List<FileValidationResultId> fileValidationResultIds;

	public FileValidationResultDetail() {
	}

	public FileValidationResultDetailPK getId() {
		return this.id;
	}

	public void setId(FileValidationResultDetailPK id) {
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

	public FileColumn getFileColumn() {
		return this.fileColumn;
	}

	public void setFileColumn(FileColumn fileColumn) {
		this.fileColumn = fileColumn;
	}

	public FileValidationResult getFileValidationResult() {
		return this.fileValidationResult;
	}

	public void setFileValidationResult(FileValidationResult fileValidationResult) {
		this.fileValidationResult = fileValidationResult;
	}

	public Validation getValidation() {
		return this.validation;
	}

	public void setValidation(Validation validation) {
		this.validation = validation;
	}

	public List<FileValidationResultId> getFileValidationResultIds() {
		return this.fileValidationResultIds;
	}

	public void setFileValidationResultIds(List<FileValidationResultId> fileValidationResultIds) {
		this.fileValidationResultIds = fileValidationResultIds;
	}

	public FileValidationResultId addFileValidationResultId(FileValidationResultId fileValidationResultId) {
		getFileValidationResultIds().add(fileValidationResultId);
		fileValidationResultId.setFileValidationResultDetail(this);

		return fileValidationResultId;
	}

	public FileValidationResultId removeFileValidationResultId(FileValidationResultId fileValidationResultId) {
		getFileValidationResultIds().remove(fileValidationResultId);
		fileValidationResultId.setFileValidationResultDetail(null);

		return fileValidationResultId;
	}

}