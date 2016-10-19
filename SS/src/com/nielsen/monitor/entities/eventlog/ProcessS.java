package com.nielsen.monitor.entities.eventlog;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
 
@Entity
@Table(name = "process", schema="config")
public class ProcessS {
	
	@Id
	private int process_id;
	private String system_cod;
	private String process_name;
	private String process_dsc;

	
	
	/**
	 * @return the process_id
	 */
	public int getProcess_id() {
		return process_id;
	}
	/**
	 * @param process_id the process_id to set
	 */
	public void setProcess_id(int process_id) {
		this.process_id = process_id;
	}
	/**
	 * @return the system_cod
	 */
	public String getSystem_cod() {
		return system_cod;
	}
	/**
	 * @param system_cod the system_cod to set
	 */
	public void setSystem_cod(String system_cod) {
		this.system_cod = system_cod;
	}
	/**
	 * @return the process_name
	 */
	public String getProcess_name() {
		return process_name;
	}
	/**
	 * @param process_name the process_name to set
	 */
	public void setProcess_name(String process_name) {
		this.process_name = process_name;
	}
	/**
	 * @return the process_dsc
	 */
	public String getProcess_dsc() {
		return process_dsc;
	}
	/**
	 * @param process_dsc the process_dsc to set
	 */
	public void setProcess_dsc(String process_dsc) {
		this.process_dsc = process_dsc;
	}

	
}