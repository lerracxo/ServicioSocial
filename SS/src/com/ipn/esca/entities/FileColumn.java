package com.nielsen.monitor.entities;

import java.io.Serializable;
import javax.persistence.*;

import com.nielsen.monitor.entities.validation.FileValidationResultDetail;

import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the file_columns database table.
 * 
 */
@Entity
@Table(name="file_columns", schema="config")
@NamedQuery(name="FileColumn.findAll", query="SELECT f FROM FileColumn f")
public class FileColumn implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="column_id")
	private Integer columnId;

	@Column(name="column_name")
	private String columnName;

	@Column(name="column_order")
	private Integer columnOrder;

	private Boolean nullable;

	@Column(name="reg_dte")
	private Timestamp regDte;

	@Column(name="usr_code")
	private String usrCode;

	//bi-directional many-to-one association to SystemFile
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name="file_id", referencedColumnName="file_id"),
		@JoinColumn(name="system_cod", referencedColumnName="system_cod")
		})
	private SystemFile systemFile;

	//bi-directional many-to-one association to FileValidationResultDetail
	@OneToMany(mappedBy="fileColumn")
	private List<FileValidationResultDetail> fileValidationResultDetails;

	public FileColumn() {
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

	public SystemFile getSystemFile() {
		return this.systemFile;
	}

	public void setSystemFile(SystemFile systemFile) {
		this.systemFile = systemFile;
	}

	public List<FileValidationResultDetail> getFileValidationResultDetails() {
		return this.fileValidationResultDetails;
	}

	public void setFileValidationResultDetails(List<FileValidationResultDetail> fileValidationResultDetails) {
		this.fileValidationResultDetails = fileValidationResultDetails;
	}

	public FileValidationResultDetail addFileValidationResultDetail(FileValidationResultDetail fileValidationResultDetail) {
		getFileValidationResultDetails().add(fileValidationResultDetail);
		fileValidationResultDetail.setFileColumn(this);

		return fileValidationResultDetail;
	}

	public FileValidationResultDetail removeFileValidationResultDetail(FileValidationResultDetail fileValidationResultDetail) {
		getFileValidationResultDetails().remove(fileValidationResultDetail);
		fileValidationResultDetail.setFileColumn(null);

		return fileValidationResultDetail;
	}

}