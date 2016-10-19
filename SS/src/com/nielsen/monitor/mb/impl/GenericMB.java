package com.nielsen.monitor.mb.impl;

import java.io.Serializable;
import java.util.ResourceBundle;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class GenericMB implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8013908171110826876L;

	protected void addMessage(int type, String message) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(message));
    }
	
	protected String getMsgProperty(String key){
		FacesContext facesContext = FacesContext.getCurrentInstance();
		ResourceBundle messageBundleName = facesContext.getApplication().getResourceBundle(facesContext, "msg");
		return messageBundleName.getString(key);
		
		//Locale locale = facesContext.getViewRoot().getLocale();
		//ResourceBundle bundle = ResourceBundle.getBundle(messageBundleName, locale);
		//return bundle.getString(key);
	}
	
}
