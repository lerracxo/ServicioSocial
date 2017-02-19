package com.nielsen.buzz.outputchecks.visualizer.entity;

public class Dimension {
	private String name;
	private String status;
	
	private Side cip;
	private Side legacy;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Side getCip() {
		return cip;
	}
	public void setCip(Side cip) {
		this.cip = cip;
	}
	public Side getLegacy() {
		return legacy;
	}
	public void setLegacy(Side legacy) {
		this.legacy = legacy;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	

}
