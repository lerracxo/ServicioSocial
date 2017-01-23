package com.nielsen.buzz.outputchecks.visualizer.entity;

import java.io.File;
import java.util.List;

public class Database extends GenericEntity{
	private int internalID;
	private transient File xmlFile;
	
	private String name;
	private String status;
	
	
	//this part of the object is intended to be null until called by id, and filled by xml file log reader service
	private List<Dimension> dimensions;	
	private List<Outliers> outliers;
	
	
	public Database(String nombre, String status){
		this.name = nombre;
		this.status = status;
	}
	
	public Database(String nombre, String status, int internalID){
		this.name = nombre;
		this.status = status;
		this.internalID = internalID;
	}
	
	public String getNombre() {
		return name;
	}
	public void setNombre(String nombre) {
		this.name = nombre;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Dimension> getDimensions() {
		return dimensions;
	}

	public void setDimensions(List<Dimension> dimensions) {
		this.dimensions = dimensions;
	}

	public List<Outliers> getOutliers() {
		return outliers;
	}

	public void setOutliers(List<Outliers> outliers) {
		this.outliers = outliers;
	}

	public int  getInternalID() {
		return internalID;
	}

	public Database setInternalID(int internalID) {
		this.internalID = internalID;
		return this;
	}

	public File getXmlFile() {
		return xmlFile;
	}

	public Database setXmlFile(File xmlFile) {
		this.xmlFile = xmlFile;
		return this;
	}

	@Override
	public String toString(){
		return "Name: "+this.name+" status: "+status+" File: "+xmlFile.getName();
		
	}
}
