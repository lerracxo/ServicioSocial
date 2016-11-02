package com.ipn.esca.serviciosocial.mb.impl;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.ipn.esca.serviciosocial.common.Paginas;

@ManagedBean(name = "systemMB")
@ViewScoped
public class SystemMB extends GenericMB implements Serializable {
	private static final long serialVersionUID = 7930745241666648980L;
	
	
	public String navToMainPage(){
		return Paginas.PRINCIPAL;
	}

	

}
