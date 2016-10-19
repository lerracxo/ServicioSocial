package com.nielsen.monitor.dto;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import com.nielsen.monitor.entities.eventlog.ProcessSteps;;

/**
 * @author saos6001
 *
 */
/**
 * @author saos6001
 *
 */
/**
 * @author saos6001
 *
 */
public class ProcessStepsDTO implements GenericDTO{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6686447258154453191L;
	private Integer process_id;
	private Integer step_order;
	private Integer step_type_id;
	private String step_name;
	private String step_command;
	private Boolean result_bol;
	private Boolean bactive;
	
	public ProcessStepsDTO(){}
	public ProcessStepsDTO(ProcessSteps p){
		this.process_id = p.getProcess_id();
		this.step_order = p.getStep_order();
		this.step_type_id = p.getStep_type_id();
		this.step_name = p.getStep_name();
		this.step_command = p.getStep_command();
		this.result_bol = p.getResult_bol();
		this.bactive = p.getBactive();
	}
	
	@Override
	public boolean equals(final Object obj){
		if (obj == null)
            return false;
        if (obj == this)
            return true;
        if (obj.getClass() != getClass())
            return false;
        
        ProcessStepsDTO pr = (ProcessStepsDTO) obj;
        
		return new EqualsBuilder()
				.append(process_id,pr.getProcess_id())
				.append(step_order, pr.getStep_order())
				.append(step_type_id,pr.getStep_type_id())
				.append(step_name, pr.getStep_name())
				.append(step_command,pr.getStep_command())
				.append(result_bol, pr.getResult_bol())
				.append(bactive,pr.getBactive())
				.isEquals();
	}
	
	@Override
	public int hashCode(){
		return new HashCodeBuilder()
		.append(process_id)
		.append(step_order)
		.append(step_type_id)
		.append(step_name)
		.append(step_command)
		.append(result_bol)
		.append(bactive).build();
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
	
	public void clean() {
		process_id = null;
		step_order = null;
		step_type_id = null;
		step_name = null;
		step_command = null;
		result_bol = null;
		bactive = null;
		
	}
	@Override
	public GenericDTO newInstance(Object[] l) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

	
}