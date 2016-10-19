package com.nielsen.monitor.dto;

import java.sql.Timestamp;
import java.util.List;

import com.nielsen.monitor.entities.validation.FileValidationResult;


public class SystemFileDTO implements GenericDTO {

	/**
	 * 
	 */
	private static final long serialVersionUID = -722918926944745325L;
	private SystemFilePKDTO id;
	private Boolean active;
	private Boolean ctrlFileBol;
	private Integer ctrlFileId;
	private String delimiterChar;
	private String fileDesc;
	private String fileExt;
	private String fileName;
	private Boolean mayBeEmpty;
	private Timestamp regDte;
	private String schemaName;
	private String tableName;
	private String usrCode;
	private List<FileColumnDTO> fileColumns;
	private List<FileValidationResult> fileValidationResults;
	private SystemSDTO systemS;

	public SystemFileDTO() {
	}

	public SystemFilePKDTO getId() {
		return this.id;
	}

	public void setId(SystemFilePKDTO id) {
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

	public List<FileColumnDTO> getFileColumns() {
		return this.fileColumns;
	}

	public void setFileColumns(List<FileColumnDTO> fileColumns) {
		this.fileColumns = fileColumns;
	}

//	public FileColumn addFileColumn(FileColumn fileColumn) {
//		getFileColumns().add(fileColumn);
//		fileColumn.setSystemFile(this);
//
//		return fileColumn;
//	}
//
//	public FileColumn removeFileColumn(FileColumn fileColumn) {
//		getFileColumns().remove(fileColumn);
//		fileColumn.setSystemFile(null);
//
//		return fileColumn;
//	}

	public List<FileValidationResult> getFileValidationResults() {
		return this.fileValidationResults;
	}

	public void setFileValidationResults(List<FileValidationResult> fileValidationResults) {
		this.fileValidationResults = fileValidationResults;
	}

//	public FileValidationResult addFileValidationResult(FileValidationResult fileValidationResult) {
//		getFileValidationResults().add(fileValidationResult);
//		fileValidationResult.setSystemFile(this);
//
//		return fileValidationResult;
//	}
//
//	public FileValidationResult removeFileValidationResult(FileValidationResult fileValidationResult) {
//		getFileValidationResults().remove(fileValidationResult);
//		fileValidationResult.setSystemFile(null);
//
//		return fileValidationResult;
//	}

	public SystemSDTO getSystem() {
		return this.systemS;
	}

	public void setSystem(SystemSDTO systemS) {
		this.systemS = systemS;
	}

	@Override
	public GenericDTO newInstance(Object[] l) {
		// TODO Auto-generated method stub
		return null;
	}

}