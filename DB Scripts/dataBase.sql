
/* Drop Tables */

DROP TABLE IF EXISTS r_calif_tipoeval;
DROP TABLE IF EXISTS r_prof_calif;
DROP TABLE IF EXISTS calificaciones;
DROP TABLE IF EXISTS r_curso_tipocurso;
DROP TABLE IF EXISTS r_prof_cursos;
DROP TABLE IF EXISTS cursos;
DROP TABLE IF EXISTS cat_eje;
DROP TABLE IF EXISTS r_materia_escuela;
DROP TABLE IF EXISTS cat_escuela;
DROP TABLE IF EXISTS r_esp_tipogrado;
DROP TABLE IF EXISTS r_prof_especialidad;
DROP TABLE IF EXISTS cat_especialidad;
DROP TABLE IF EXISTS r_materia_turno;
DROP TABLE IF EXISTS r_prof_materia;
DROP TABLE IF EXISTS cat_materias;
DROP TABLE IF EXISTS contacto;
DROP TABLE IF EXISTS experiencia;
DROP TABLE IF EXISTS ex_oposicion;
DROP TABLE IF EXISTS profesores;
DROP TABLE IF EXISTS personas;
DROP TABLE IF EXISTS cat_usuarios;
DROP TABLE IF EXISTS cat_perfiles;
DROP TABLE IF EXISTS cat_tipocurso;
DROP TABLE IF EXISTS cat_tipoevaluaciones;
DROP TABLE IF EXISTS cat_tipogrado;
DROP TABLE IF EXISTS cat_turno;
DROP TABLE IF EXISTS periodos;




/* Create Tables */

CREATE TABLE calificaciones
(
	id_calificacion serial NOT NULL UNIQUE,
	calificacion numeric,
	PRIMARY KEY (id_calificacion)
) WITHOUT OIDS;


CREATE TABLE cat_eje
(
	id_eje serial NOT NULL UNIQUE,
	eje text,
	descripcion text,
	PRIMARY KEY (id_eje)
) WITHOUT OIDS;


CREATE TABLE cat_escuela
(
	id_escuela serial NOT NULL UNIQUE,
	escuela text,
	institucion text,
	PRIMARY KEY (id_escuela)
) WITHOUT OIDS;


CREATE TABLE cat_especialidad
(
	id_especialidad serial NOT NULL UNIQUE,
	nombre text,
	PRIMARY KEY (id_especialidad)
) WITHOUT OIDS;


CREATE TABLE cat_materias
(
	id_materia serial NOT NULL UNIQUE,
	materia text,
	PRIMARY KEY (id_materia)
) WITHOUT OIDS;


CREATE TABLE cat_perfiles
(
	id_perfil serial NOT NULL UNIQUE,
	perfil text,
	descripcion text,
	PRIMARY KEY (id_perfil)
) WITHOUT OIDS;


CREATE TABLE cat_tipocurso
(
	id_tipocurso serial NOT NULL UNIQUE,
	tipo_curso text,
	descripcion text,
	PRIMARY KEY (id_tipocurso)
) WITHOUT OIDS;


CREATE TABLE cat_tipoevaluaciones
(
	id_tipoevaluaciones serial NOT NULL UNIQUE,
	tipo_evaluacion text,
	descripcion text,
	PRIMARY KEY (id_tipoevaluaciones)
) WITHOUT OIDS;


CREATE TABLE cat_tipogrado
(
	id_tipogrado serial NOT NULL UNIQUE,
	tipo_grado text,
	descripcion text,
	prioridad numeric,
	PRIMARY KEY (id_tipogrado)
) WITHOUT OIDS;


CREATE TABLE cat_turno
(
	id_turno serial NOT NULL UNIQUE,
	turno text,
	PRIMARY KEY (id_turno)
) WITHOUT OIDS;


CREATE TABLE cat_usuarios
(
	id_personas serial NOT NULL UNIQUE,
	usuario text,
	contra_cifrada text,
	id_perfil int NOT NULL UNIQUE,
	PRIMARY KEY (id_personas)
) WITHOUT OIDS;


CREATE TABLE contacto
(
	id_personas int NOT NULL UNIQUE,
	tel_fijo numeric,
	tel_movil numeric,
	tel_trabajo numeric,
	ext numeric,
	correo_elec text,
	PRIMARY KEY (id_personas)
) WITHOUT OIDS;


CREATE TABLE cursos
(
	id_cursos serial NOT NULL UNIQUE,
	nombre text,
	descripcion text,
	id_eje int NOT NULL UNIQUE,
	id_periodo int NOT NULL UNIQUE,
	PRIMARY KEY (id_cursos)
) WITHOUT OIDS;


CREATE TABLE experiencia
(
	id_profesor int NOT NULL UNIQUE,
	experiencia text,
	trabajos_inv text,
	PRIMARY KEY (id_profesor)
) WITHOUT OIDS;


CREATE TABLE ex_oposicion
(
	id_profesor int NOT NULL UNIQUE,
	ex_oposicion boolean,
	fec_realizado date,
	PRIMARY KEY (id_profesor)
) WITHOUT OIDS;


CREATE TABLE periodos
(
	id_periodo serial NOT NULL UNIQUE,
	fec_inicio date,
	fec_fin date,
	horas numeric,
	PRIMARY KEY (id_periodo)
) WITHOUT OIDS;


CREATE TABLE personas
(
	id_personas int NOT NULL UNIQUE,
	nombres text,
	a_paterno text,
	a_materno text,
	nacionalidad text,
	PRIMARY KEY (id_personas)
) WITHOUT OIDS;


CREATE TABLE profesores
(
	id_profesor int NOT NULL UNIQUE,
	cedula text,
	rfc text,
	fec_ingreso date,
	PRIMARY KEY (id_profesor)
) WITHOUT OIDS;


CREATE TABLE r_calif_tipoeval
(
	id_relacion serial NOT NULL UNIQUE,
	id_calificacion int NOT NULL UNIQUE,
	id_tipoevaluaciones int NOT NULL UNIQUE,
	PRIMARY KEY (id_relacion)
) WITHOUT OIDS;


CREATE TABLE r_curso_tipocurso
(
	id_relacion serial NOT NULL UNIQUE,
	id_cursos int NOT NULL UNIQUE,
	id_tipocurso int NOT NULL UNIQUE,
	PRIMARY KEY (id_relacion)
) WITHOUT OIDS;


CREATE TABLE r_esp_tipogrado
(
	id_relacion serial NOT NULL UNIQUE,
	id_especialidad int NOT NULL UNIQUE,
	id_tipogrado int NOT NULL UNIQUE,
	PRIMARY KEY (id_relacion)
) WITHOUT OIDS;


CREATE TABLE r_materia_escuela
(
	id_relacion serial NOT NULL UNIQUE,
	id_materia int NOT NULL UNIQUE,
	id_escuela int NOT NULL UNIQUE,
	PRIMARY KEY (id_relacion)
) WITHOUT OIDS;


CREATE TABLE r_materia_turno
(
	id_relacion serial NOT NULL UNIQUE,
	id_materia int NOT NULL UNIQUE,
	id_turno int NOT NULL UNIQUE,
	PRIMARY KEY (id_relacion)
) WITHOUT OIDS;


CREATE TABLE r_prof_calif
(
	id_relacion serial NOT NULL UNIQUE,
	id_profesor int NOT NULL UNIQUE,
	id_calificacion int NOT NULL UNIQUE,
	PRIMARY KEY (id_relacion)
) WITHOUT OIDS;


CREATE TABLE r_prof_cursos
(
	id_relacion serial NOT NULL UNIQUE,
	id_profesor int NOT NULL UNIQUE,
	id_cursos int NOT NULL UNIQUE,
	PRIMARY KEY (id_relacion)
) WITHOUT OIDS;


CREATE TABLE r_prof_especialidad
(
	id_relacion serial NOT NULL UNIQUE,
	id_profesor int NOT NULL UNIQUE,
	id_especialidad int NOT NULL UNIQUE,
	PRIMARY KEY (id_relacion)
) WITHOUT OIDS;


CREATE TABLE r_prof_materia
(
	id_relacion serial NOT NULL UNIQUE,
	id_profesor int NOT NULL UNIQUE,
	id_materia int NOT NULL UNIQUE,
	PRIMARY KEY (id_relacion)
) WITHOUT OIDS;



/* Create Foreign Keys */

ALTER TABLE r_calif_tipoeval
	ADD FOREIGN KEY (id_calificacion)
	REFERENCES calificaciones (id_calificacion)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE r_prof_calif
	ADD FOREIGN KEY (id_calificacion)
	REFERENCES calificaciones (id_calificacion)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE cursos
	ADD FOREIGN KEY (id_eje)
	REFERENCES cat_eje (id_eje)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE r_materia_escuela
	ADD FOREIGN KEY (id_escuela)
	REFERENCES cat_escuela (id_escuela)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE r_esp_tipogrado
	ADD FOREIGN KEY (id_especialidad)
	REFERENCES cat_especialidad (id_especialidad)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE r_prof_especialidad
	ADD FOREIGN KEY (id_especialidad)
	REFERENCES cat_especialidad (id_especialidad)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE r_materia_escuela
	ADD FOREIGN KEY (id_materia)
	REFERENCES cat_materias (id_materia)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE r_materia_turno
	ADD FOREIGN KEY (id_materia)
	REFERENCES cat_materias (id_materia)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE r_prof_materia
	ADD FOREIGN KEY (id_materia)
	REFERENCES cat_materias (id_materia)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE cat_usuarios
	ADD FOREIGN KEY (id_perfil)
	REFERENCES cat_perfiles (id_perfil)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE r_curso_tipocurso
	ADD FOREIGN KEY (id_tipocurso)
	REFERENCES cat_tipocurso (id_tipocurso)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE r_calif_tipoeval
	ADD FOREIGN KEY (id_tipoevaluaciones)
	REFERENCES cat_tipoevaluaciones (id_tipoevaluaciones)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE r_esp_tipogrado
	ADD FOREIGN KEY (id_tipogrado)
	REFERENCES cat_tipogrado (id_tipogrado)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE r_materia_turno
	ADD FOREIGN KEY (id_turno)
	REFERENCES cat_turno (id_turno)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE personas
	ADD FOREIGN KEY (id_personas)
	REFERENCES cat_usuarios (id_personas)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE r_curso_tipocurso
	ADD FOREIGN KEY (id_cursos)
	REFERENCES cursos (id_cursos)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE r_prof_cursos
	ADD FOREIGN KEY (id_cursos)
	REFERENCES cursos (id_cursos)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE cursos
	ADD FOREIGN KEY (id_periodo)
	REFERENCES periodos (id_periodo)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE contacto
	ADD FOREIGN KEY (id_personas)
	REFERENCES personas (id_personas)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE profesores
	ADD FOREIGN KEY (id_profesor)
	REFERENCES personas (id_personas)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE experiencia
	ADD FOREIGN KEY (id_profesor)
	REFERENCES profesores (id_profesor)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE ex_oposicion
	ADD FOREIGN KEY (id_profesor)
	REFERENCES profesores (id_profesor)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE r_prof_calif
	ADD FOREIGN KEY (id_profesor)
	REFERENCES profesores (id_profesor)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE r_prof_cursos
	ADD FOREIGN KEY (id_profesor)
	REFERENCES profesores (id_profesor)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE r_prof_especialidad
	ADD FOREIGN KEY (id_profesor)
	REFERENCES profesores (id_profesor)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE r_prof_materia
	ADD FOREIGN KEY (id_profesor)
	REFERENCES profesores (id_profesor)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;



