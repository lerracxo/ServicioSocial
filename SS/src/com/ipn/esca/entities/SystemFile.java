package com.nielsen.monitor.entities;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.nielsen.monitor.entities.validation.FileValidationResult;


/**
 * The persistent class for the system_files database table.
 * 
 */
@Entity
@Table(name="system_files", schema="config")
@NamedQuery(name="SystemFile.findAll", query="SELECT s FROM SystemFile s")
public class SystemFile implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private SystemFilePK id;

	private Boolean active;

	@Column(name="ctrl_file_bol")
	private Boolean ctrlFileBol;

	@Column(name="ctrl_file_id")
	private Integer ctrlFileId;

	@Column(name="delimiter_char")
	private String delimiterChar;

	@Column(name="file_desc")
	private String fileDesc;

	@Column(name="file_ext")
	private String fileExt;

	@Column(name="file_name")
	private String fileName;

	@Column(name="may_be_empty")
	private Boolean mayBeEmpty;

	@Column(name="reg_dte")
	private Timestamp regDte;

	@Column(name="schema_name")
	private String schemaName;

	@Column(name="table_name")
	private String tableName;

	@Column(name="usr_code")
	private String usrCode;

	//bi-directional many-to-one association to FileColumn
	@OneToMany(mappedBy="systemFile",fetch=FetchType.LAZY)
	private List<FileColumn> fileColumns;

	//bi-directional many-to-one association to FileValidationResult
	@OneToMany(mappedBy="systemFile")
	private List<FileValidationResult> fileValidationResults;

	//bi-directional many-to-one association to System
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="system_cod",insertable=false,updatable=false)
	private SystemS systemS;

	public SystemFile() {
	}

	public SystemFilePK getId() {
		return this.id;
	}

	public void setId(SystemFilePK id) {
		this.id = id;
	}

	public Boolean getActive() {
		return this.active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public Boolean getCtrlFileBol() {
		return this.ctrlFileBol;
	}

	public void setCtrlFileBol(Boolean ctrlFileBol) {
		this.ctrlFileBol = ctrlFileBol;
	}

	public Integer getCtrlFileId() {
		return this.ctrlFileId;
	}

	public void setCtrlFileId(Integer ctrlFileId) {
		this.ctrlFileId = ctrlFileId;
	}

	public String getDelimiterChar() {
		return this.delimiterChar;
	}

	public void setDelimiterChar(String delimiterChar) {
		this.delimiterChar = delimiterChar;
	}

	public String getFileDesc() {
		return this.fileDesc;
	}

	public void setFileDesc(String fileDesc) {
		this.fileDesc = fileDesc;
	}

	public String getFileExt() {
		return this.fileExt;
	}

	public void setFileExt(String fileExt) {
		this.fileExt = fileExt;
	}

	public String getFileName() {
		return this.fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public Boolean getMayBeEmpty() {
		return this.mayBeEmpty;
	}

	public void setMayBeEmpty(Boolean mayBeEmpty) {
		this.mayBeEmpty = mayBeEmpty;
	}

	public Timestamp getRegDte() {
		return this.regDte;
	}

	public void setRegDte(Timestamp regDte) {
		this.regDte = regDte;
	}

	public String getSchemaName() {
		return this.schemaName;
	}

	public void setSchemaName(String schemaName) {
		this.schemaName = schemaName;
	}

	public String getTableName() {
		return this.tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String getUsrCode() {
		return this.usrCode;
	}

	public void setUsrCode(String usrCode) {
		this.usrCode = usrCode;
	}

	public List<FileColumn> getFileColumns() {
		return this.fileColumns;
	}

	public void setFileColumns(List<FileColumn> fileColumns) {
		this.fileColumns = fileColumns;
	}

	public FileColumn addFileColumn(FileColumn fileColumn) {
		getFileColumns().add(fileColumn);
		fileColumn.setSystemFile(this);

		return fileColumn;
	}

	public FileColumn removeFileColumn(FileColumn fileColumn) {
		getFileColumns().remove(fileColumn);
		fileColumn.setSystemFile(null);

		return fileColumn;
	}

	public List<FileValidationResult> getFileValidationResults() {
		return this.fileValidationResults;
	}

	public void setFileValidationResults(List<FileValidationResult> fileValidationResults) {
		this.fileValidationResults = fileValidationResults;
	}

	public FileValidationResult addFileValidationResult(FileValidationResult fileValidationResult) {
		getFileValidationResults().add(fileValidationResult);
		fileValidationResult.setSystemFile(this);

		return fileValidationResult;
	}

	public FileValidationResult removeFileValidationResult(FileValidationResult fileValidationResult) {
		getFileValidationResults().remove(fileValidationResult);
		fileValidationResult.setSystemFile(null);

		return fileValidationResult;
	}

	public SystemS getSystem() {
		return this.systemS;
	}

	public void setSystem(SystemS systemS) {
		this.systemS = systemS;
	}

}