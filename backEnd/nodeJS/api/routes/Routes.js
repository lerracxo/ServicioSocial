'use strict'

module.exports = function (app) {
  const contPersonas = require('../controllers/Personas')
  const contPeriodo = require('../controllers/Periodos')
  const contCurso = require('../controllers/Cursos')
  const contMateria = require('../controllers/Materias')

  // Professor
  app.route('/professor')
    .post(contPersonas.listJson)
  // deprecated
  app.route('/professor')
    .get(contPersonas.listAll)
  // deprecated
  app.route('/professor/:filtr')
    .get(contPersonas.listAllAvg)

  app.route('/professor/detail/:id')
    .get(contPersonas.detail)

  app.route('/professor/detail/calif/:id')
    .get(contPersonas.detailCalif)

  app.route('/professor/exop/:id')
    .post(contPersonas.uploadExop)

  //Curso
  app.route('/curso/:id')
    .get(contCurso.getById)

  // Materia
  app.route('/materia/')
    .get(contMateria.listAll)

  // Periodo
  app.route('/periodo/')
    .get(contPeriodo.listAll)


}