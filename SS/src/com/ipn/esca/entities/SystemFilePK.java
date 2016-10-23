package com.nielsen.monitor.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the system_files database table.
 * 
 */
@Embeddable
public class SystemFilePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 121817856494741309L;

	@Column(name="system_cod", insertable=false, updatable=false )
	private String systemCod;

	@Column(name="file_id")
	private Integer fileId;

	public SystemFilePK() {
	}
	public String getSystemCod() {
		return this.systemCod;
	}
	public void setSystemCod(String systemCod) {
		this.systemCod = systemCod;
	}
	public Integer getFileId() {
		return this.fileId;
	}
	public void setFileId(Integer fileId) {
		this.fileId = fileId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof SystemFilePK)) {
			return false;
		}
		SystemFilePK castOther = (SystemFilePK)other;
		return 
			this.systemCod.equals(castOther.systemCod)
			&& this.fileId.equals(castOther.fileId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.systemCod.hashCode();
		hash = hash * prime + this.fileId.hashCode();
		
		return hash;
	}
}