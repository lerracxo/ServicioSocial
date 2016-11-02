package com.ipn.esca.serviciosocial.bs;

import java.util.List;

import com.ipn.esca.serviciosocial.entities.Profesor;

public interface ProfesorIService {
	
	List<Profesor> getProfesoresByFilter(Profesor filter);

	List<Profesor> getProfesoresByFilter(String filterProfessor);

//	List<SystemSDTO> getSystems(SystemSDTO filter);
//
//	List<ProcessSDTO> getProcess(ProcessSDTO processFilter);
//
//	List<ProcessStepsDTO> getProcessSteps(ProcessStepsDTO processStepFilter);
}
