package com.nielsen.monitor.entities.eventlog;

import java.io.Serializable;

import javax.persistence.Embeddable;
 
@Embeddable
public class ProcessStepsPK implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3787702752424190539L;
	private Integer process_id;
	private Integer step_order;
	
	
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
	 * @return 
	 * @return the step_type_id
	 */
	
	public final boolean equals(final Object obj){
	     return super.equals(obj);
	}
	
	public int hashcode(){
		return this.hashCode();
	}

	
}