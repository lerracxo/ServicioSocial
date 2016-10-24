ALTER TABLE cat_usuarios
  ADD CONSTRAINT fk_cat_usuarios_cat_perfiles FOREIGN KEY (id_perfil)
  REFERENCES cat_perfiles (id_perfil);
  
ALTER TABLE personas
  ADD CONSTRAINT fk_personas_cat_usuarios FOREIGN KEY (id_personas)
  REFERENCES cat_usuarios (id_personas);
  
ALTER TABLE contacto
  ADD CONSTRAINT fk_contacto_personas FOREIGN KEY (id_personas)
  REFERENCES personas (id_personas);
  
ALTER TABLE profesores
  ADD CONSTRAINT fk_profesores_personas FOREIGN KEY (id_personas)
  REFERENCES personas (id_personas);
  
ALTER TABLE experiencia
  ADD CONSTRAINT fk_experiencia_profesores FOREIGN KEY (id_profesor)
  REFERENCES profesores (id_profesor);
  
ALTER TABLE rel_prof_materia
  ADD CONSTRAINT fk_rel_prof_materia_profesores FOREIGN KEY (id_profesor)
  REFERENCES profesores (id_profesor);
  
ALTER TABLE rel_prof_materia
  ADD CONSTRAINT fk_rel_prof_materia_cat_materias FOREIGN KEY (id_materia)
  REFERENCES cat_materias (id_materia);
  
ALTER TABLE cat_materias
  ADD CONSTRAINT fk_cat_turno_cat_materias FOREIGN KEY (id_turno)
  REFERENCES cat_turno (id_turno);
  
ALTER TABLE cat_especialidad
  ADD CONSTRAINT fkcat_especialidad_profesores_ FOREIGN KEY (id_profesor)
  REFERENCES profesores (id_profesor);
  
ALTER TABLE rel_espe_tipogrado
  ADD CONSTRAINT fk_rel_espe_tipogrado_cat_especialidad FOREIGN KEY (id_especialidad)
  REFERENCES cat_especialidad (id_especialidad);
  
ALTER TABLE rel_espe_tipogrado
  ADD CONSTRAINT fk_rel_espe_tipogrado_cat_tipogrado FOREIGN KEY (id_tipogrado)
  REFERENCES cat_tipogrado (id_tipogrado);
  
ALTER TABLE profesores
  ADD CONSTRAINT fk_profesores_cursos FOREIGN KEY (id_curso)
  REFERENCES cursos (id_curso);

ALTER TABLE cursos
  ADD CONSTRAINT fk_cursos_cat_eje FOREIGN KEY (id_eje)
  ReFERENCES cat_eje (id_eje);
  
ALTER TABLE cursos
  ADD CONSTRAINT fk_cursos_rel_curso_tipocurso FOREIGN KEY (id_curso)
  REFERENCES rel_curso_tipocurso (id_curso);
  
ALTER TABLE rel_curso_tipocurso 
  ADD CONSTRAINT fk_rel_curso_tipocurso_cat_tipocurso FOREIGN KEY (id_tipocurso)
  REFERENCES cat_tipocurso (id_tipocurso);
  
ALTER TABLE profesores
  ADD CONSTRAINT fk_profesores_calificaciones FOREIGN KEY (id_calificacion)
  REFERENCES calificaciones (id_calificacion);
  
ALTER TABLE calificaciones 
  ADD CONSTRAINT fk_calificaciones_cat_tipoevaluaciones FOREIGN KEY (id_tipoevaluacion)
  REFERENCES cat_tipoevaluaciones (id_tipoevaluacion);
