'use strict'
const controllers = require('../controllers/index.js')
const contAuth = require('../controllers/Authentication')

module.exports = function (app) {

  // Middleware
  app.use(function (req, res, next) {
    contAuth.validateToken(req, res)
      .then(next)
      .catch((error) => contAuth.failedTokenValidation(res, error))
  })

  controllers.GET.forEach(route => app.route(route.endpoint).get(route.method))

  controllers.POST.forEach(route => app.route(route.endpoint).post(route.method))

  controllers.DELETE.forEach(route => app.route(route.endpoint).delete(route.method))
}
