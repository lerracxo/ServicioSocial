package com.nielsen.monitor.common;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityNotFoundException;

import com.nielsen.monitor.dto.EventlogDTO;
import com.nielsen.monitor.dto.FileColumnDTO;
import com.nielsen.monitor.dto.FileValidationResultDTO;
import com.nielsen.monitor.dto.FileValidationResultDetailDTO;
import com.nielsen.monitor.dto.FileValidationResultDetailPKDTO;
import com.nielsen.monitor.dto.FileValidationResultIdDTO;
import com.nielsen.monitor.dto.GenericDTO;
import com.nielsen.monitor.dto.ProcessSDTO;
import com.nielsen.monitor.dto.ProcessStepsDTO;
import com.nielsen.monitor.dto.SystemFileDTO;
import com.nielsen.monitor.dto.SystemFilePKDTO;
import com.nielsen.monitor.dto.SystemSDTO;
import com.nielsen.monitor.dto.ValidationDTO;
import com.nielsen.monitor.entities.FileColumn;
import com.nielsen.monitor.entities.SystemFile;
import com.nielsen.monitor.entities.SystemS;
import com.nielsen.monitor.entities.eventlog.ProcessS;
import com.nielsen.monitor.entities.eventlog.ProcessSteps;
import com.nielsen.monitor.entities.validation.FileValidationResult;
import com.nielsen.monitor.entities.validation.FileValidationResultDetail;
import com.nielsen.monitor.entities.validation.FileValidationResultId;
import com.nielsen.monitor.entities.validation.Validation;

public class Converter {

	public static List<SystemSDTO> toDTOSystemS(List<SystemS> r) {
		if (r == null || r.isEmpty())
			return null;

		List<SystemSDTO> result = new ArrayList<SystemSDTO>();
		for (SystemS s : r) {
			result.add(new SystemSDTO(s));
		}
		return result;
	}

	public static List<ProcessStepsDTO> toDTOListProcessSteps(List<ProcessSteps> list) {
		if (list == null || list.isEmpty())
			return null;

		List<ProcessStepsDTO> result = new ArrayList<ProcessStepsDTO>();
		Set<ProcessStepsDTO> set = new HashSet<ProcessStepsDTO>();
		for (ProcessSteps l : list) {
			set.add(new ProcessStepsDTO(l));
		}
		result.addAll(set);
		return result;
	}

	public static List<ProcessSDTO> toDTOListProcessSDTO(List<ProcessS> list) {
		if (list == null || list.isEmpty())
			return null;

		List<ProcessSDTO> result = new ArrayList<ProcessSDTO>();
		for (ProcessS l : list) {
			result.add(new ProcessSDTO(l));
		}
		return result;
	}

	public static List<GenericDTO> toGenericDTO(GenericDTO arg, List<Object[]> list) {
		if (list == null || list.isEmpty())
			return null;

		List<GenericDTO> result = new ArrayList<GenericDTO>();
		for (Object[] l : list) {
			GenericDTO obj = arg.newInstance(l);
			result.add(obj);
		}
		return result;
	}

	public static List<EventlogDTO> toDTOListEventlogDTO(List<Object[]> list) {
		List<EventlogDTO> result = null;
		if (list != null && !list.isEmpty())
			result = new ArrayList<EventlogDTO>();
		for (Object[] l : list) {
			EventlogDTO event = new EventlogDTO();
			event.setCountry_id(l[0] != null ? new Integer(l[0].toString()) : null);
			event.setSystem_cod(l[1] != null ? l[1].toString() : null);
			event.setProcess_id(l[2] != null ? new Integer(l[2].toString()) : null);
			event.setStep(l[3] != null ? new Integer(l[3].toString()) : null);
			event.setPeriodid(l[4] != null ? new Integer(l[4].toString()) : null);
			event.setEventtype(l[5] != null ? new Integer(l[5].toString()) : null);
			event.setSource(l[6] != null ? l[6].toString() : null);
			event.setServername(l[7] != null ? l[7].toString() : null);
			event.setDatabase(l[8] != null ? l[8].toString() : null);
			event.setMessage(l[9] != null ? l[9].toString() : null);
			event.setTime(l[10] != null ? new Date(Timestamp.valueOf(l[10].toString()).getTime()) : null);
			event.setSeverity(l[11] != null ? new Integer(l[11].toString()) : null);
			result.add(event);
		}
		return result;
	}

	public static List<FileValidationResultDTO> toListFileValidationsResultDTO(List<FileValidationResult> resultList) {
		List<FileValidationResultDTO> list = null;
		if (!resultList.isEmpty())
			list = new ArrayList<FileValidationResultDTO>();

		for (FileValidationResult l : resultList) {
			FileValidationResultDTO r = new FileValidationResultDTO();
			r.setExecutionId(l.getExecutionId());
			r.setSystemCod(l.getSystemCod());
			r.setFileName(l.getFileName());
			List<FileValidationResultDetailDTO> fileValidationResultDetails = toListFileValidationResultDetailDTO(
					l.getFileValidationResultDetails());
			r.setFileValidationResultDetails(fileValidationResultDetails);
			r.setRegDte(l.getRegDte());
			r.setStatusBol(l.getStatusBol());
			r.setSystemFile(toSystemFileDTO(l.getSystemFile()));
			// r.setSystemFile(null);
			r.setUsrCode(l.getUsrCode());
			r.setValidation(toValidationDTO(l.getValidation()));
			list.add(r);
		}
		return list;
	}

	public static List<FileValidationResultDetailDTO> toListFileValidationResultDetailDTO(
			List<FileValidationResultDetail> list) {
		List<FileValidationResultDetailDTO> result = null;
		if (!list.isEmpty())
			result = new ArrayList<FileValidationResultDetailDTO>();

		for (FileValidationResultDetail l : list) {
			FileValidationResultDetailDTO r = new FileValidationResultDetailDTO();

			r.setFileColumn(toFileColumnDTO(l.getFileColumn()));
			r.setFileValidationResult(null); // to be provided by caller
			r.setFileValidationResultIds(toFileValidationResultIdsDTO(l.getFileValidationResultIds()));
			FileValidationResultDetailPKDTO id = new FileValidationResultDetailPKDTO();
			id.setColumnId(l.getId().getColumnId());
			id.setConstraintId(l.getId().getConstraintId());
			id.setExecutionId(l.getId().getExecutionId());
			id.setValidationId(l.getId().getValidationId());
			r.setId(id);
			r.setInvalidRecordsNum(l.getInvalidRecordsNum());
			r.setRegDte(l.getRegDte());
			r.setStatusBol(l.getStatusBol());
			r.setUsrCode(l.getUsrCode());
			r.setValidation(toValidationDTO(l.getValidation()));
			result.add(r);
		}
		return result;
	}

	private static ValidationDTO toValidationDTO(Validation l) {
		if (l == null || l.getValidationId() == null)
			return null;
		ValidationDTO r = new ValidationDTO();
		r.setFileValidationResultDetails(null);
		r.setFileValidationResults(null);
		r.setRegDte(l.getRegDte());
		r.setUsrCode(l.getUsrCode());
		r.setValidationDsc(l.getValidationDsc());
		r.setValidationId(l.getValidationId());
		r.setValidationName(l.getValidationName());
		return r;
	}

	public static FileColumnDTO toFileColumnDTO(FileColumn l) {
		if (l == null || l.getColumnId() == null)
			return null;
		FileColumnDTO r = new FileColumnDTO();
		r.setColumnId(l.getColumnId());
		r.setColumnName(l.getColumnName());
		r.setColumnOrder(l.getColumnOrder());
		r.setFileValidationResultDetails(null);
		r.setNullable(l.getNullable());
		r.setRegDte(l.getRegDte());
		r.setSystemFile(null);
		r.setUsrCode(l.getUsrCode());
		return r;
	}

	public static SystemFileDTO toSystemFileDTO(SystemFile l) {
		SystemFileDTO r = null;
		try {
			if (l == null || l.getCtrlFileId() == null)
				return null;
			r = new SystemFileDTO();
			r.setActive(l.getActive());
			r.setCtrlFileBol(l.getCtrlFileBol());
			r.setCtrlFileId(l.getCtrlFileId());
			r.setDelimiterChar(l.getDelimiterChar());
			r.setFileColumns(toListFileColumnsDTO(l.getFileColumns()));
			r.setFileDesc(l.getFileDesc());
			r.setFileExt(l.getFileExt());
			r.setFileName(l.getFileName());
			r.setFileValidationResults(null); // to be provided by caller

			SystemFilePKDTO id = new SystemFilePKDTO();
			id.setFileId(l.getId().getFileId());
			id.setSystemCod(l.getId().getSystemCod());
			r.setId(id);
			r.setMayBeEmpty(l.getMayBeEmpty());
			r.setSchemaName(l.getSchemaName());
			r.setRegDte(l.getRegDte());
			r.setSystem(new SystemSDTO(l.getSystem()));
			r.setTableName(l.getTableName());
			r.setUsrCode(l.getUsrCode());
		} catch (EntityNotFoundException ex) {
			//ex.printStackTrace();
		}

		return r;
	}

	public static List<FileColumnDTO> toListFileColumnsDTO(List<FileColumn> fileColumns) {
		List<FileColumnDTO> result = null;
		if (!fileColumns.isEmpty()) {
			result = new ArrayList<FileColumnDTO>();
		}

		for (FileColumn l : fileColumns) {
			FileColumnDTO r = new FileColumnDTO();
			r.setColumnId(l.getColumnId());
			r.setColumnName(l.getColumnName());
			r.setColumnOrder(l.getColumnOrder());
			r.setFileValidationResultDetails(null); // to be provided by caller
			r.setNullable(l.getNullable());
			r.setRegDte(l.getRegDte());
			r.setSystemFile(null); // to be provided by caller
			r.setUsrCode(l.getUsrCode());
			result.add(r);
		}
		// TODO Auto-generated method stub
		return result;
	}

	private static List<FileValidationResultIdDTO> toFileValidationResultIdsDTO(List<FileValidationResultId> list) {
		List<FileValidationResultIdDTO> result = null;
		if (!list.isEmpty())
			result = new ArrayList<FileValidationResultIdDTO>();
		

		for (FileValidationResultId l : list) {
			FileValidationResultIdDTO r = new FileValidationResultIdDTO();
			r.setFileValidationResultDetail(null); // to be provided by caller
			r.setPrimaryContent(l.getPrimaryContent());
			r.setSerialId(l.getSerialId());
			r.setRegDte(l.getRegDte());
			r.setUsrCode(l.getUsrCode());
			result.add(r);
		}
		// TODO Auto-generated method stub
		return result;
	}

}
