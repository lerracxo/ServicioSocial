package com.nielsen.monitor.dto;

import java.sql.Timestamp;

import com.nielsen.monitor.entities.SystemS;

public class SystemSDTO implements GenericDTO {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2014181598246404618L;
	private String system_cod;
	private String system_dsc;
	private String usr_cod;
	private Timestamp reg_dte;
	
	public SystemSDTO(){}

	
	public SystemSDTO(SystemS s){
		this.system_cod = s.getSystemCod();
		this.system_dsc = s.getSystemDsc();
		this.usr_cod = s.getUsrCod();
		this.reg_dte = s.getRegDte();
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
	 * @return the system_dsc
	 */
	public String getSystem_dsc() {
		return system_dsc;
	}

	/**
	 * @param system_dsc the system_dsc to set
	 */
	public void setSystem_dsc(String system_dsc) {
		this.system_dsc = system_dsc;
	}

	/**
	 * @return the usr_cod
	 */
	public String getUsr_cod() {
		return usr_cod;
	}

	/**
	 * @param usr_cod the usr_cod to set
	 */
	public void setUsr_cod(String usr_cod) {
		this.usr_cod = usr_cod;
	}

	/**
	 * @return the reg_dte
	 */
	public Timestamp getReg_dte() {
		return reg_dte;
	}

	/**
	 * @param reg_dte the reg_dte to set
	 */
	public void setReg_dte(Timestamp reg_dte) {
		this.reg_dte = reg_dte;
	}


	@Override
	public GenericDTO newInstance(Object[] l) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
