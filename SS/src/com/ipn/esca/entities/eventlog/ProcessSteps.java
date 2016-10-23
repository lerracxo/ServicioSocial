package com.nielsen.monitor.entities.eventlog;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
 
@Entity
@Table(name = "process_steps", schema="config")
public class ProcessSteps {
	
	
	private Integer process_id;
	@Id
	private Integer step_order; 
	private Integer step_type_id;
	private String step_name;
	private String step_command;
	private Boolean result_bol;
	private Boolean bactive;
	
	
	/**
	 * @return the process_id
	 */
	public Integer getProcess_id() {
		return process_id;
	}
	/**
	 * @param process_id the process_id to set
	 */
	public void setProcess_id(Integer process_id) {
		this.process_id = process_id;
	}
	/**
	 * @return the step_order
	 */
	public Integer getStep_order() {
		return step_order;
	}
	/**
	 * @param step_order the step_order to set
	 */
	public void setStep_order(Integer step_order) {
		this.step_order = step_order;
	}
	/**
	 * @return the step_type_id
	 */
	public Integer getStep_type_id() {
		return step_type_id;
	}
	/**
	 * @param step_type_id the step_type_id to set
	 */
	public void setStep_type_id(Integer step_type_id) {
		this.step_type_id = step_type_id;
	}
	/**
	 * @return the step_name
	 */
	public String getStep_name() {
		return step_name;
	}
	/**
	 * @param step_name the step_name to set
	 */
	public void setStep_name(String step_name) {
		this.step_name = step_name;
	}
	/**
	 * @return the step_command
	 */
	public String getStep_command() {
		return step_command;
	}
	/**
	 * @param step_command the step_command to set
	 */
	public void setStep_command(String step_command) {
		this.step_command = step_command;
	}
	/**
	 * @return the result_bol
	 */
	public Boolean getResult_bol() {
		return result_bol;
	}
	/**
	 * @param result_bol the result_bol to set
	 */
	public void setResult_bol(Boolean result_bol) {
		this.result_bol = result_bol;
	}
	/**
	 * @return the bactive
	 */
	public Boolean getBactive() {
		return bactive;
	}
	/**
	 * @param bactive the bactive to set
	 */
	public void setBactive(Boolean bactive) {
		this.bactive = bactive;
	}
	
	

	
}