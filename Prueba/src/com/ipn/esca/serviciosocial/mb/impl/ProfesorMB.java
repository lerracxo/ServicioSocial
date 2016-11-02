package com.ipn.esca.serviciosocial.mb.impl;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.ipn.esca.serviciosocial.bs.ProfesorIService;
import com.ipn.esca.serviciosocial.common.Constant;
import com.ipn.esca.serviciosocial.entities.Profesor;

@ManagedBean(name = "profesorMB")
@ViewScoped
public class ProfesorMB extends GenericMB implements Serializable {
	private static final long serialVersionUID = 7930745241666648980L;
	
	@EJB(lookup="java:module/ProfesorServiceBean!com.ipn.esca.serviciosocial.bs.ProfesorServiceLocal")
	private ProfesorIService service;
	
	private String filterProfessor;
	private List<Profesor> listProfesores;
	
	@PostConstruct
	private void init(){
		
	}
	
	public void reset(){
		init();
	}
	
	public void searchProfessorByFilter(){
		this.setListProfesores(service.getProfesoresByFilter(filterProfessor));
		
	}
	
	public String navToFilter(){
		return Constant.FilterScreen;
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

	/**
	 * @return the filterProfessor
	 */
	public String getFilterProfessor() {
		return filterProfessor;
	}

	/**
	 * @param filterProfessor the filterProfessor to set
	 */
	public void setFilterProfessor(String filterProfessor) {
		this.filterProfessor = filterProfessor;
	}

	/**
	 * @return the listProfesores
	 */
	public List<Profesor> getListProfesores() {
		return listProfesores;
	}

	/**
	 * @param listProfesores the listProfesores to set
	 */
	public void setListProfesores(List<Profesor> listProfesores) {
		this.listProfesores = listProfesores;
	}


	

}
