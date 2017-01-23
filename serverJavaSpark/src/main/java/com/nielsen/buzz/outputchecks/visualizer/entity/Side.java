package com.nielsen.buzz.outputchecks.visualizer.entity;

import java.util.ArrayList;
import java.util.List;

public class Side {
	private String name;
	private List<String> columns;
	private List<ArrayList<String>> dataTable;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<String> getColumns() {
		return columns;
	}
	public void setColumns(List<String> columns) {
		this.columns = columns;
	}
	public List<ArrayList<String>> getDataTable() {
		return dataTable;
	}
	public void setDataTable(List<ArrayList<String>> dataTable) {
		this.dataTable = dataTable;
	}
	
	

	
}
