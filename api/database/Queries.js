// User validation
exports.validateUser = 'SELECT * FROM usuario WHERE username = $1::TEXT AND pass = $2::TEXT'

exports.test = 'SELECT * FROM usuario'

// Professor
exports.listAllProfessor = 'SELECT * FROM persona'

exports.listAllProfessorAVG = 'SELECT c.id_persona, p.nombres, p.a_paterno, p.a_materno, to_char(AVG(c.promedio::decimal),\'9.99\') as promedio ' +
  ' FROM calificacion c ' +
  ' JOIN persona p ON c.id_persona = p.id_persona ' +
  ' WHERE  UPPER(REPLACE(concat(p.a_paterno,p.a_materno,p.nombres),\' \',\'\'))  SIMILAR TO $1::TEXT ' +
  ' GROUP BY c.id_persona, p.nombres, p.a_paterno, p.a_materno '

exports.detailProfessor = 'SELECT p.id_persona, p.nombres, p.a_paterno, p.a_materno, pr.ex_oposicion, c.f_telefono, c.m_telefono, c.t_telefono,\n' +
  '  c.ext, c.mail, c.cedula, c.rfc, c.f_ingreso, c.grado\n' +
  '  FROM persona p \n' +
  '    JOIN profesor pr ON p.id_persona = pr.id_profesor\n' +
  '    LEFT JOIN contacto c ON p.id_persona = c.id_persona\n' +
  'WHERE p.id_persona = $1::INT'

exports.saveDetailProfessor =
  'INSERT INTO contacto VALUES ($1::INT,$2::TEXT, $3::TEXT,$4::TEXT,$5::TEXT,$6::TEXT,\n' +
  '                                                      $7::TEXT,$8::TEXT,$9::TEXT,$10::TEXT)\n' +
  '  ON CONFLICT (id_persona) DO UPDATE SET\n' +
  '    f_telefono = $2 :: TEXT,\n' +
  '    m_telefono = $3 :: TEXT,\n' +
  '    t_telefono = $4 :: TEXT,\n' +
  '    ext        = $5 :: TEXT,\n' +
  '    mail       = $6 :: TEXT,\n' +
  '    cedula     = $7 :: TEXT,\n' +
  '    rfc        = $8:: TEXT,\n' +
  '    f_ingreso  = $9 :: TEXT,\n' +
  '    grado      = $10 :: TEXT;'

exports.updatePersonaDetail = 'UPDATE persona SET nombres = $2::TEXT, a_paterno=$3::TEXT, a_materno=$4::TEXT WHERE id_persona=$1::INT'

exports.personsByCurso = 'SELECT * FROM persona p ' +
  'JOIN curso c ON p.id_persona = c.id_persona ' +
  'WHERE UPPER(REPLACE(TRIM(concat(curso)),\' \',\'\')) = $1::TEXT '

exports.deleteProfExop = 'UPDATE profesor SET ex_oposicion = NULL WHERE id_profesor = $1::INT'

exports.updateProfExop = 'UPDATE profesor SET ex_oposicion = $1::TEXT WHERE id_profesor = $2::INT'

// Period
exports.listAllPeriod = 'WITH temp_periodo as (' +
  '  SELECT id_tempo, periodo, right(periodo, 4) anio FROM periodo' +
  ') SELECT id_tempo, periodo FROM temp_periodo ORDER BY anio DESC, periodo DESC'

exports.periodoById = 'SELECT * FROM periodo WHERE id_tempo = $1::INT'
// Cursos
exports.cursoById = 'SELECT * FROM curso WHERE id_persona = $1::INT ORDER BY curso'

exports.detailCurso = 'SELECT * FROM curso WHERE id = $1::INT'

exports.updateCursoConstancia = 'UPDATE curso SET constancia = $1::TEXT WHERE id = $2::INT'

exports.deleteCursoConstancia = 'UPDATE curso SET constancia = NULL WHERE id = $1::INT'

exports.searchCurso = 'SELECT DISTINCT curso, UPPER(REPLACE(TRIM(concat(curso)),\' \',\'\')) as short FROM curso ' +
  ' WHERE UPPER(REPLACE(TRIM(concat(curso)),\' \',\'\')) SIMILAR TO $1::TEXT '

// Materias
exports.listAllMateria = 'SELECT id, materia FROM materia'

exports.listMateriaByPeriod = 'SELECT DISTINCT mat.id, mat.materia FROM calificacion cal\n' +
  '  JOIN materia mat ON mat.id = cal.id_materia\n' +
  ' WHERE cal.id_periodo = $1::INT ' +
  ' ORDER BY mat.materia '

exports.materiaById = 'SELECT * FROM materia WHERE id = $1::INT'

// Calificaciones
exports.detailProfesorCalif = '' +
  'WITH temp_periodo as (\n' +
  '  SELECT id_tempo, periodo, right(periodo, 4) anio FROM periodo\n' +
  ')\n' +
  ' SELECT c.id, c.id_persona, pt.periodo, gr.grupo, mat.materia, c.puntualidad, c.contenido, c.didactica, c.planeacion, c.evaluacion, c.actitud,c.promedio,c.comprobante ' +
  ' FROM calificacion c ' +
  ' JOIN temp_periodo pt  ON c.id_periodo = pt.id_tempo ' +
  ' JOIN materia mat      ON c.id_materia = mat.id ' +
  ' JOIN grupo gr         ON c.id_grupo = gr.id ' +
  ' WHERE id_persona = $1::INT ORDER BY pt.anio DESC, pt.periodo DESC'

exports.detailCalificacion = 'SELECT * FROM calificacion WHERE id = $1::INT'

exports.updateCalificacionComprobante = 'UPDATE calificacion SET comprobante = $1::TEXT WHERE id = $2::INT'

exports.deleteCalificacionComprobante = 'UPDATE calificacion SET comprobante = NULL WHERE id = $1::INT'

exports.califByMateriaPeriod = 'SELECT concat_ws(\' \', per.a_paterno, per.a_materno, per.nombres) as nombre, cal.puntualidad,\n' +
  '  cal.contenido, cal.didactica, cal.planeacion, cal.evaluacion, cal.actitud, cal.promedio, cal.comprobante,\n' +
  '  gr.grupo\n' +
  'FROM calificacion cal\n' +
  '  JOIN persona per ON per.id_persona = cal.id_persona\n' +
  '  JOIN grupo gr ON gr.id = cal.id_grupo \n' +
  ' WHERE cal.id_materia = $1::INT AND cal.id_periodo = $2::INT' +
  ' ORDER BY per.a_paterno'

// Data Import
exports.dataImportStartTransaction = ''
exports.dataImportCalifsanitizeFields = 'UPDATE importCalif SET \n' +
  'nombre\t\t\t\t= TRIM(nombre),\n' +
  'periodo\t\t\t\t= TRIM(periodo),\n' +
  'grupo\t\t\t\t= TRIM(grupo),\n' +
  'materia\t\t\t\t= TRIM(materia),\n' +
  'puntualidad\t\t\t= TRIM(puntualidad),\n' +
  'contenido\t\t\t= TRIM(contenido),\n' +
  'didactica\t\t\t= TRIM(didactica),\n' +
  'planeacion\t\t\t= TRIM(planeacion),\n' +
  'evaluacion\t\t\t= TRIM(evaluacion),\n' +
  'actitud\t\t\t\t= TRIM(actitud);'

exports.dataImportCalifInsertProfessors = 'INSERT INTO persona (a_paterno,a_materno,nombres)\n' +
  '  SELECT \n' +
  '  split_part(nombre, \' \', 1) AS a_paterno,   split_part(nombre, \' \', 2)  AS a_materno, split_part(nombre, \' \', 3 ) || split_part(nombre, \' \', 4 ) || split_part(nombre, \' \', 5 ) as nombres \n' +
  '    FROM importCalif ic LEFT JOIN persona p\n' +
  '    ON UPPER(REPLACE(ic.nombre,\' \',\'\')) = UPPER(REPLACE(TRIM(concat(p.a_paterno,p.a_materno,p.nombres)),\' \',\'\'))\n' +
  '    WHERE p.id_persona IS NULL'

exports.dataImportCalifInsertGrupos = 'INSERT INTO grupo (grupo) \n' +
  '  SELECT ic.grupo\n' +
  '  FROM importCalif ic LEFT JOIN \n' +
  '  grupo g \n' +
  '  ON UPPER(REPLACE(ic.grupo,\' \',\'\')) = UPPER(REPLACE(g.grupo,\' \',\'\'))\n' +
  '  WHERE g.grupo IS NULL'

exports.dataImportCalifInsertMaterias = 'INSERT INTO materia (materia) \n' +
  '  SELECT ic.materia\n' +
  '  FROM importCalif ic LEFT JOIN \n' +
  '  materia m \n' +
  '  ON UPPER(REPLACE(ic.materia,\' \',\'\')) = UPPER(REPLACE(m.materia,\' \',\'\'))\n' +
  '  WHERE m.materia IS NULL'

exports.dataImportCalifInsertPeriodos = 'INSERT INTO periodo (periodo) \n' +
  '  SELECT DISTINCT ic.periodo\n' +
  '  FROM importCalif ic LEFT JOIN\n' +
  '  periodo p\n' +
  '  ON UPPER(REPLACE(ic.periodo,\' \',\'\')) = UPPER(REPLACE(p.periodo,\' \',\'\'))\n' +
  '  WHERE p.periodo IS NULL'

exports.dataImportCalifInsertCalifs = 'INSERT INTO calificacion  (id_persona, id_periodo, id_grupo, id_materia, puntualidad, contenido, didactica, \n' +
  '  planeacion, evaluacion, actitud, promedio, comprobante)\n' +
  '  WITH califTable AS (\n' +
  '    SELECT per.id_persona, p.id_tempo as id_periodo, g.id as id_grupo, m.id as id_materia, \n' +
  '      ic.puntualidad,ic.contenido,ic.didactica,ic.planeacion,ic.evaluacion,ic.actitud,\n' +
  '    round((\n' +
  '      CAST(puntualidad\t as DECIMAL) +\n' +
  '      CAST(contenido\t as DECIMAL) +\n' +
  '      CAST(didactica\t as DECIMAL) +\n' +
  '      CAST(planeacion\t as DECIMAL) +\n' +
  '      CAST(evaluacion\t as DECIMAL) +\n' +
  '      CAST(actitud as DECIMAL)\n' +
  '    ) / 6, 2) as promedio, null::TEXT as comprobante\n' +
  '    FROM importCalif ic \n' +
  '      JOIN persona per ON UPPER(REPLACE(ic.nombre,\' \',\'\')) = UPPER(REPLACE(concat(per.a_paterno,per.a_materno,per.nombres),\' \',\'\'))\n' +
  '      JOIN periodo p ON UPPER(REPLACE(ic.periodo,\' \',\'\')) = UPPER(REPLACE(p.periodo,\' \',\'\'))\n' +
  '      JOIN grupo g ON UPPER(REPLACE(ic.grupo,\' \',\'\')) = UPPER(REPLACE(g.grupo,\' \',\'\'))\n' +
  '      JOIN materia m ON UPPER(REPLACE(ic.materia,\' \',\'\')) = UPPER(REPLACE(m.materia,\' \',\'\'))\n' +
  '  )\n' +
  '  SELECT ct.* FROM califTable ct\n' +
  '  LEFT JOIN calificacion c\n' +
  '    ON ct.id_persona\t= c.id_persona\n' +
  '    AND ct.id_periodo\t=c.id_periodo\n' +
  '    AND ct.id_grupo\t=c.id_grupo\n' +
  '    AND ct.id_materia\t=c.id_materia \n' +
  '\n' +
  '  WHERE c.id_persona IS NULL \n'

exports.dataImportCalifFinalizeImport = 'DELETE FROM importCalif'

// Curso import
exports.dataImportCursoInsertProfessors = 'INSERT INTO persona (a_paterno,a_materno,nombres)\n' +
  '  SELECT \n' +
  '  split_part(nombre, \' \', 1) AS a_paterno,   split_part(nombre, \' \', 2)  AS a_materno, split_part(nombre, \' \', 3 ) || split_part(nombre, \' \', 4 ) || split_part(nombre, \' \', 5 ) as nombres \n' +
  '    FROM importCurso ic LEFT JOIN persona p\n' +
  '    ON UPPER(REPLACE(ic.nombre,\' \',\'\')) = UPPER(REPLACE(TRIM(concat(p.a_paterno,p.a_materno,p.nombres)),\' \',\'\'))\n' +
  '    WHERE p.id_persona IS NULL'

exports.dataImportCursoSanitizeFields = 'UPDATE importCurso SET \n' +
  'nombre\t\t\t\t= TRIM(nombre),\n' +
  'curso\t\t\t\t= TRIM(curso),\n' +
  'fechai\t\t\t\t= TRIM(fechai),\n' +
  'fechaf\t\t\t\t= TRIM(fechaf),\n' +
  'horas\t\t\t= TRIM(horas);'

exports.dataImportCursoInsertCursos = 'INSERT INTO curso (id_persona, curso,inicio,termino,horas,constancia)\n' +
  'SELECT per.id_persona, ic.curso, ic.fechai, ic.fechaf, ic.horas, null::TEXT  FROM importCurso ic\n' +
  'JOIN persona per ON UPPER(REPLACE(ic.nombre,\' \',\'\')) = UPPER(REPLACE(concat(per.a_paterno,per.a_materno,per.nombres),\' \',\'\'))'

exports.dataImportCursoFinalizeImport = 'DELETE FROM importCurso'
