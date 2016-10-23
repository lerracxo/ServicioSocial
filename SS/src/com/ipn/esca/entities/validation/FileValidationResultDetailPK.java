package com.nielsen.monitor.entities.validation;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the file_validation_result_detail database table.
 * 
 */
@Embeddable
public class FileValidationResultDetailPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="column_id", insertable=false, updatable=false)
	private Integer columnId;

	@Column(name="execution_id", insertable=false, updatable=false)
	private Integer executionId;

	@Column(name="validation_id", insertable=false, updatable=false)
	private Integer validationId;

	@Column(name="constraint_id")
	private Integer constraintId;

	public FileValidationResultDetailPK() {
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
		if (!(other instanceof FileValidationResultDetailPK)) {
			return false;
		}
		FileValidationResultDetailPK castOther = (FileValidationResultDetailPK)other;
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
}