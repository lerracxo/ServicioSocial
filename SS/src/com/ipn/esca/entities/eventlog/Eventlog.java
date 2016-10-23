package com.nielsen.monitor.entities.eventlog;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
 
@Entity
@Table(name = "eventlog", schema="config")
public class Eventlog {
 
	private Integer country_id;
	private String system_cod;
	@Id
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
		return severity;
	}
	/**
	 * @param severity the severity to set
	 */
	public void setSeverity(Integer severity) {
		this.severity = severity;
	}

	
}