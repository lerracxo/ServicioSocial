const personas = require('./Personas')
const auth = require('./Authentication')
const cursos = require('./Cursos')
const calif = require('./Calificaciones')
const materias = require('./Materias')
const periodos = require('./Periodos')
const upCalif = require('./DataUploadCalif')
const upCurso = require('./DataUploadCurso')
const utils = require('./Utils')


module.exports = {
    GET: [...personas.GET, ...auth.GET, ...cursos.GET, ...calif.GET, ...materias.GET, ...periodos.GET, ...upCalif.GET, ...upCurso.GET, ...utils.GET],
    POST: [...personas.POST, ...auth.POST, ...cursos.POST, ...calif.POST, ...materias.POST, ...periodos.POST, ...upCalif.POST, ...upCurso.POST, ...utils.POST],
    DELETE: [...personas.DELETE, ...auth.DELETE, ...cursos.DELETE, ...calif.DELETE, ...materias.DELETE, ...periodos.DELETE, ...upCalif.DELETE, ...upCurso.DELETE, ...utils.DELETE]
}
