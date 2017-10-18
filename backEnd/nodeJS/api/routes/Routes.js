'use strict'

module.exports = function (app) {
  const contPersonas = require('../controllers/Personas')
  const contPeriodo = require('../controllers/Periodos')
  const contCurso = require('../controllers/Cursos')
  const contMateria = require('../controllers/Materias')
  const contCalificaciones = require('../controllers/Calificaciones')

  // Professor
  app.route('/professor')
    .post(contPersonas.listJson)
  // deprecated
  // app.route('/professor')
  //   .get(contPersonas.listAll)
  // deprecated
  app.route('/professor/:filtr')
    .get(contPersonas.listAllAvg)

  app.route('/professor/detail/:id')
    .get(contPersonas.detail)

  app.route('/professor/exop/:id')
    .post(contPersonas.uploadExop)

  app.route('/professor/exop/:id')
    .delete(contPersonas.deleteExop)


  //Curso
  app.route('/curso/:id')
    .get(contCurso.getById)

  app.route('/curso/constancia/:id')
    .post(contCurso.uploadConstancia)

  app.route('/curso/constancia/:id')
    .delete(contCurso.deleteConstancia)

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


}