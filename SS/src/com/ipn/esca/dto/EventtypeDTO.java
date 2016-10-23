package com.nielsen.monitor.dto;

import java.sql.Date;

import com.nielsen.monitor.entities.eventlog.Eventtype;

public class EventtypeDTO implements GenericDTO{
 

	/**
	 * 
	 */
	private static final long serialVersionUID = -9079458260368976342L;
	private int eventtype_id;
	private String description;
	private String usr_code;
	private Date reg_dte;
	
	public EventtypeDTO(){}
	
	public EventtypeDTO(int eventtype_id,String description,String usr_code,Date reg_dte){
		this.eventtype_id = eventtype_id;
		this.description = description;
		this.usr_code = usr_code;
		this.reg_dte = reg_dte;
	}
	
	public EventtypeDTO(Eventtype eventtype){
		this.eventtype_id = eventtype.getEventtype_id();
		this.description = eventtype.getDescription();
		this.usr_code = eventtype.getUsr_code();
		this.reg_dte = eventtype.getReg_dte();
	} 
	/**
	 * @return the eventtype_id
	 */
	public int getEventtype_id() {
		return eventtype_id;
	}
	/**
	 * @param eventtype_id the eventtype_id to set
	 */
	public void setEventtype_id(int eventtype_id) {
		this.eventtype_id = eventtype_id;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * @return the usr_code
	 */
	public String getUsr_code() {
		return usr_code;
	}
	/**
	 * @param usr_code the usr_code to set
	 */
	public void setUsr_code(String usr_code) {
		this.usr_code = usr_code;
	}
	/**
	 * @return the reg_dte
	 */
	public Date getReg_dte() {
		return reg_dte;
	}
	/**
	 * @param reg_dte the reg_dte to set
	 */
	public void setReg_dte(Date reg_dte) {
		this.reg_dte = reg_dte;
	}

	@Override
	public GenericDTO newInstance(Object[] l) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
 
}