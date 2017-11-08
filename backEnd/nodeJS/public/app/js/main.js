const app = angular.module('administracion', ['ngRoute', 'ngFileUpload', 'query-string'])

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

app.factory('httpInterface', ['$http', '$q','$httpParamSerializer',
  function ($http, $q,$httpParamSerializer) {
    return {
      serviceLoc: '/',
      post: function (url, data) {
        return $q((resolve, reject) => {
          $http.post(this.serviceLoc + url, data)
            .success(resolve)
            .error(reject)
        })
      },
      get: function (url) {
        return $q((resolve, reject) => {
          $http.get(this.serviceLoc + url)
            .success(resolve)
            .error(reject)
        })
      },
      delete: function (url) {
        return $q((resolve, reject) => {
          $http.delete(this.serviceLoc + url)
            .success(resolve)
            .error(reject)
        })
      },
      toQueryString: function (obj) {
        return $httpParamSerializer(obj)
      },
      fromQueryString: function (params){
        // return $httpParamSerializer.
      }
    }
  }])

app.factory('profUtils', ['httpInterface', '$location', '$window',
  function (httpInterface, $location, $window) {
    return {
      filesLoc: '/files/',
      reloadPage: function () {
        $window.location.reload()
      },
      changeView: function (destiny) {
        $location.path(destiny) // path not hash
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
      }
    }
  }])

app.controller('welcomeController',
  function () {
  })

app.controller('profesorController', ['$scope', 'httpInterface', 'profUtils',
  function ($scope, httpInterface, profUtils) {

    httpInterface.get('materia/').then((msg) => $scope.materias = msg.data)
    httpInterface.get('periodo/').then((msg) => $scope.periodos = msg.data)

    $scope.queryProfessors = (event, query) => {
      if (![13, 1].includes(event.which)) {
        return
      }
      if (profUtils.validQuery(query)) {
        httpInterface.post('professor/', query).then((msg) => {
          $scope.searchResult = msg.data
          console.log('received data', $scope.searchResult)
        })
      }
    }

    $scope.getProfessorDetails = function (profesor) {
      profUtils.changeView('/profesor/detail/' + profesor.id_persona)
    }

  }])

app.controller('profDetailsController', ['$scope', 'httpInterface', '$routeParams', 'profUtils', 'Upload',
  function ($scope, httpInterface, $routeParams, profUtils, Upload) {

    $scope.filesLoc = profUtils.filesLoc

    getDetalle = () => {
      httpInterface.get('professor/detail/' + $routeParams.personId).then((msg) => {
        $scope.profDet = msg.data[0]
        console.log('msg', msg)
        console.log('profDet', $scope.profDet)
      })
    }

    function getCursos () {
      httpInterface.get('curso/' + $routeParams.personId).then((data) => {
        $scope.profCursos = data.data
      })
    }

    function getCalificaciones () {
      httpInterface.get('calificaciones/profesor/' + $routeParams.personId).then((data) => {
        $scope.profCal = data.data
      })
    }

    getDetalle()
    getCursos()
    getCalificaciones()

    $scope.removeExop = function (profesor) {
      httpInterface.delete('professor/exop/' + profesor.id_persona).then((data) => {
        getDetalle()
      })
    }

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
        url: httpInterface.serviceLoc + 'professor/exop/' + $scope.profDet.id_persona,
        file: $files,
      })
        .progress(function (e) { console.log(e)})
        .then(function (data, status, headers, config) {
          console.log('File uploaded correctly')
          getDetalle()
        })
    }

    $scope.uploadConstancia = function (curso, $files) {
      Upload.upload({
        url: httpInterface.serviceLoc + 'curso/constancia/' + curso.id,
        file: $files,
      })
        .progress(function (e) { })
        .then(function (data, status, headers, config) {
          console.log('File uploaded correctly')
          getCursos()
        })
    }

    $scope.removeConstancia = function (curso) {
      httpInterface.delete('curso/constancia/' + curso.id).then((data) => {
        getCursos()
      })
    }

    $scope.uploadComprobante = function (calificacion, $files) {
      Upload.upload({
        url: httpInterface.serviceLoc + 'calificaciones/comprobante/' + calificacion.id,
        file: $files,
      })
        .progress(function (e) { })
        .then(function (data, status, headers, config) {
          console.log('File uploaded correctly')
          getCalificaciones()
        })
    }

    $scope.removeComprobante = function (calificacion) {
      httpInterface.delete('calificaciones/comprobante/' + calificacion.id, (data) => {
        getCalificaciones()
      })
    }

  }])

app.controller('cursoController', ['$scope', 'httpInterface', 'profUtils',
  function ($scope, httpInterface, profUtils) {

    // httpInterface.get('materia/').then((msg) => $scope.materias = msg.data)
    // httpInterface.get('periodo/').then((msg) => $scope.periodos = msg.data)

    $scope.queryCursos = (event, query) => {
      if (![13, 1].includes(event.which) || !query) return
      console.log('exec event', query)
      // if () {
      //   return
      // }
      // if (profUtils.validQuery(query)) {
      httpInterface.post('curso/', query).then((msg) => {
        console.log('response', msg.data)
        $scope.searchResult = msg.data
      })
      // }
    }

    $scope.getCursoDetails = function (curso) {
      profUtils.changeView('/curso/detail/' + httpInterface.toQueryString(JSON.parse(angular.toJson(curso))))
    }

  }])

app.controller('cursoDetailController', ['$scope', 'httpInterface', '$routeParams',
  function ($scope, httpInterface, $routeParams) {

    $scope.curso = {}
    $scope.curso.curso = $routeParams.curso

    console.log('on curso detail :',$scope.curso)
    //
    // getDetail = () => {
    //   httpInterface.post('curso/detail/',query).then((msg) => {
    //     $scope.curso = msg.data[0]
    //   })
    // }

    function getProfesores () {
      httpInterface.post('professor/curso/',$scope.curso).then((data) => {
        $scope.profCursos = data.data
      })
    }
    //
    // function getCalificaciones () {
    //   httpInterface.get('calificaciones/profesor/' + $routeParams.personId).then((data) => {
    //     $scope.profCal = data.data
    //   })
    // }

    // getDetalle()
    getProfesores()
    // getCalificaciones()

  }])


