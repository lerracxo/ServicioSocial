package com.nielsen.monitor.dto;

import java.sql.Date;
import java.sql.Timestamp;

import com.nielsen.monitor.entities.eventlog.Eventlog;

public class EventlogDTO implements GenericDTO {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1273346134054577273L;
	
	private Integer country_id;
	private String system_cod;
	private Integer process_id;
	private Integer step;
	private Integer periodid;
	private Integer eventtype;
	private String source;
	private String servername;
	private String database;
	private String message;
	private Date time;
	private Integer severity;
	
	public EventlogDTO(){}
	
	public EventlogDTO(Integer country_id, String system_cod, Integer process_id, Integer step, Integer periodid,
			Integer eventtype,String source, String servername, String database, String message,
			Date time, Integer severity){
		this.country_id =country_id ;
		this.system_cod = system_cod;
		this.process_id =process_id ;
		this.step =step ;
		this.periodid =periodid ;
		//this.eventtype = new EventtypeDTO(eventtype) ;
		this.eventtype = eventtype;
		this.source = source;
		this.servername = servername;
		this.database = database;
		this.message = message;
		this.time = time;
		this.severity = severity;
	}
	
	public EventlogDTO(Eventlog eventlog){
		this.country_id =eventlog.getCountry_id();
		this.system_cod = eventlog.getSystem_cod();
		this.process_id =eventlog.getProcess_id();
		this.step =eventlog.getStep() ;
		this.periodid =eventlog.getPeriodid();
		this.eventtype = eventlog.getEventtype();
		//this.eventtype = new EventtypeDTO(eventlog.getEventtype()) ;
		this.source = eventlog.getSource();
		this.servername = eventlog.getServername();
		this.database = eventlog.getDatabase();
		this.message = eventlog.getMessage();
		this.time = eventlog.getTime();
		this.severity = eventlog.getSeverity();
	}
	/**
	 * @return the country_id
	 */
	public Integer getCountry_id() {
		return country_id;
	}
	/**
	 * @param country_id the country_id to set
	 */
	public void setCountry_id(Integer country_id) {
		this.country_id = country_id;
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
	 * @return the step
	 */
	public Integer getStep() {
		return step;
	}
	/**
	 * @param step the step to set
	 */
	public void setStep(Integer step) {
		this.step = step;
	}
	/**
	 * @return the periodid
	 */
	public Integer getPeriodid() {
		return periodid;
	}
	/**
	 * @param periodid the periodid to set
	 */
	public void setPeriodid(Integer periodid) {
		this.periodid = periodid;
	}
	/**
	 * @return the eventtype
	 */
	public Integer getEventtype() {
		return eventtype;
	}
	/**
	 * @param eventtype the eventtype to set
	 */
	public void setEventtype(Integer eventtype) {
		this.eventtype = eventtype;
	}
	/**
	 * @return the source
	 */
	public String getSource() {
		return source;
	}
	/**
	 * @param source the source to set
	 */
	public void setSource(String source) {
		this.source = source;
	}
	/**
	 * @return the servername
	 */
	public String getServername() {
		return servername;
	}
	/**
	 * @param servername the servername to set
	 */
	public void setServername(String servername) {
		this.servername = servername;
	}
	/**
	 * @return the database
	 */
	public String getDatabase() {
		return database;
	}
	/**
	 * @param database the database to set
	 */
	public void setDatabase(String database) {
		this.database = database;
	}
	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}
	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	/**
	 * @return the time
	 */
	public Date getTime() {
		return time;
	}
	/**
	 * @param time the time to set
	 */
	public void setTime(Date time) {
		this.time = time;
	}
	/**
	 * @return the severity
	 */
	public Integer getSeverity() {
		return severity	;
	}
	/**
	 * @param severity the severity to set
	 */
	public void setSeverity(Integer severity) {
		this.severity = severity;
	}

	@Override
	public EventlogDTO newInstance(Object[] l) {
		EventlogDTO event = this;
		event.setCountry_id( l[0] != null ? new Integer(l[0].toString()) : null);
		event.setSystem_cod(l[1] != null ? l[1].toString(): null);
		event.setProcess_id(l[2] != null ? new Integer(l[2].toString()): null);
		event.setStep(l[3] != null ? new Integer(l[3].toString()): null);
		event.setPeriodid(l[4] != null ? new Integer(l[4].toString()): null);
		event.setEventtype(l[5] != null ? new Integer(l[5].toString()): null);
		event.setSource(l[6] != null ? l[6].toString(): null);
		event.setServername( l[7] != null ? l[7].toString(): null);
		event.setDatabase(l[8] != null ? l[8].toString(): null);
		event.setMessage(l[9] != null ? l[9].toString(): null);
		event.setTime(l[10] != null ? new Date(Timestamp.valueOf(l[10].toString()).getTime()) : null);
		event.setSeverity( l[11] != null ? new Integer(l[11].toString()): null );
		return event;
	}
}
