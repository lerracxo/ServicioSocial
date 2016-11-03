package com.ipn.esca.serviciosocial.mb.impl;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.ipn.esca.serviciosocial.common.Pages;

@ManagedBean(name = "systemMB")
@SessionScoped
public class SystemMB extends GenericMB implements Serializable {
	private static final long serialVersionUID = 7930745241666648980L;
	
	private String actualPage; 
	
	/** Function to control the flow and the active flag on left menu
	 * @return
	 */
	public String getActualPage(){
		return actualPage;
	}
	
	public String getNavToMainPage(){
		this.actualPage = Pages.PRINCIPAL;
		return this.actualPage;
	}
	
	public String getNavToInformation(){
		this.actualPage = Pages.INFORMATION;
		return this.actualPage;
	}
	
	public String getNavToWelcome(){
		this.actualPage = Pages.WELCOME;
		return this.actualPage;
	}
	

}
