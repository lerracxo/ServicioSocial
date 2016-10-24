DROP TABLE IF EXISTS personas CASCADE;

CREATE TABLE personas
(
   id_persona    serial        NOT NULL,
   nombre        varchar(50),
   a_paterno     varchar(20),
   a_materno     varchar(20),
   nacionalidad  varchar(15)
);

-- Column id_persona is associated with sequence public.personas_id_personas_seq

ALTER TABLE personas
   ADD CONSTRAINT personas_pkey
   PRIMARY KEY (id_persona);
   
DROP TABLE IF EXISTS profesores CASCADE;

CREATE TABLE profesores
(
   id_profesor      integer       NOT NULL,
   cedula           varchar(50),
   rfc              varchar(15),
   fec_ingreso      varchar(10),
   examen_op        boolean,
   id_curso         integer,
   id_calificacion  integer
);

-- Column id_profesor is associated with sequence public.profesores_id_profesor_seq

ALTER TABLE public.profesores
   ADD CONSTRAINT profesores_pkey
   PRIMARY KEY (id_profesor);
   
   
DROP TABLE IF EXISTS cat_perfiles CASCADE;

CREATE TABLE cat_perfiles(
id_perfil serial,
perfil varchar(25),
descripcion varchar(100),
primary key (id_perfil)
);

DROP TABLE IF EXISTS cat_usuarios CASCADE;
CREATE TABLE cat_usuarios(
id_persona int,
usuario varchar(30),
contra_cifrada varchar(10),
id_perfil int,
primary key (id_persona)
);

DROP TABLE IF EXISTS contacto CASCADE;
CREATE TABLE contacto(
id_persona int,
tel_fijo int,
tel_movil int,
tel_trabajo int,
ext int,
correo_elec varchar(50),
primary key (id_persona)
);



DROP TABLE IF EXISTS experiencia CASCADE;
CREATE TABLE experiencia(
id_profesor int,
experiencia varchar(300),
trabajos_inv varchar(300),
primary key (id_profesor)
);

DROP TABLE IF EXISTS rel_prof_materia CASCADE;
CREATE TABLE rel_prof_materia(
id_relacion serial,
id_profesor int,
id_materia int,
primary key (id_relacion)
);

DROP TABLE IF EXISTS cat_materias CASCADE;
CREATE TABLE cat_materias(
id_materia serial,
materia varchar(20),
id_escuela int,
id_turno int,
primary key (id_materia)
);

DROP TABLE IF EXISTS cat_turno CASCADE;
CREATE TABLE cat_turno(
id_turno serial,
turno varchar(15),
primary key (id_turno)
);

DROP TABLE IF EXISTS cat_escuela CASCADE;
CREATE TABLE cat_escuela(
id_escuela serial,
escuela varchar(100),
institucion varchar(100),
primary key (id_escuela)
);

DROP TABLE IF EXISTS cat_especialidad CASCADE;
CREATE TABLE cat_especialidad(
id_especialidad serial,
nombre varchar(70),
id_tipogrado int,
id_profesor int,
primary key (id_especialidad)
);


DROP TABLE IF EXISTS rel_espe_tipogrado CASCADE;
CREATE TABLE rel_espe_tipogrado(
id_relacion serial,
id_especialidad int,
id_tipogrado int,
primary key (id_relacion)
);


DROP TABLE IF EXISTS cat_tipogrado CASCADE;
CREATE TABLE cat_tipogrado(
id_tipogrado serial,
tipo_grado varchar(20),
descripcion varchar(300),
prioridad int,
primary key (id_tipogrado)
);


DROP TABLE IF EXISTS cursos CASCADE;
CREATE TABLE cursos(
id_curso serial,
nombre varchar(70),
descripcion varchar(300),
fec_inicio varchar(10),
fec_fin varchar(10),
id_eje int,
primary key (id_curso)
);


DROP TABLE IF EXISTS cat_eje CASCADE;
CREATE TABLE cat_eje(
id_eje serial,
nombre varchar(50),
descripcion varchar (300),
primary key (id_eje)
);


DROP TABLE IF EXISTS calificaciones CASCADE;
CREATE TABLE calificaciones(
id_calificacion serial,
calificacion int,
id_tipoevaluacion int,
primary key (id_calificacion)
);


DROP TABLE IF EXISTS rel_curso_tipocurso CASCADE;
CREATE TABLE rel_curso_tipocurso(
id_curso int,
id_tipocurso int,
primary key (id_curso)
);


DROP TABLE IF EXISTS cat_tipocurso CASCADE;
CREATE TABLE cat_tipocurso(
id_tipocurso serial,
tipocurso varchar(20),
descripcion varchar (300),
primary key (id_tipocurso)
);


DROP TABLE IF EXISTS cat_tipoevaluaciones CASCADE;
CREATE TABLE cat_tipoevaluaciones(
id_tipoevaluacion serial,
evaluacion varchar(25),
descripcion varchar(300),
primary key (id_tipoevaluacion)
);


ALTER TABLE cat_usuarios
  ADD CONSTRAINT fk_cat_usuarios_cat_perfiles FOREIGN KEY (id_perfil)
  REFERENCES cat_perfiles (id_perfil);
  
ALTER TABLE cat_usuarios
  ADD CONSTRAINT fk_cat_usuarios_personas FOREIGN KEY (id_persona)
  REFERENCES personas (id_persona);
  
ALTER TABLE contacto
  ADD CONSTRAINT fk_contacto_personas FOREIGN KEY (id_persona)
  REFERENCES personas (id_persona);
  
ALTER TABLE profesores
  ADD CONSTRAINT fk_profesores_personas FOREIGN KEY (id_profesor)
  REFERENCES personas (id_persona);
  
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
