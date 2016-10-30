package com.ipn.esca.serviciosocial.mb.impl;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.ipn.esca.serviciosocial.bs.ProfesorIService;
import com.ipn.esca.serviciosocial.common.Constant;

@ManagedBean(name = "profesorMB")
@ViewScoped
public class ProfesorMB extends GenericMB implements Serializable {
	private static final long serialVersionUID = 7930745241666648980L;
	
	@EJB(lookup="java:module/ProfesorServiceBean!com.ipn.esca.serviciosocial.bs.ProfesorServiceLocal")
	private ProfesorIService service;
	
	@PostConstruct
	private void init(){
	
	}
	
	public void reset(){
		init();
	}
	
	public String navToFilter(){
		return Constant.FilterScreen;
	}
	
	public void populateSystem(){
		
	} 
	
	public void populateProcess(){
		
	}
	
	public void populateProcessSteps(){
		
	}
	public String getProjectVersion(){
		return Constant.PROJECT_VERSION;
	}
	private void populatelEventlog(){
		
	}

	
	
	public void findEvents(){
		populatelEventlog();
	}
	
	public String function(){
		System.out.println("Prueba");
		return "prueba";
	}
	

	

}
