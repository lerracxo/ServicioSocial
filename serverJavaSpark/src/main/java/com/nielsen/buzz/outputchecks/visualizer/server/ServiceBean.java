package com.nielsen.buzz.outputchecks.visualizer.server;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBException;

import com.nielsen.buzz.outputchecks.visualizer.entity.Database;
import com.nielsen.buzz.outputchecks.visualizer.entity.Dimension;
import com.nielsen.buzz.outputchecks.visualizer.entity.Side;
import com.nielsen.buzz.outputchecks.visualizer.xml.ReportManager;

public class ServiceBean {

	private static ServiceBean service = null;
	private ReportManager backService = null;

	private String path = "C:/Users/saos6001/Repository/OutputChecks/OutputCheck/OutputChecks/";

	public ServiceBean() {
		try {
			backService = ReportManager.getInstance();
		} catch (FileNotFoundException | JAXBException e) {
			System.out.println("Could not initialize ReportManager Instance");
			e.printStackTrace();
		}
	}

	public static ServiceBean getInstance() {
		if (service == null)
			service = new ServiceBean();
		return service;
	}

	public List<Database> getDatabases() {
		return backService.getDatabases();
	}

	public Database getDatabase(int id) {
		Database result = null;
		try {
			for (Database target : backService.getDatabases()) {
				if (target.getInternalID() == id) {
					result = backService.getDataBaseDetail(target);
					break;
				}
			}
		} catch (JAXBException e) {

			e.printStackTrace();
		}

		return result;
	}

	public File[] finder(String dirName) {
		File dir = new File(dirName);

		return dir.listFiles(new FilenameFilter() {
			@Override
			public boolean accept(File dir, String name) {
				return name.toLowerCase().endsWith(".xml");
			}
		});
	}
}
