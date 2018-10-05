'use strict'
const personas = require('../controllers/Personas')
const auth = require('../controllers/Authentication')
const cursos = require('../controllers/Cursos')
const calif = require('../controllers/Calificaciones')
const materias = require('../controllers/Materias')
const periodos = require('../controllers/Periodos')
const upCalif = require('../controllers/DataUploadCalif')
const upCurso = require('../controllers/DataUploadCurso')
const utils = require('../controllers/Utils')


const controllers = {
    GET: [
      ...personas.GET, 
      ...auth.GET, 
      ...cursos.GET, 
      ...calif.GET, 
      ...materias.GET, 
      ...periodos.GET, 
      ...upCalif.GET, 
      ...upCurso.GET, 
      ...utils.GET
    ],
    POST: [
      ...personas.POST, 
      ...auth.POST, 
      ...cursos.POST, 
      ...calif.POST, 
      ...materias.POST, 
      ...periodos.POST, 
      ...upCalif.POST, 
      ...upCurso.POST, 
      ...utils.POST],
    DELETE: [
      ...personas.DELETE, 
      ...auth.DELETE, 
      ...cursos.DELETE, 
      ...calif.DELETE, 
      ...materias.DELETE, 
      ...periodos.DELETE, 
      ...upCalif.DELETE, 
      ...upCurso.DELETE, 
      ...utils.DELETE
    ]
}


module.exports = function (app) {

  // Middleware
  app.use(function (req, res, next) {
    auth.validateToken(req, res)
      .then(next)
      .catch((error) => auth.failedTokenValidation(res, error))
  })

  controllers.GET.forEach(route => app.route(route.endpoint).get(route.method))

  controllers.POST.forEach(route => app.route(route.endpoint).post(route.method))

  controllers.DELETE.forEach(route => app.route(route.endpoint).delete(route.method))
}
