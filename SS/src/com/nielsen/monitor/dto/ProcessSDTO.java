package com.nielsen.monitor.dto;

import com.nielsen.monitor.entities.eventlog.ProcessS;

public class ProcessSDTO implements GenericDTO {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -980384926604363156L;
	private Integer process_id;
	private String system_cod;
	private String process_name;
	private String process_dsc;

	public ProcessSDTO(){}
	
	public ProcessSDTO(ProcessS p){
		this.process_id = p.getProcess_id();
		this.system_cod = p.getSystem_cod();
		this.process_name = p.getProcess_name();
		this.process_dsc = p.getProcess_dsc();
	}
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

	public void clean() {
		process_id = null;
		system_cod = null;
		process_name = null;
		process_dsc = null;
		
	}

	@Override
	public GenericDTO newInstance(Object[] l) {
		// TODO Auto-generated method stub
		return null;
	}

}
