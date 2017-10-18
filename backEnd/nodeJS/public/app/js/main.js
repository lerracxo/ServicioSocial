const app = angular.module('administracion', ['ngRoute', 'ngFileUpload'])

app.directive('ngConfirmClick', [
  function () {
    return {
      priority: 1,
      terminal: true,
      link: function (scope, element, attr) {
        var msg = attr.ngConfirmClick || "Are you sure?";
        var clickAction = attr.ngClick;
        element.bind('click', function (event) {
          if (window.confirm(msg)) {
            scope.$eval(clickAction)
          }
        });
      }
    };
  }])

app.factory('profUtils', ['$http', '$location', '$window',
  function ($http, $location, $window) {
    return {
      serviceLoc: '/',
      filesLoc: '/files/',
      reloadPage: function () {
        $window.location.reload();
      },
      changeView: function (destiny) {
        $location.path(destiny) // path not hash
      },
      queryProfessors: function (query, callback) {
        $http.post(this.serviceLoc + 'professor/', query) //+ '/' + query.prom + '/' + query.mat + '/' + query.per
          .success((data) => callback(data))
          .error(function (error, status) {
            alert('An error ocurs: ' + error + ' ' + status)
          })
      },
      httpGet: function (url, callback) {
        $http.get(this.serviceLoc + url)
          .success((data) => callback(data))
          .error(function (error, status) {
            alert('An error ocurs: ' + error + ' ' + status)
          })
      },
      httpDelete: function (url, callback) {
        $http.delete(this.serviceLoc + url)
          .success((data) => callback(data))
          .error(function (error, status) {
            alert('An error ocurs: ' + error + ' ' + status)
          })
      },
      validQuery: function (query) {
        return query &&
          (query.name ? this.validString(query.name) : true) &&
          (query.prom ? this.validDecimal(query.prom) : true) &&
          (query.mat ? this.validDecimal(query.mat) : true) &&
          (query.per ? this.validDecimal(query.per) : true)
      },
      validString: function (query) {
        let validChars = /^[a-zA-Z!@#\$%\^\&*\) ]+$/g
        return validChars.test(query)
      },
      validDecimal: function (query) {
        let validDecimal = /^[0-9.!<>=*\) ]+$/g
        return validDecimal.test(query)
      },
      getMaterias: function (callback) {
        $http.get(this.serviceLoc + 'materia/') //+ '/' + query.prom + '/' + query.mat + '/' + query.per
          .success((data) => callback(data))
          .error(function (error, status) {
            alert('An error ocurs: ' + error + ' ' + status)
          })
      },
      getPeriodos: function (callback) {
        $http.get(this.serviceLoc + 'periodo/') //+ '/' + query.prom + '/' + query.mat + '/' + query.per
          .success((data) => callback(data))
          .error(function (error, status) {
            alert('An error ocurs: ' + error + ' ' + status)
          })
      }
    }
  }])

app.controller('welcomeController',
  function () {
  })

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

app.controller('profesorController', ['$scope', '$routeParams', 'profUtils',
  function ($scope, $routeParams, profUtils) {
    $scope.searchResult = []

    profUtils.getMaterias((data) => $scope.materias = data)
    profUtils.getPeriodos((data) => $scope.periodos = data)

    $scope.queryProfessors = function (query) {
      if (profUtils.validQuery(query)) {
        profUtils.queryProfessors(query, (data) => { $scope.searchResult = data })
      }
    }

    $scope.getProfessorDetails = function (profesor) {
      profUtils.changeView('/profesor/detail/' + profesor.id_persona)
    }

  }])

app.controller('profDetailsController', ['$scope', '$http', '$location', '$routeParams', 'profUtils', 'Upload',
  function ($scope, $http, $location, $routeParams, profUtils, Upload) {

    $scope.filesLoc = profUtils.filesLoc

    function getDetalle() {
      profUtils.httpGet('professor/detail/' + $routeParams.personId, (data) => {
        $scope.profDet = data
      })
    }

    function getCursos() {
      profUtils.httpGet('curso/' + $routeParams.personId, (data) => {
        $scope.profCursos = data
      })
    }

    function getCalificaciones() {
      profUtils.httpGet('calificaciones/profesor/' + $routeParams.personId, (data) => {
        $scope.profCal = data
      })
    }

    getDetalle()
    getCursos()
    getCalificaciones()

    $scope.generateCSV = function (body, name) {
      if (!body || !body[0]) {
        alert('No hay datos para descargar')
        return
      }
      let csv = [Object.keys(JSON.parse(angular.toJson(body[0]))).join(',')].concat(
        body.map((x) => {
          return Object.values(JSON.parse(angular.toJson(x)))
        })).join('%0A').replace(/[ ]+/g, '%20')
      let a = document.createElement('a')
      a.href = 'data:attachment/csv,' + csv
      a.target = '_blank'
      a.download = name.trim() + '.csv'
      document.body.appendChild(a)
      a.click()
    }

    $scope.uploadFile = function ($files) {
      Upload.upload({
        url: profUtils.serviceLoc + 'professor/exop/' + $scope.profDet.id_persona,
        file: $files,
      })
        .progress(function (e) { })
        .then(function (data, status, headers, config) {
          console.log('File uploaded correctly')
          getDetalle()
        })
    }

    $scope.removeExop = function (profesor) {
      profUtils.httpDelete('professor/exop/' + profesor.id_persona, (data) => {
        getDetalle()
      })
    }

    $scope.uploadConstancia = function (curso, $files) {
      Upload.upload({
        url: profUtils.serviceLoc + 'curso/constancia/' + curso.id,
        file: $files,
      })
        .progress(function (e) { })
        .then(function (data, status, headers, config) {
          console.log('File uploaded correctly')
          getCursos()
        })
    }

    $scope.removeConstancia = function (curso) {
      profUtils.httpDelete('curso/constancia/' + curso.id, (data) => {
        getCursos()
      })
    }

    $scope.uploadComprobante = function (calificacion, $files) {
      Upload.upload({
        url: profUtils.serviceLoc + 'calificaciones/comprobante/' + calificacion.id,
        file: $files,
      })
        .progress(function (e) { })
        .then(function (data, status, headers, config) {
          console.log('File uploaded correctly')
          getCalificaciones()
        })
    }

    $scope.removeComprobante = function (calificacion) {
      profUtils.httpDelete('calificaciones/comprobante/' + calificacion.id, (data) => {
        getCalificaciones()
      })
    }





  }])
