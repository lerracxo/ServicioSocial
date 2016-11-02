package com.ipn.esca.serviciosocial.dao;

import java.util.List;

import com.ipn.esca.serviciosocial.entities.Profesor;


public interface ProfesorDAO extends GenericDAO<Profesor, Long> {
	
	List<Profesor> getAllProfesores();
	
	List<Profesor> getProfesoresByFilter(String Filter);
	
}