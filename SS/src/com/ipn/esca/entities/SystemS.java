package com.nielsen.monitor.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the system database table.
 * 
 */
@Entity
@Table (name="System",schema="config")
@NamedQuery(name="System.findAll", query="SELECT s FROM SystemS s")
public class SystemS implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="system_cod" , insertable=false, updatable=false )
	private String systemCod;

	@Column(name="reg_dte")
	private Timestamp regDte;

	@Column(name="system_dsc")
	private String systemDsc;

	@Column(name="usr_cod")
	private String usrCod;

	//bi-directional many-to-one association to SystemFile
	@OneToMany(mappedBy="systemS")
	private List<SystemFile> systemFiles;

	public SystemS() {
	}

	public String getSystemCod() {
		return this.systemCod;
	}

	public void setSystemCod(String systemCod) {
		this.systemCod = systemCod;
	}

	public Timestamp getRegDte() {
		return this.regDte;
	}

	public void setRegDte(Timestamp regDte) {
		this.regDte = regDte;
	}

	public String getSystemDsc() {
		return this.systemDsc;
	}

	public void setSystemDsc(String systemDsc) {
		this.systemDsc = systemDsc;
	}

	public String getUsrCod() {
		return this.usrCod;
	}

	public void setUsrCod(String usrCod) {
		this.usrCod = usrCod;
	}

	public List<SystemFile> getSystemFiles() {
		return this.systemFiles;
	}

	public void setSystemFiles(List<SystemFile> systemFiles) {
		this.systemFiles = systemFiles;
	}

	public SystemFile addSystemFile(SystemFile systemFile) {
		getSystemFiles().add(systemFile);
		systemFile.setSystem(this);

		return systemFile;
	}

	public SystemFile removeSystemFile(SystemFile systemFile) {
		getSystemFiles().remove(systemFile);
		systemFile.setSystem(null);

		return systemFile;
	}

}