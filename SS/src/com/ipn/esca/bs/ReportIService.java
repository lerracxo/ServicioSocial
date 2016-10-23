package com.ipn.esca.bs;

import java.util.List;

import com.nielsen.monitor.dto.EventlogDTO;
import com.nielsen.monitor.dto.ProcessSDTO;
import com.nielsen.monitor.dto.ProcessStepsDTO;
import com.nielsen.monitor.dto.SystemSDTO;

public interface ReportIService {
	
	List<EventlogDTO> getEvents(EventlogDTO filter);

	List<SystemSDTO> getSystems(SystemSDTO filter);

	List<ProcessSDTO> getProcess(ProcessSDTO processFilter);

	List<ProcessStepsDTO> getProcessSteps(ProcessStepsDTO processStepFilter);
}
