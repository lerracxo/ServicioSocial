package com.nielsen.monitor.dto;

public class FileValidationResultDetailPKDTO implements GenericDTO {
	
	private static final long serialVersionUID = -2443109862599688390L;
	
	private Integer columnId;
	private Integer executionId;
	private Integer validationId;
	private Integer constraintId;

	public FileValidationResultDetailPKDTO() {
	}
	public Integer getColumnId() {
		return this.columnId;
	}
	public void setColumnId(Integer columnId) {
		this.columnId = columnId;
	}
	public Integer getExecutionId() {
		return this.executionId;
	}
	public void setExecutionId(Integer executionId) {
		this.executionId = executionId;
	}
	public Integer getValidationId() {
		return this.validationId;
	}
	public void setValidationId(Integer validationId) {
		this.validationId = validationId;
	}
	public Integer getConstraintId() {
		return this.constraintId;
	}
	public void setConstraintId(Integer constraintId) {
		this.constraintId = constraintId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof FileValidationResultDetailPKDTO)) {
			return false;
		}
		FileValidationResultDetailPKDTO castOther = (FileValidationResultDetailPKDTO)other;
		return 
			this.columnId.equals(castOther.columnId)
			&& this.executionId.equals(castOther.executionId)
			&& this.validationId.equals(castOther.validationId)
			&& this.constraintId.equals(castOther.constraintId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.columnId.hashCode();
		hash = hash * prime + this.executionId.hashCode();
		hash = hash * prime + this.validationId.hashCode();
		hash = hash * prime + this.constraintId.hashCode();
		
		return hash;
	}
	@Override
	public GenericDTO newInstance(Object[] l) {
		// TODO Auto-generated method stub
		return null;
	}
}