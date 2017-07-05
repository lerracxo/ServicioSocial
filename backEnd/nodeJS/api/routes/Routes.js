'use strict'

module.exports = function (app) {
  const contPersonas = require('../controllers/Personas')
  const contPeriod = require('../controllers/Period')
  const contCurso = require('../controllers/Cursos')


  app.route('/professor')
    .get(contPersonas.listAll)

  app.route('/professor/:filtr')
    .get(contPersonas.listAllAvg)

  app.route('/professor/detail/:id')
    .get(contPersonas.detail)

  app.route('/professor/detail/calif/:id')
    .get(contPersonas.detailCalif)

  app.route('/period/')
    .get(contPeriod.listAll)

  //Curso
  app.route('/curso/:id')
    .get(contCurso.getById)
}