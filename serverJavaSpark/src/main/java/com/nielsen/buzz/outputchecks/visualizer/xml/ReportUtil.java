package com.nielsen.buzz.outputchecks.visualizer.xml;

import java.util.ArrayList;
import java.util.List;

import com.nielsen.buzz.outputchecks.visualizer.entity.Dimension;
import com.nielsen.buzz.outputchecks.visualizer.entity.Header;
import com.nielsen.buzz.outputchecks.visualizer.entity.Outliers;
import com.nielsen.buzz.outputchecks.visualizer.entity.Side;
import com.nielsen.buzz.outputchecks.visualizer.xml.Report.DataBase.Dimension.CIP.Row;
import com.nielsen.buzz.outputchecks.visualizer.xml.Report.DataBase.Dimension.Legacy;
import com.nielsen.buzz.outputchecks.visualizer.xml.Report.DataBase.Dimension.CIP;
import com.nielsen.buzz.outputchecks.visualizer.xml.Report.DataBase.Dimension.CIP.Columns.Column;

public class ReportUtil {

	public static List<Dimension> getDimensions(Report report) {
		ArrayList<Dimension> result = new ArrayList<Dimension>();
		for (com.nielsen.buzz.outputchecks.visualizer.xml.Report.DataBase.Dimension dimP : report.dataBase.dimension) {
			Dimension dim = new Dimension();
			dim.setName(dimP.name);
			dim.setStatus(dimP.status);

			dim.setCip(getSide(dimP.cip));
			dim.setLegacy(getSide(dimP.legacy));
			
			result.add(dim);
		}
		return result;
	}

	public static List<Outliers> getOutliers(Report report) {
		ArrayList<Outliers> result = new ArrayList<Outliers>();
		for (com.nielsen.buzz.outputchecks.visualizer.xml.Report.DataBase.Outlier outP : report.dataBase.outlier) {
			
			Outliers outlier = new Outliers();
			outlier.setHeader(getHeader(outP.header,outP.row));
			outlier.setCip(getSideOutlier(outP.cip));
			outlier.setLegacy(getSideOutlier(outP.legacy));
			
			result.add(outlier);
		}
		return result;
	}
	
	private static Header getHeader(com.nielsen.buzz.outputchecks.visualizer.xml.Report.DataBase.Outlier.Header titles,com.nielsen.buzz.outputchecks.visualizer.xml.Report.DataBase.Outlier.Row fields){
		Header header = new Header();
		header.setColumns(getHeadColumns(titles.column));
		header.setFields(getHeadDataTableOutlier(fields.field));
		
		return header;
	}
	
	private static Side getSide(CIP cip) {
		Side result = new Side();
		result.setName("Cip");
		result.setColumns(getCipColumns(cip.columns.column));
		result.setDataTable(getCipDataTable(cip.row));
		return result;
	}
	
	private static Side getSideOutlier(com.nielsen.buzz.outputchecks.visualizer.xml.Report.DataBase.Outlier.CIP cip) {
		Side result = new Side();
		result.setName("Cip");
		//result.setColumns(getCipColumns(cip.columns.column));
		result.setDataTable(getCipDataTableOutlier(cip.row));
		return result;
	}

	private static Side getSide(Legacy legacy) {
		Side result = new Side();
		result.setName("Legacy");
		result.setColumns(getLegacyColumns(legacy.columns.column));
		result.setDataTable(getLegacyDataTable(legacy.row));
		return result;
	}
	
	private static Side getSideOutlier(com.nielsen.buzz.outputchecks.visualizer.xml.Report.DataBase.Outlier.Legacy legacy) {
		Side result = new Side();
		result.setName("Legacy");
		//result.setColumns(getLegacyColumns(legacy.columns.column));
		result.setDataTable(getLegacyDataTableOutlier(legacy.row));
		return result;
	}
	
	private static List<ArrayList<String>> getLegacyDataTable(
			List<com.nielsen.buzz.outputchecks.visualizer.xml.Report.DataBase.Dimension.Legacy.Row> row) {
		
		ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
		if(row == null) {
			return result;
		}
		
		for (com.nielsen.buzz.outputchecks.visualizer.xml.Report.DataBase.Dimension.Legacy.Row rows : row) {
			ArrayList<String> rowData = new ArrayList<String>();
			for (com.nielsen.buzz.outputchecks.visualizer.xml.Report.DataBase.Dimension.Legacy.Row.Field field : rows.field) {
				rowData.add(field.val);
			}
			result.add(rowData);
		}
		return result;
	}
	
	private static List<ArrayList<String>> getLegacyDataTableOutlier(
			List<com.nielsen.buzz.outputchecks.visualizer.xml.Report.DataBase.Outlier.Legacy.Row> row) {
		
		ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
		if(row == null) {
			return result;
		}
		
		for (com.nielsen.buzz.outputchecks.visualizer.xml.Report.DataBase.Outlier.Legacy.Row rows : row) {
			ArrayList<String> rowData = new ArrayList<String>();
			for (com.nielsen.buzz.outputchecks.visualizer.xml.Report.DataBase.Outlier.Legacy.Row.Field field : rows.field) {
				rowData.add(field.val);
			}
			result.add(rowData);
		}
		return result;
	}

	private static List<String> getLegacyColumns(
			List<com.nielsen.buzz.outputchecks.visualizer.xml.Report.DataBase.Dimension.Legacy.Columns.Column> column) {
		
		List<String> result = new ArrayList<String>();
		for (com.nielsen.buzz.outputchecks.visualizer.xml.Report.DataBase.Dimension.Legacy.Columns.Column col : column) {
			result.add(col.val);
		}
		return result;
	}
	
	

	private static List<ArrayList<String>> getCipDataTable(List<Row> row) {
		ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
		
		if(row == null) {
			return result;
		}
		
		for (Row rows : row) {

			ArrayList<String> rowData = new ArrayList<String>();
			for (Report.DataBase.Dimension.CIP.Row.Field field : rows.field) {
				rowData.add(field.val);
			}
			result.add(rowData);
		}
		return result;
	}
	
	private static List<ArrayList<String>> getCipDataTableOutlier(List<com.nielsen.buzz.outputchecks.visualizer.xml.Report.DataBase.Outlier.CIP.Row> row) {
		ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
		
		if(row == null) {
			return result;
		}
		
		for (com.nielsen.buzz.outputchecks.visualizer.xml.Report.DataBase.Outlier.CIP.Row rows : row) {

			ArrayList<String> rowData = new ArrayList<String>();
			for (com.nielsen.buzz.outputchecks.visualizer.xml.Report.DataBase.Outlier.CIP.Row.Field field : rows.field) {
				rowData.add(field.val);
			}
			result.add(rowData);
		}
		return result;
	}

	private static List<String> getCipColumns(List<Column> column) {
		List<String> result = new ArrayList<String>();
		for (Column col : column) {
			result.add(col.val);
		}
		return result;
	}
	
	private static List<String> getHeadColumns(List<com.nielsen.buzz.outputchecks.visualizer.xml.Report.DataBase.Outlier.Header.Column> column) {
		List<String> result = new ArrayList<String>();
		for (com.nielsen.buzz.outputchecks.visualizer.xml.Report.DataBase.Outlier.Header.Column col : column) {
			result.add(col.val);
		}
		return result;
	}
	
	private static List<String> getHeadDataTableOutlier(List<com.nielsen.buzz.outputchecks.visualizer.xml.Report.DataBase.Outlier.Row.Field> fields) {
		List<String> result = new ArrayList<String>();
		for (com.nielsen.buzz.outputchecks.visualizer.xml.Report.DataBase.Outlier.Row.Field field : fields) {
			result.add(field.val);
		}
		return result;
	}
}
