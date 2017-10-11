// Professor
exports.listAllProfessor = 'SELECT * FROM persona'

exports.listAllProfessorAVG = 'SELECT c.id_persona, p.nombres, p.a_paterno, p.a_materno, to_char(AVG(c.promedio::decimal),\'9.99\') as promedio ' +
  ' FROM calificacion c ' +
  ' JOIN persona p ON c.id_persona = p.id_persona ' +
  ' WHERE  UPPER(REPLACE(concat(p.a_paterno,p.a_materno,p.nombres),\' \',\'\'))  SIMILAR TO $1::TEXT ' +
  ' GROUP BY c.id_persona, p.nombres, p.a_paterno, p.a_materno '

exports.detailProfessor = 'SELECT p.id_persona, p.nombres, p.a_paterno, p.a_materno, \'555555\' as f_telefono, \'242342342\' as m_telefono, \'122234\' as t_telefono, ' +
  ' \'333\' as ext, \'alguien@ipn.mx\' as mail, ' +
  ' \'33d3dsdas2\' as cedula, \'ASDAS13DSF22\' as rfc, \'12-34-01\' as f_ingreso, \'si\' as ex_oposicion, \'Maestria\' as Grado ' +
  ' FROM persona p ' +
  ' WHERE p.id_persona = $1::INT'

exports.detailProfesorCalif =
  ' SELECT c.id_persona, pt.periodo, gr.grupo, mat.materia, c.puntualidad, c.contenido, c.didactica, c.planeacion, c.evaluacion, c.actitud,c.promedio ' +
  ' FROM calificacion c ' +
  ' JOIN permat_tempo pt  ON c.id_periodo = pt.id_tempo ' +
  ' JOIN materia mat      ON c.id_materia = mat.id ' +
  ' JOIN grupo gr         ON c.id_grupo = gr.id ' +
  ' WHERE id_persona = $1::INT'

// Period
exports.listAllPeriod = 'SELECT * FROM periodo'

// Cursos
exports.cursoById = 'SELECT * FROM curso WHERE id_persona = $1::INT'


exports.listAllMateria= 'SELECT id, materia FROM materia'