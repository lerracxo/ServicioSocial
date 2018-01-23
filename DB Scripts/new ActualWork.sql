SELECT count(*) FROM persona;

SELECT * FROM 

SELECT * FROM profesor;

SELECT * from calificacion Limit 100;

SELECT count(*) FROM pers_tempo;

COPY pers_tempo TO '/Users/oscar/Projects/Personal/ServicioSocial/pers_tempo.txt' WITH CSV;

SELECT * FROM GRUPO;
SELECT * FROM periodo;

SELECT * FROM permat_tempo ORDER BY periodo;

SELECT * FROM cat_materia;

SELECT * FROM calif;

SELECT replace(a_paterno||a_materno||nombres,' ','') FROM persona 
WHERE replace(a_paterno||a_materno||nombres,' ','') = 'CRUZGOMEZMARTINHORACIO' ;

SELECT * FROM cat_materia;

SELECT count(*) FROM grupo;

SELECT DISTINCT grupo FROM grupo;

SELECT * FROM cat_materia;
DROP TABLE pers_temp_proc;
CREATE TABLE pers_temp_proc (
	nombre text,
	periodo text,
	materia text,
	grupo text,
	puntualidad text,
	contenido text,
	didactica text,
	planeacion text,
	evaluacion text,
	actitud text,
	promedio text
);

ALTER TABLE r_prof_materia DROP CONSTRAINT r_prof_materia_id_profesor_fkey;

SELECT * FROM r_prof_materia;

SELECT * FROM cat_materia;

SELECT * from materia;

COPY pers_temp_proc FROM '/Users/oscar/Projects/Personal/ServicioSocial/DB Scripts/pers_tempo_proc.csv' WITH DELIMITER '|' ;

--INSERT INTO r_prof_materia (id_profesor,id_materia) 
WITH temp_table as (
SELECT pc.nombre, p.id_persona,pt.id_tempo as id_periodo, gru.id as id_grupo, mat.id as id_materia, pc.puntualidad, pc.contenido, pc.didactica, pc.planeacion, pc.evaluacion, pc.actitud, pc.promedio 
             FROM pers_temp_proc pc
	FULL OUTER JOIN persona p        ON REPLACE(concat(p.a_paterno,p.a_materno,p.nombres),' ','') = 		pc.nombre
	FULL OUTER JOIN permat_tempo pt  ON pc.periodo = pt.periodo 
	FULL OUTER JOIN materia mat      ON pc.materia = mat.materia
	FULL OUTER JOIN grupo  gru       ON pc.grupo = gru.grupo
)
SELECT DISTINCT id_persona,id_materia FROM temp_table 
  WHERE id_persona is not null AND id_materia is not null;

SELECT * FROM calificacion WHERE promedio = '2CM10';

SELECT * FROM grupo WHERE grupo = '2CM10';
--UPDATE calificacion SET id_grupo = 178  WHERE promedio = '2CM10';
--UPDATE calificacion SET promedio = ''  WHERE promedio = '2CM10';

SELECT id_persona, avg(promedio::decimal) FROM calificacion GROUP BY id_persona;

SELECT p.id_persona, p.nombres, p.a_paterno, p.a_materno, '555555' as f_telefono, '242342342' as m_telefono, '122234' as t_telefono, 
'333' as ext, 'alguien@ipn.mx' as mail,
'33d3dsdas2' as cedula, 'ASDAS13DSF22' as rfc, '12-34-01' as f_ingreso, 'si' as ex_oposicion, 'Maestria' as Grado
FROM persona p;

--SELECT sum(puntualidad::decimal), sum(contenido::decimal), sum(didactica::decimal), sum(planeacion::decimal), sum(evaluacion::decimal), sum(actitud::decimal) 
--FROM calificacion WHERE promedio = '' ;


UPDATE calificacion SET promedio =  ((puntualidad::decimal + contenido::decimal + didactica::decimal + planeacion::decimal + evaluacion::decimal + actitud::decimal) / 6) :: TEXT
WHERE promedio = '' ;

SELECT * FROM persona;

SELECT c.id_persona, p.nombres, p.a_paterno, p.a_materno, AVG(c.promedio::decimal)  FROM calificacion c
JOIN persona p ON c.id_persona = p.id_persona
WHERE  UPPER(REPLACE(concat(p.a_paterno,p.a_materno,p.nombres),' ','')) SIMILAR TO '%(OSCAR|d)%'
GROUP BY c.id_persona, p.nombres, p.a_paterno, p.a_materno;

--DROP TABLE calificacion CASCADE ;
SELECT * FROM r_calif_tipoeval;
SELECT * FROM calificacion;
CREATE TABLE materia (
id serial,
materia text
);

SELECT * FROM grupo;

-- DROP TABLE grupo CASCADE ;
CREATE TABLE grupo(
  id serial,
  grupo text
);



SELECT REPLACE(concat(p.a_paterno,p.a_materno,p.nombres),' ',''), * FROM persona p WHERE  REPLACE(concat(p.a_paterno,p.a_materno,p.nombres),' ','') LIKE '%SILVA%';
MENENDEZ ALEJANDRO EMANUELLE
MENENDEZ EMANUELLE

;SELECT COUNT(*) FROM pers_temp_proc;SELECT * FROM permat_tempo;

SELECT * FROM pers_temp_proc WHERE nombre LIKE '%SILVAPADILLAALONSO%'
UNION 
SELECT * FROM pers_temp_proc WHERE nombre LIKE '%PADILLAALO%';
--UPDATE pers_temp_proc SET nombre = 'PEREZSANTANDERARTURO' WHERE nombre = 'PEREZSANTADANDERARTURO';
--UPDATE persona SET nombres = 'JULIO CESAR' WHERE id_persona = 511;
--UPDATE persona SET nombres = 'JOSE ANGEL' WHERE id_persona = 205;
--UPDATE persona SET nombres = 'RAUL' WHERE id_persona = 740;
--UPDATE persona SET nombres = 'JORGE EVERT' WHERE id_persona = 289;
--UPDATE persona SET nombres = 'BENHUMEA MA. DEL SAGRARIO' WHERE id_persona =768;
--UPDATE persona SET nombres = 'FELISA ANGELA' WHERE id_persona = 633;
--UPDATE persona SET nombres = 'MA. GUADALUPE HORTENCIA' WHERE id_persona = 574;
--UPDATE persona SET nombres = 'TEJEDA MIGUEL A.' WHERE id_persona = 239;
--UPDATE persona SET a_paterno = 'MAZA' WHERE id_persona = 512;
--UPDATE persona SET nombres = 'CARLOS' WHERE id_persona = 524;
--UPDATE persona SET a_paterno = 'RIVAS' WHERE id_persona = 706;
--UPDATE persona SET a_paterno = 'RAMIREZ' , a_materno = 'DEL PRADO Y ALEMAN' WHERE id_persona = 670;
--UPDATE persona SET nombres = 'ELIAS' WHERE id_persona = 256;
--UPDATE persona SET nombres = 'ARIADNA ANGÉLICA PATRICIA' WHERE id_persona = 110;
--UPDATE persona SET nombres = 'GABRIELA', a_materno = 'PIMENTEL' WHERE id_persona = 852;
--UPDATE pers_temp_proc SET nombre ='PADILLAALONSOSILVIA' WHERE nombre = 'SILVAPADILLAALONSO';
--UPDATE persona SET a_materno = 'JAIMES' WHERE id_persona = 271;
--UPDATE persona SET nombres = 'ANTONIO XAVIER' WHERE id_persona = 822;
--UPDATE pers_temp_proc SET nombre ='PERALTALOPEZADOLFO' WHERE nombre = 'PERALTALOPEZADELFO';
--UPDATE persona SET a_paterno = 'RIVAS' WHERE id_persona = 707;
--UPDATE pers_temp_proc SET nombre ='GUALITOHERNANDEZJOSE' WHERE nombre = 'GUALITOHERNÁNDEZJOSÉ';
--UPDATE persona SET a_paterno = 'NAVA', nombres = 'MA. CRISTINA' WHERE id_persona = 573;
--UPDATE pers_temp_proc SET nombre ='CAZARESROMEROROSALINDA' WHERE nombre = 'ROSALINDACAZARESROMERO';
--UPDATE pers_temp_proc SET nombre ='BAEZPEREZEDITHNANCY' WHERE nombre = 'EDITHNANCYBAEZPEREZ';
--UPDATE persona SET nombres = 'ALEJANDRO EMANUELLE' WHERE id_persona = 538;
--UPDATE pers_temp_proc SET nombre ='MOLINOSJIMENEZMARIAARACELI' WHERE nombre = 'IMOLINOSJIMENEZMARIAARACELI';
--UPDATE pers_temp_proc SET nombre ='ALVARADOJIMENEZVIOLETA' WHERE nombre = 'VIOLETAALVARADOJIMENEZ';
--UPDATE pers_temp_proc SET nombre = 'RODRIGUEZPEREZDIANAIVONNE' WHERE nombre = 'DIANAIVONNERODRIGUEZPEREZ';
--UPDATE pers_temp_proc SET nombre = 'BENITEZSALGADOCELIA' WHERE nombre = 'CELIABENITEZSALGADO';
--UPDATE pers_temp_proc SET nombre = 'CASASHAROMARIBELDELCARMEN' WHERE nombre = 'MARIBELDELCARMENCASASHARO';
--UPDATE persona SET a_paterno = 'CHAMORRO' WHERE id_persona = 160;
--UPDATE pers_temp_proc SET nombre = 'PEREZBADILLOJEMINAALEJANDRA' WHERE nombre = 'PÉREZBADILLOJEMINAALEJANDRA';


SELECT * FROM persona WHERE id_persona = 811;

SELECT * FROM pers_temp_proc;

SELECT * FROM periodo_curso;
SELECT * FROM permat_tempo;
SELECT * FROM calificacion LIMIT 10;
/*
	FULL OUTER JOIN persona p        ON REPLACE(concat(p.a_paterno,p.a_materno,p.nombres),' ','') = 		pc.nombre
	FULL OUTER JOIN permat_tempo pt  ON pc.periodo = pt.periodo 
	FULL OUTER JOIN materia mat      ON pc.materia = mat.materia
	FULL OUTER JOIN grupo  gru       ON pc.grupo = gru.grupo
*/

SELECT c.id_persona, pt.periodo, gr.grupo, mat.materia, c.puntualidad, c.contenido, c.didactica, c.planeacion, c.evaluacion, c.actitud,c.promedio
  FROM calificacion c
  JOIN permat_tempo pt  ON c.id_periodo = pt.id_tempo
  JOIN materia mat      ON c.id_materia = mat.id
  JOIN grupo gr         ON c.id_grupo = gr.id 
WHERE id_persona = 110;

SELECT * FROM re;

SELECT * FROM cat_perfil;

SELECT * FROM cursos_draft WHERE f6 IS NOT NULL;
--DELETE FROM cursos_draft WHERE nombre = '1';


CREATE TABLE cursos_draft(
  f1 text,
  nombre text,
  curso text,
 termino text,
 horas text ,
  f6 text,
  f7 text,
  f8 text,
  f9 text,
  f10 text,
  f11 text,
  f12 text,
  f13 text,
  f14 text,
  f15 text,
  f16 text,
  f17 text,
  f18 text,
  f19 text,
  f20 text,
  f21 text
);

SELECT * FROM curso WHERE id_persona = 74;
DROP TABLE curso CASCADE;

CREATE TABLE curso(
  id serial,
  id_persona integer,
  curso text,
  inicio text,
  termino text,
  horas  text,
  PRIMARY KEY (id)
);

COMMIT;
--COPY cursos_draft FROM '/Users/oscar/Desktop/CURSOS2007a-2016/CURSOS-Table.csv' WITH CSV;

-- Total 4894 - 4795 = 99
INSERT INTO curso (id_persona,curso,inicio,termino,horas)
SELECT p.id_persona::INT, cd.curso, cd.termino as inicio, cd.horas as termino, cd.f6 as horas FROM cursos_draft cd 
  INNER JOIN persona p 
  ON UPPER(REPLACE(concat(p.a_paterno,p.a_materno,p.nombres),' ','')) = UPPER(REPLACE(nombre,' ',''));



SELECT * FROM materia;
SELECT * FROM calificacion;

SELECT * FROM r_prof_materia WHERE id_profesor = 58;



WITH temp_table AS  (
  SELECT  c.id_persona, p.nombres, p.a_paterno, p.a_materno, AVG(c.promedio::decimal) as promedio 
       FROM calificacion c
       JOIN persona p ON c.id_persona = p.id_persona
       --Si pides filtrar por materia
       --JOIN r_prof_materia rpm ON rpm.id_materia = 400 AND rpm.id_profesor = p.id_persona  
       --WHERE  UPPER(REPLACE(concat(p.a_paterno,p.a_materno,p.nombres),' ',''))  SIMILAR TO '%(OSCAR)%'::TEXT 
       GROUP BY c.id_persona, p.nombres, p.a_paterno, p.a_materno )
SELECT * FROM temp_table WHERE promedio::decimal > 0 ;



SELECT * FROM materia;



WITH temp_table AS  (   SELECT  c.id_persona, p.nombres, p.a_paterno, p.a_materno, AVG(c.promedio::decimal) as promedio        FROM calificacion c        JOIN persona p ON c.id_persona = p.id_persona  WHERE UPPER(REPLACE(concat(p.a_paterno,p.a_materno,p.nombres),' ',''))   SIMILAR TO '%(OSCAR)%'::TEXT        GROUP BY c.id_persona, p.nombres, p.a_paterno, p.a_materno ) SELECT * FROM temp_table ;

SELECT id, materia FROM materia;

SELECT * FROM periodo;
SELECT * FROM persona;

SELECT * FROM profesor;

SELECT * FROM persona pe JOIN profesor pr ON  pe.id_persona = pr.id_profesor;

-- ALTER TABLE profesor ADD COLUMN ex_oposicion TEXT DEFAULT NULL;

SELECT * FROM profesor WHERE id_profesor = 74::INT;

UPDATE profesor SET ex_oposicion = ''::TEXT WHERE id_profesor = $2::INT;

SELECT * FROM curso WHERE id_persona = 5 ;
ALTER TABLE curso ADD COLUMN constancia TEXT DEFAULT NULL;

--ALTER TABLE calificacion ADD COLUMN comprobante TEXT DEFAULT NULL;

UPDATE calificacion SET comprobante = NULL WHERE id_persona = 852 AND id_periodo = 62 AND id_grupo = 38 AND id_materia = 338;

SELECT * FROM calificacion WHERE id_persona = 852 AND id_periodo = 62 AND id_grupo = 38 AND id_materia = 338;


--ALTER TABLE calificacion ADD COLUMN id SERIAL PRIMARY KEY;
SELECT * FROM calificacion WHERE id = 16040;

-- This table is to import all the data into, and then distribute it along the tables.
CREATE TABLE importCalif (
nombre  TEXT,
periodo TEXT,
grupo   TEXT,
materia TEXT,
puntualidad TEXT,
contenido   TEXT,
didactica TEXT,
planeacion TEXT,
evaluacion TEXT,
actitud TEXT
);

DROP TABLE importCalif;

SELECT * FROM importCalif;

SELECT * FROM calificacion LIMIT 100;

SELECT * FROM curso;


SELECT c.id, c.id_persona, pt.periodo, gr.grupo, mat.materia, c.puntualidad, 
c.contenido, c.didactica, c.planeacion, c.evaluacion, c.actitud,c.promedio,c.comprobante  
FROM calificacion c  JOIN permat_tempo pt  ON c.id_periodo = pt.id_tempo  
JOIN materia mat      ON c.id_materia = mat.id  JOIN grupo gr         
ON c.id_grupo = gr.id  WHERE c.id_persona = '238'::INT;




SELECT UPPER(REPLACE(TRIM(concat(curso)),' ','')) FROM curso  ;
curso = 'NO HAY REGISTRO';

-- DELETE FROM curso where inicio = 'NO HAY REGISTRO';

;
SELECT DISTINCT curso, UPPER(REPLACE(TRIM(concat(curso)),' ','')) FROM curso WHERE UPPER(REPLACE(TRIM(concat(curso)),' ',''))  SIMILAR TO '%(ADMINISTRACION)%'::TEXT;

SELECT * FROM persona p 
JOIN curso c ON p.id_persona = c.id_persona
WHERE UPPER(REPLACE(TRIM(concat(curso)),' ','')) = 'INGLESPARALAADMINISTRACIONYLAGESTION'

;

SELECT 
  nspname AS schemaname,relname,reltuples
FROM pg_class C
LEFT JOIN pg_namespace N ON (N.oid = C.relnamespace)
WHERE 
  nspname NOT IN ('pg_catalog', 'information_schema') AND
  relkind='r' 
ORDER BY reltuples DESC;

SELECT * FROM cat_materia;

SELECT * FROM materia;

SELECT * FROM calificacion;

SELECT Max(id) FROM calificacion;

CREATE TABLE usuario (
id_usuario serial,
username text,
pass text,
date date
);

DROP TABLE usuario;

SELECT now(),'1' ;

--INSERT INTO usuario (username, pass, date) VALUES ('admin','xrt23p3x',now());

-- The pass should be digested

SELECT * FROM usuario;

SELECT * FROM calificacion;

SELECT * FROM curso WHERE constancia IS NOT NULL;


SELECT c.id, c.id_persona, pt.periodo, gr.grupo, mat.materia, c.puntualidad, c.contenido, 
c.didactica, c.planeacion, c.evaluacion, c.actitud,c.promedio,c.comprobante 
 FROM calificacion c  JOIN permat_tempo pt  ON c.id_periodo = pt.id_tempo  
 JOIN materia mat      ON c.id_materia = mat.id  
JOIN grupo gr         ON c.id_grupo = gr.id  WHERE id_persona = 74;


SELECT * from importCalif;

--DELETE FROM importCalif;
SELECT * FROM persona limit 10;
-- sanitizeFields
UPDATE importCalif SET 
nombre				= TRIM(nombre),
periodo				= TRIM(periodo),
grupo				= TRIM(grupo),
materia				= TRIM(materia),
puntualidad			= TRIM(puntualidad),
contenido			= TRIM(contenido),
didactica			= TRIM(didactica),
planeacion			= TRIM(planeacion),
evaluacion			= TRIM(evaluacion),
actitud				= TRIM(actitud);

-- insertProfessors
INSERT INTO persona (a_paterno,a_materno,nombres)
  SELECT 
  split_part(nombre, ' ', 1) AS a_paterno,   split_part(nombre, ' ', 2)  AS a_materno, split_part(nombre, ' ', 3 ) || split_part(nombre, ' ', 4 ) || split_part(nombre, ' ', 5 ) as nombres
    FROM importCalif ic --LEFT JOIN persona p
    ON UPPER(REPLACE(ic.nombre,' ','')) = UPPER(REPLACE(TRIM(concat(p.a_paterno,p.a_materno,p.nombres)),' ',''))
    WHERE p.id_persona IS NULL
;

-- insertGrupos
INSERT INTO grupo (grupo) 
  SELECT ic.grupo
  FROM importCalif ic LEFT JOIN 
  grupo g 
  ON UPPER(REPLACE(ic.grupo,' ','')) = UPPER(REPLACE(g.grupo,' ',''))
  WHERE g.grupo IS NULL;

 
-- insertMaterias
INSERT INTO materia (materia) 
  SELECT ic.materia
  FROM importCalif ic LEFT JOIN 
  materia m 
  ON UPPER(REPLACE(ic.materia,' ','')) = UPPER(REPLACE(m.materia,' ',''))
  WHERE m.materia IS NULL;
  
-- insertPeriodos
INSERT INTO periodo (periodo)
  SELECT ic.periodo
  FROM importCalif ic LEFT JOIN
  periodo p
  ON UPPER(REPLACE(ic.periodo,' ','')) = UPPER(REPLACE(p.periodo,' ',''))
  WHERE p.periodo IS NULL;

--insertCalifs

--INSERT INTO calificacion (id_persona, id_periodo, id_grupo, id_materia, puntualidad, contenido, didactica, 
  --planeacion, evaluacion, actitud, promedio, comprobante)
  WITH califTable AS (
    SELECT per.id_persona, p.id_tempo as id_periodo, g.id as id_grupo, m.id as id_materia, 
      ic.puntualidad,ic.contenido,ic.didactica,ic.planeacion,ic.evaluacion,ic.actitud,
    ROUND((
      CAST(puntualidad	 as DECIMAL) +
      CAST(contenido	 as DECIMAL) +
      CAST(didactica	 as DECIMAL) +
      CAST(planeacion	 as DECIMAL) +
      CAST(evaluacion	 as DECIMAL) +
      CAST(actitud as DECIMAL)
    ) / 6,2) as promedio, null::TEXT as comprobante
    FROM importCalif ic 
      JOIN persona per ON UPPER(REPLACE(ic.nombre,' ','')) = UPPER(REPLACE(concat(per.a_paterno,per.a_materno,per.nombres),' ',''))
      JOIN periodo p ON UPPER(REPLACE(ic.periodo,' ','')) = UPPER(REPLACE(p.periodo,' ',''))
      JOIN grupo g ON UPPER(REPLACE(ic.grupo,' ','')) = UPPER(REPLACE(g.grupo,' ',''))
      JOIN materia m ON UPPER(REPLACE(ic.materia,' ','')) = UPPER(REPLACE(m.materia,' ',''))
  )
  SELECT ct.* FROM califTable ct
  LEFT JOIN calificacion c
    ON ct.id_persona	= c.id_persona
    AND ct.id_periodo	=c.id_periodo
    AND ct.id_grupo	=c.id_grupo
    AND ct.id_materia	=c.id_materia 

  WHERE c.id_persona IS NULL 
  ;

--
SELECT * FROM importCalif;
DELETE FROM importCalif;
-- Imported data uppon tests
SELECT * FROM persona WHERE nombres = '1';
SELECT * FROM periodo WHERE periodo = 'AGOSTO - DICIEMBRE 2020';
SELECT * FROM materia WHERE materia = 'Materia TEST';
SELECT * FROM grupo WHERE grupo = '2TEST2';
SELECT * FROM calificacion WHERE id_materia = 757 ;

SELECT * FROM persona ORDER BY id_persona dESC;

SELECT * FROM curso;

-- DELETE FROM persona WHERE nombres = '1';
-- DELETE FROM periodo WHERE periodo = 'AGOSTO - DICIEMBRE 2020';
-- DELETE FROM materia WHERE materia = 'Materia TEST';
-- DELETE FROM calificacion WHERE ROUND(promedio::NUMERIC,2) = '0.00';;

SELECT * FROM calificacion WHERE id_persona = 929;


SELECT ROUND(AVG(0.00290000932320302032),2); 
SELECT * FROM periodo;
-- UPDATE periodo SET id_tempo = 80 WHERE periodo = 'AGOSTO - DICIEMBRE 2020';

ALTER TABLE periodo ALTER COLUMN id_tempo TYPE serial;

CREATE TABLE periodo_serial (
id_tempo serial,
periodo text);
s
--DROP TABLE period0_serial;
DROP TABLE periodo;

SELECT * FROM periodo_serial;

ALTER TABLE periodo_serial RENAME TO periodo;


SELECT * FROM usuario;

SELECT 
  split_part(nombre, ' ', 1) AS a_paterno,   split_part(nombre, ' ', 2)  AS a_materno, split_part(nombre, ' ', 3 ) || split_part(nombre, ' ', 4 ) || split_part(nombre, ' ', 5 ) as nombres
    FROM importCalif ic;


CREATE TABLE importCurso (
nombre TEXT,
curso TEXT,
fechaI TEXT,
fechaF TEXT,
horas TEXT
);

SELECT * FROM curso;
SELECT * FROM importCurso;
SELECT * FROM persona;

-- dataImportCursoSanitizeFields
UPDATE importCurso SET 
nombre				= TRIM(nombre),
curso				= TRIM(curso),
fechai				= TRIM(fechai),
fechaf				= TRIM(fechaf),
horas			= TRIM(horas);


-- dataImportCursoInsertCursos
INSERT INTO curso (id_persona, curso,inicio,termino,horas,constancia)
SELECT per.id_persona, ic.curso, ic.fechai, ic.fechaf, ic.horas, null::TEXT  FROM importCurso ic
 JOIN persona per ON UPPER(REPLACE(ic.nombre,' ','')) = UPPER(REPLACE(concat(per.a_paterno,per.a_materno,per.nombres),' ',''))
 

-- dataImportCursoFinalizeImport
DELETE FROM importCurso;

SELECT * FROM persona order by id_persona desc;
SELECT * FROM curso ORDER BY id desc;

SELECT * FROM usuario;

CREATE DATABASE testing WITH TEMPLATE oscar OWNER oscar;

SELECT * FROM contacto;

CREATE TABLE contacto(
id_persona  integer,
tel_fijo	 text,
tel_movil	text,
tel_trabajo text,
ext	       text,
correo_elec text,
cedula  text,
rfc text,
fecha_ingreso text,
grado text
);


CREATE DATABASE predictive_listening;

USE oscar;

DROP DATABASE predictive_listening;
