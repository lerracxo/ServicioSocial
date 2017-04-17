package com.ipn.esca.serviciosocial.dao;

import java.util.List;

import com.ipn.esca.serviciosocial.entities.Profesor;


public interface ProfesorDAO {

	List<Profesor> getProfessorById(String id);

	List<Profesor> getProfesoresByFilter(String Filter);
	
}