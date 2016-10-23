package com.nielsen.monitor.mb.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.ipn2.esca.bs.ReportIService;
import com.nielsen.monitor.common.Constant;
import com.nielsen.monitor.dto.EventlogDTO;
import com.nielsen.monitor.dto.ProcessSDTO;
import com.nielsen.monitor.dto.ProcessStepsDTO;
import com.nielsen.monitor.dto.SystemSDTO;

@ManagedBean(name = "reportMB")
@ViewScoped
public class ReportMB extends GenericMB implements Serializable {
	private static final long serialVersionUID = 7930745241666648980L;
	
	@EJB(lookup="java:module/ReportServiceBean!com.nielsen.monitor.bs.ReportServiceLocal")
	private ReportIService service;
	

	private List<SystemSDTO> lSystems;
	private List<ProcessSDTO> lProcess;
	private List<ProcessStepsDTO> lProcessSteps;
	private List<EventlogDTO> lEventlogs;

	private SystemSDTO systemFilter;
	private ProcessSDTO processFilter;
	private ProcessStepsDTO processStepFilter;
	private EventlogDTO eventlogFilter;
	
	@PostConstruct
	private void init(){
		lSystems = new ArrayList<SystemSDTO>();
		lProcess= new ArrayList<ProcessSDTO>();
		lProcessSteps= new ArrayList<ProcessStepsDTO>();
		lEventlogs= new ArrayList<EventlogDTO>();
		
		systemFilter = new SystemSDTO();
		processFilter = new ProcessSDTO();
		processStepFilter = new ProcessStepsDTO();
		eventlogFilter = new EventlogDTO();
		
		populateSystem();
	}
	
	public void reset(){
		init();
	}
	
	public String navToFilter(){
		return Constant.FilterScreen;
	}
	
	public void populateSystem(){
		processFilter.clean();
		processStepFilter.clean();
		lProcess= new ArrayList<ProcessSDTO>();
		lProcessSteps= new ArrayList<ProcessStepsDTO>();
		lSystems = service.getSystems(systemFilter);
	} 
	
	public void populateProcess(){
		processStepFilter.clean();
		lProcessSteps= new ArrayList<ProcessStepsDTO>();
		processFilter.setSystem_cod(systemFilter.getSystem_cod());
		lProcess = service.getProcess(processFilter);
	}
	
	public void populateProcessSteps(){
		processStepFilter.setProcess_id(processFilter.getProcess_id());
		lProcessSteps = service.getProcessSteps(processStepFilter);
		lEventlogs= new ArrayList<EventlogDTO>();
	}
	public String getProjectVersion(){
		return Constant.PROJECT_VERSION;
	}
	private void populatelEventlog(){
		//validation
		try{
			if(systemFilter.getSystem_cod().isEmpty())
				throw new NullPointerException();
			if(processFilter.getProcess_id() == null)
				throw new NullPointerException();
			if(processStepFilter.getStep_order() == null)
				throw new NullPointerException();	
		}catch(NullPointerException e){
			addMessage(Constant.Error,getMsgProperty("formularyNotFilled"));
			return;
		}
		
		eventlogFilter.setSystem_cod(systemFilter.getSystem_cod());
		eventlogFilter.setProcess_id(processFilter.getProcess_id());
		eventlogFilter.setStep(processStepFilter.getStep_order());
		
		lEventlogs = service.getEvents(eventlogFilter);
	}

	@Deprecated
	public String navEventlog(){
		populatelEventlog();
		return Constant.ReportScreen;
	}
	
	public void findEvents(){
		populatelEventlog();
	}
	
	public String function(){
		System.out.println("Prueba");
		return "prueba";
	}
	

	/**
	 * @return the filter
	 */
	public SystemSDTO getSystemFilter() {
		return systemFilter;
	}

	/**
	 * @param filter the filter to set
	 */
	public void setSystemFilter(SystemSDTO filter) {
		this.systemFilter = filter;
	}

	/**
	 * @return the processFilterO
	 */
	public ProcessSDTO getProcessFilter() {
		return processFilter;
	}

	/**
	 * @param processFilter the processFilter to set
	 */
	public void setProcessFilter(ProcessSDTO processFilter) {
		this.processFilter = processFilter;
	}

	/**
	 * @return the processStepFilter
	 */
	public ProcessStepsDTO getProcessStepFilter() {
		return processStepFilter;
	}

	/**
	 * @param processStepFilter the processStepFilter to set
	 */
	public void setProcessStepFilter(ProcessStepsDTO processStepFilter) {
		this.processStepFilter = processStepFilter;
	}

	/**
	 * @return the lProcess
	 */
	public List<ProcessSDTO> getlProcess() {
		return lProcess;
	}

	/**
	 * @param lProcess the lProcess to set
	 */
	public void setlProcess(List<ProcessSDTO> lProcess) {
		this.lProcess = lProcess;
	}

	/**
	 * @return the lProcessSteps
	 */
	public List<ProcessStepsDTO> getlProcessSteps() {
		return lProcessSteps;
	}

	/**
	 * @param lProcessSteps the lProcessSteps to set
	 */
	public void setlProcessSteps(List<ProcessStepsDTO> lProcessSteps) {
		this.lProcessSteps = lProcessSteps;
	}

	/**
	 * @return the eventlogFilter
	 */
	public EventlogDTO getEventlogFilter() {
		return eventlogFilter;
	}

	/**
	 * @param eventlogFilter the eventlogFilter to set
	 */
	public void setEventlogFilter(EventlogDTO eventlogFilter) {
		this.eventlogFilter = eventlogFilter;
	}

	/**
	 * @return the lEventlogs
	 */
	public List<EventlogDTO> getlEventlogs() {
		return lEventlogs;
	}

	/**
	 * @param lEventlogs the lEventlogs to set
	 */
	public void setlEventlogs(List<EventlogDTO> lEventlogs) {
		this.lEventlogs = lEventlogs;
	}

	/**
	 * @return the lSystems
	 */
	public List<SystemSDTO> getlSystems() {
		return lSystems;
	}

	/**
	 * @param lSystems the lSystems to set
	 */
	public void setlSystems(List<SystemSDTO> lSystems) {
		this.lSystems = lSystems;
	}

}
