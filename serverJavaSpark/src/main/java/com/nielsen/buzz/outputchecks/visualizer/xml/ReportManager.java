package com.nielsen.buzz.outputchecks.visualizer.xml;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import com.nielsen.buzz.outputchecks.visualizer.entity.Database;

public class ReportManager {
	private static final String dir = "C:/Users/saos6001/Repository/OutputChecks/OutputCheck/OutputChecks/";
	
	private static ReportManager reportManager = null;
	
	private Unmarshaller unmarshaller = null;
	private List<Database> listDatabases = null;

	public static ReportManager getInstance() throws FileNotFoundException, JAXBException{
		if(reportManager == null)
			reportManager = new ReportManager();
		return reportManager;
	}
	
	public static void main(String args[]) throws FileNotFoundException, JAXBException {
		ReportManager report = new ReportManager();
		for (Database ls : report.getDatabases()) {
			System.out.println("Database: " + ls);
			report.getDataBaseDetail(ls);
		}
	}

	public List<Database> getDatabases() {
		return this.listDatabases;
	}

	public ReportManager() throws FileNotFoundException, JAXBException {
		try {
			unmarshaller = JAXBContext.newInstance(Report.class).createUnmarshaller();
		} catch (Exception e) {
			e.printStackTrace();
		}
		listDatabases = indexDatabases(dir);
	}

	/**
	 * This method only return the databases indexed on a certain directory
	 * 
	 * @param directory
	 * @return
	 * @throws JAXBException
	 */
	private List<Database> indexDatabases(final String directory) throws FileNotFoundException, JAXBException {
		File dir = new File(directory);
		List<Database> result = new ArrayList<Database>();

		if (!dir.exists() || !dir.isDirectory())
			throw new FileNotFoundException("Directory " + directory + " not found");

		File[] lista = dir.listFiles(new FilenameFilter() {
			@Override
			public boolean accept(File file, String name) {
				boolean result = false;
				if (name.toLowerCase().contains("report") && name.toLowerCase().endsWith(".xml"))
					result = true;
				return result;
			}
		});
		for (int i = 0; i < lista.length; i++) 
			result.add(indexReport(lista[i]).setInternalID(i));
		
		return result;
	}

	private Database indexReport(File xml) throws JAXBException {
		Report aux = (Report) unmarshaller.unmarshal(xml);
		return new Database(aux.getDataBase().getName(), aux.getDataBase().getStatus()).setXmlFile(xml);
	}

	public Database getDataBaseDetail(Database database) throws JAXBException {
		Report report = (Report) unmarshaller.unmarshal(listDatabases.get(database.getInternalID()).getXmlFile());
		Database result = new Database(report.getDataBase().getName(), report.getDataBase().getStatus());
		result.setDimensions(ReportUtil.getDimensions(report));
		result.setOutliers(ReportUtil.getOutliers(report));
		
		return result;
	}
}
