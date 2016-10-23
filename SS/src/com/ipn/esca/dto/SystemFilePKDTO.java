package com.nielsen.monitor.dto;

public class SystemFilePKDTO implements GenericDTO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 169556615645169719L;
	private String systemCod;
	private Integer fileId;

	public SystemFilePKDTO() {
	}
	public String getSystemCod() {
		return this.systemCod;
	}
	public void setSystemCod(String systemCod) {
		this.systemCod = systemCod;
	}
	public Integer getFileId() {
		return this.fileId;
	}
	public void setFileId(Integer fileId) {
		this.fileId = fileId;
	}
	@Override
	public GenericDTO newInstance(Object[] l) {
		// TODO Auto-generated method stub
		return null;
	}
}