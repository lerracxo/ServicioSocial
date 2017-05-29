SELECT count(*) FROM persona;


SELECT * FROM profesor;

SELECT * from   calificacion;

SELECT count(*) FROM pers_tempo;

COPY pers_tempo TO '/Users/oscar/Projects/Personal/ServicioSocial/pers_tempo.txt' WITH CSV;

SELECT * FROM GRUPO;

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

COPY pers_temp_proc FROM '/Users/oscar/Projects/Personal/ServicioSocial/DB Scripts/pers_tempo_proc.csv' WITH DELIMITER '|' ;

--WITH temp_table as (
CREATE TABLE calificacion AS(
SELECT p.id_persona,pt.id_tempo as id_periodo, gru.id as id_grupo, mat.id as id_materia, pc.puntualidad, pc.contenido, pc.didactica, pc.planeacion, pc.evaluacion, pc.actitud, pc.promedio 
             FROM pers_temp_proc pc
	FULL OUTER JOIN persona p        ON REPLACE(concat(p.a_paterno,p.a_materno,p.nombres),' ','') = 		pc.nombre
	FULL OUTER JOIN permat_tempo pt  ON pc.periodo = pt.periodo 
	FULL OUTER JOIN materia mat      ON pc.materia = mat.materia
	FULL OUTER JOIN grupo  gru       ON pc.grupo = gru.grupo
)
; SELECT * FROM temp_table;

SELECT * FROM calificacion WHERE promedio = '2CM10';

SELECT * FROM grupo WHERE grupo = '2CM10';
--UPDATE calificacion SET id_grupo = 178  WHERE promedio = '2CM10';
--UPDATE calificacion SET promedio = ''  WHERE promedio = '2CM10';

SELECT id_persona, avg(promedio::decimal) FROM calificacion GROUP BY id_persona;

--SELECT sum(puntualidad::decimal), sum(contenido::decimal), sum(didactica::decimal), sum(planeacion::decimal), sum(evaluacion::decimal), sum(actitud::decimal) 
--FROM calificacion WHERE promedio = '' ;


UPDATE calificacion SET promedio =  ((puntualidad::decimal + contenido::decimal + didactica::decimal + planeacion::decimal + evaluacion::decimal + actitud::decimal) / 6) :: TEXT
WHERE promedio = '' ;

SELECT * FROM persona;

SELECT c.id_persona, p.nombres, p.a_paterno, p.a_materno, AVG(c.promedio::decimal)  FROM calificacion c
JOIN persona p ON c.id_persona = p.id_persona
WHERE  REPLACE(concat(p.a_paterno,p.a_materno,p.nombres),' ','') SIMILAR TO '%(ESTELA|d)%'
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





