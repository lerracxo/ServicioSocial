
/* Drop Tables */

DROP TABLE IF EXISTS r_calif_tipoeval;
DROP TABLE IF EXISTS r_prof_calif;
DROP TABLE IF EXISTS calificacion;
DROP TABLE IF EXISTS r_prof_cursos;
DROP TABLE IF EXISTS cursos;
DROP TABLE IF EXISTS cat_eje;
DROP TABLE IF EXISTS r_esp_tipogrado;
DROP TABLE IF EXISTS r_prof_especialidad;
DROP TABLE IF EXISTS cat_especialidad;
DROP TABLE IF EXISTS r_prof_materia;
DROP TABLE IF EXISTS cat_materia;
DROP TABLE IF EXISTS cat_usuario;
DROP TABLE IF EXISTS cat_perfil;
DROP TABLE IF EXISTS periodo_curso;
DROP TABLE IF EXISTS cat_tipocurso;
DROP TABLE IF EXISTS cat_tipoevaluacion;
DROP TABLE IF EXISTS cat_tipogrado;
DROP TABLE IF EXISTS contacto;
DROP TABLE IF EXISTS experiencia;
DROP TABLE IF EXISTS ex_oposicion;
DROP TABLE IF EXISTS grupo;
DROP TABLE IF EXISTS periodo_materia;
DROP TABLE IF EXISTS profesor;
DROP TABLE IF EXISTS persona;




/* Create Tables */

CREATE TABLE calificacion
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


CREATE TABLE cat_especialidad
(
	id_especialidad serial NOT NULL UNIQUE,
	nombre text,
	PRIMARY KEY (id_especialidad)
) WITHOUT OIDS;


CREATE TABLE cat_materia
(
	id_materia serial NOT NULL UNIQUE,
	materia text,
	escuela text,
	id_periodo int NOT NULL UNIQUE,
	id_grupo int NOT NULL UNIQUE,
	PRIMARY KEY (id_materia)
) WITHOUT OIDS;


CREATE TABLE cat_perfil
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


CREATE TABLE cat_tipoevaluacion
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


CREATE TABLE cat_usuario
(
	id_persona int NOT NULL UNIQUE,
	usuario text,
	contra_cifrada text,
	id_perfil int NOT NULL UNIQUE,
	PRIMARY KEY (id_persona)
) WITHOUT OIDS;


CREATE TABLE contacto
(
	id_persona int NOT NULL UNIQUE,
	tel_fijo numeric,
	tel_movil numeric,
	tel_trabajo numeric,
	ext numeric,
	correo_elec text,
	PRIMARY KEY (id_persona)
) WITHOUT OIDS;


CREATE TABLE cursos
(
	id_cursos serial NOT NULL UNIQUE,
	nombre text,
	descripcion text,
	id_eje int NOT NULL UNIQUE,
	id_tipocurso int NOT NULL UNIQUE,
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
	exam_oposicion boolean,
	fec_realizado date,
	PRIMARY KEY (id_profesor)
) WITHOUT OIDS;


CREATE TABLE grupo
(
	id_grupo serial NOT NULL UNIQUE,
	grupo text,
	PRIMARY KEY (id_grupo)
) WITHOUT OIDS;


CREATE TABLE periodo_curso
(
	id_periodo serial NOT NULL UNIQUE,
	fec_inicio date,
	fec_fin date,
	horas numeric,
	id_tipocurso int NOT NULL,
	PRIMARY KEY (id_periodo)
) WITHOUT OIDS;


CREATE TABLE periodo_materia
(
	id_periodo serial NOT NULL UNIQUE,
	fec_inicio date,
	fec_fin date,
	PRIMARY KEY (id_periodo)
) WITHOUT OIDS;


CREATE TABLE persona
(
	id_persona serial NOT NULL UNIQUE,
	nombres text,
	a_paterno text,
	a_materno text,
	nacionalidad text,
	PRIMARY KEY (id_persona)
) WITHOUT OIDS;


CREATE TABLE profesor
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


CREATE TABLE r_esp_tipogrado
(
	id_relacion serial NOT NULL UNIQUE,
	id_especialidad int NOT NULL UNIQUE,
	id_tipogrado int NOT NULL UNIQUE,
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
	REFERENCES calificacion (id_calificacion)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE r_prof_calif
	ADD FOREIGN KEY (id_calificacion)
	REFERENCES calificacion (id_calificacion)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE cursos
	ADD FOREIGN KEY (id_eje)
	REFERENCES cat_eje (id_eje)
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


ALTER TABLE r_prof_materia
	ADD FOREIGN KEY (id_materia)
	REFERENCES cat_materia (id_materia)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE cat_usuario
	ADD FOREIGN KEY (id_perfil)
	REFERENCES cat_perfil (id_perfil)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE cursos
	ADD FOREIGN KEY (id_tipocurso)
	REFERENCES cat_tipocurso (id_tipocurso)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE periodo_curso
	ADD FOREIGN KEY (id_tipocurso)
	REFERENCES cat_tipocurso (id_tipocurso)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE r_calif_tipoeval
	ADD FOREIGN KEY (id_tipoevaluaciones)
	REFERENCES cat_tipoevaluacion (id_tipoevaluaciones)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE r_esp_tipogrado
	ADD FOREIGN KEY (id_tipogrado)
	REFERENCES cat_tipogrado (id_tipogrado)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE r_prof_cursos
	ADD FOREIGN KEY (id_cursos)
	REFERENCES cursos (id_cursos)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE cat_materia
	ADD FOREIGN KEY (id_grupo)
	REFERENCES grupo (id_grupo)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE cat_materia
	ADD FOREIGN KEY (id_periodo)
	REFERENCES periodo_materia (id_periodo)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE cat_usuario
	ADD FOREIGN KEY (id_persona)
	REFERENCES persona (id_persona)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE contacto
	ADD FOREIGN KEY (id_persona)
	REFERENCES persona (id_persona)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE profesor
	ADD FOREIGN KEY (id_profesor)
	REFERENCES persona (id_persona)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE experiencia
	ADD FOREIGN KEY (id_profesor)
	REFERENCES profesor (id_profesor)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE ex_oposicion
	ADD FOREIGN KEY (id_profesor)
	REFERENCES profesor (id_profesor)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE r_prof_calif
	ADD FOREIGN KEY (id_profesor)
	REFERENCES profesor (id_profesor)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE r_prof_cursos
	ADD FOREIGN KEY (id_profesor)
	REFERENCES profesor (id_profesor)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE r_prof_especialidad
	ADD FOREIGN KEY (id_profesor)
	REFERENCES profesor (id_profesor)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE r_prof_materia
	ADD FOREIGN KEY (id_profesor)
	REFERENCES profesor (id_profesor)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;



