package com.nielsen.monitor.dto;

import java.io.Serializable;

public interface GenericDTO extends Serializable{
	
	GenericDTO newInstance(Object[] l);

}
