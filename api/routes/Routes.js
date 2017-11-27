'use strict'

module.exports = function (app) {
  const contPersonas = require('../controllers/Personas')
  const contPeriodo = require('../controllers/Periodos')
  const contCurso = require('../controllers/Cursos')
  const contMateria = require('../controllers/Materias')
  const contCalificaciones = require('../controllers/Calificaciones')
  const contAuth = require('../controllers/Authentication')
  const countDataUploadCalif = require('../controllers/DataUploadCalif')
  const countDataUploadCurso = require('../controllers/DataUploadCurso')

  //Middleware
  app.use(function (req, res, next) {
    contAuth.validateToken(req, res)
      .then(next)
      .catch((error) => contAuth.failedTokenValidation(res, error))
  })

  //Authentication
  app.route('/authenticate')
    .post(contAuth.authToken)

  app.route('/authenticate/verify')
    .get(contAuth.isTokenValid)

  // Professor
  app.route('/professor')
    .post(contPersonas.listJson)

  app.route('/professor/exop/:id')
    .post(contPersonas.uploadExop)

  app.route('/professor/curso/')
    .post(contPersonas.personsByCurso)

  app.route('/professor/:filtr')
    .get(contPersonas.listAllAvg)

  app.route('/professor/detail/:id')
    .get(contPersonas.detail)

  app.route('/professor/exop/:id')
    .delete(contPersonas.deleteExop)

  //Curso
  app.route('/curso/:id')
    .get(contCurso.getById)

  app.route('/curso/constancia/:id')
    .post(contCurso.uploadConstancia)

  app.route('/curso/constancia/:id')
    .delete(contCurso.deleteConstancia)

  app.route('/curso/')
    .post(contCurso.search)

  // Calificacion
  app.route('/calificaciones/profesor/:id')
    .get(contCalificaciones.detailCalif)

  app.route('/calificaciones/comprobante/:id')
    .post(contCalificaciones.uploadComprobante)

  app.route('/calificaciones/comprobante/:id')
    .delete(contCalificaciones.deleteCompobante)

  // Materia
  app.route('/materia/')
    .get(contMateria.listAll)

  // Periodo
  app.route('/periodo/')
    .get(contPeriodo.listAll)

  // dataUpload
  app.route('/dataUpload/calif')
    .post(countDataUploadCalif.calif)

  app.route('/dataUpload/curso')
    .post(countDataUploadCurso.curso)

}