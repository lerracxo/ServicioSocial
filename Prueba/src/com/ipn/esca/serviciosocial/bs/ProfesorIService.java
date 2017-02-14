package com.ipn.esca.serviciosocial.bs;

import com.ipn.esca.serviciosocial.entities.Profesor;

import java.util.List;

public interface ProfesorIService {

    List<Profesor> getProfesoresByFilter(Profesor filter);

    List<Profesor> getProfesoresByFilter(String filterProfessor);

    List<Profesor> getProfesorById(String id);


//	List<SystemSDTO> getSystems(SystemSDTO filter);
//
//	List<ProcessSDTO> getProcess(ProcessSDTO processFilter);
//
//	List<ProcessStepsDTO> getProcessSteps(ProcessStepsDTO processStepFilter);
}
