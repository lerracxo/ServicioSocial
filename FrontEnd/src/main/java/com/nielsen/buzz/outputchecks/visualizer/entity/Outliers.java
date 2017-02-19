package com.nielsen.buzz.outputchecks.visualizer.entity;

public class Outliers extends GenericEntity {
	
	private Header header;
	private Side cip;
	private Side legacy;

	public Header getHeader() {
		return header;
	}
	public void setHeader(Header header) {
		this.header = header;
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
	
}
