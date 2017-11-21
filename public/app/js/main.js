const app = angular.module('administracion', ['ngRoute', 'ngFileUpload'])

app.config(['$routeProvider',
  function ($routeProvider) {
    $routeProvider.when('/', {
      templateUrl: 'welcome.html',
      controller: 'welcomeController'
    })
    $routeProvider.when('/profesor/:name/:prom/:mat/:per', {
      templateUrl: 'profesor.html',
      controller: 'profesorController'
    })
    $routeProvider.when('/profesor', {
      templateUrl: 'profesor.html',
      controller: 'profesorController'
    })
    $routeProvider.when('/profesor/detail/:personId', {
      templateUrl: 'profesor_detail.html',
      controller: 'profDetailsController'
    })
    $routeProvider.when('/curso', {
      templateUrl: 'curso.html',
      controller: 'cursoController'
    })
    $routeProvider.when('/curso/detail/:curso', {
      templateUrl: 'curso_detail.html',
      controller: 'cursoDetailController'
    })
    $routeProvider.when('/periodo', {
      templateUrl: 'periodo.html',
      controller: 'periodoController'
    })
    $routeProvider.when('/calificacion', {
      templateUrl: 'calificacion.html',
      controller: 'calificacionController'
    })
    $routeProvider.when('/cambioContra', {
      templateUrl: 'cambioContra.html',
      controller: 'cambioContraController'
    })
    $routeProvider.when('/oposicion', {
      templateUrl: 'oposicion.html',
      controller: 'oposicionController'
    })
    $routeProvider.when('/archivo', {
      templateUrl: 'archivo.html',
      controller: 'arvhivoController'
    })
    $routeProvider.when('/perfil', {
      templateUrl: 'perfil.html',
      controller: 'perfilController'
    })
  }
])

app.directive('ngConfirmClick', [
  function () {
    return {
      priority: 1,
      terminal: true,
      link: function (scope, element, attr) {
        let msg = attr.ngConfirmClick || 'Are you sure?'
        let clickAction = attr.ngClick
        element.bind('click', function (event) {
          if (window.confirm(msg)) {
            scope.$eval(clickAction)
          }
        })
      }
    }
  }])







