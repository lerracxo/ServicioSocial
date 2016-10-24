CREATE TABLE cat_perfiles(
id_perfil serial,
perfil varchar(25),
descripcion varchar(100),
primary key (id_perfil)
);

CREATE TABLE cat_usuarios(
id_personas int,
usuario varchar(30),
contra_cifrada varchar(10),
id_perfil int,
primary key (id_personas)
);

CREATE TABLE contacto(
id_personas int,
tel_fijo int,
tel_movil int,
tel_trabajo int,
ext int,
correo_elec varchar(50),
primary key (id_personas)
);

CREATE TABLE personas(
id_personas serial,
nombre varchar(50),
a_paterno varchar(20),
a_materno varchar(20),
nacionalidad varchar(15),
primary key (id_personas)
);

CREATE TABLE experiencia(
id_profesor int,
experiencia varchar(300),
trabajos_inv varchar(300),
primary key (id_profesor)
);

CREATE TABLE profesores(
id_profesor serial,
id_personas int,
cedula varchar(50),
RFC varchar(15),
fec_ingreso varchar(10),
examen_op boolean,
id_curso int,
id_calificacion int,
primary key (id_profesor)
);

CREATE TABLE rel_prof_materia(
id_relacion serial,
id_profesor int,
id_materia int,
primary key (id_relacion)
);

CREATE TABLE cat_materias(
id_materia serial,
materia varchar(20),
id_escuela int,
id_turno int,
primary key (id_materia)
);

CREATE TABLE cat_turno(
id_turno serial,
turno varchar(15),
primary key (id_turno)
);

CREATE TABLE cat_escuela(
id_escuela serial,
escuela varchar(100),
institucion varchar(100),
primary key (id_escuela)
);

CREATE TABLE cat_especialidad(
id_especialidad serial,
nombre varchar(70),
id_tipogrado int,
id_profesor int,
primary key (id_especialidad)
);

CREATE TABLE rel_espe_tipogrado(
id_relacion serial,
id_especialidad int,
id_tipogrado int,
primary key (id_relacion)
);

CREATE TABLE cat_tipogrado(
id_tipogrado serial,
tipo_grado varchar(20),
descripcion varchar(300),
prioridad int,
primary key (id_tipogrado)
);

CREATE TABLE cursos(
id_curso serial,
nombre varchar(70),
descripcion varchar(300),
fec_inicio varchar(10),
fec_fin varchar(10),
id_eje int,
primary key (id_curso)
);

CREATE TABLE cat_eje(
id_eje serial,
nombre varchar(50),
descripcion varchar (300),
primary key (id_eje)
);

CREATE TABLE calificaciones(
id_calificacion serial,
calificacion int,
id_tipoevaluacion int,
primary key (id_calificacion)
);

CREATE TABLE rel_curso_tipocurso(
id_curso int,
id_tipocurso int,
primary key (id_curso)
);

CREATE TABLE cat_tipocurso(
id_tipocurso serial,
tipocurso varchar(20),
descripcion varchar (300),
primary key (id_tipocurso)
);

CREATE TABLE cat_tipoevaluaciones(
id_tipoevaluacion serial,
evaluacion varchar(25),
descripcion varchar(300),
primary key (id_tipoevaluacion)
);
