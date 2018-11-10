(function () {
  'use strict'

  angular
    .module('app')
    .controller('CursoDetailController', ['httpInterface', 'AuthenticationService', 'profUtils', '$stateParams', 'Upload', Controller])

  function Controller (httpInterface, AuthenticationService, profUtils, $stateParams, Upload) {
    const vm = this

    vm.filesLoc = profUtils.filesLoc
    vm.curso = httpInterface.fromQueryString($stateParams.curso)
    vm.isAdmin = AuthenticationService.isAdmin
    vm.getProfesores = getProfesores

    vm.removeConstancia = function (curso) {
      let response = confirm('¿Quieres eliminar este archivo?\n(No se puede deshacer)')
      if (response) {
        httpInterface.delete('curso/constancia/' + curso.id).then(getProfesores)
      }
    }

    function getProfesores () {
      httpInterface.post('professor/curso/', vm.curso).then((data) => {
        vm.profCursos = data.data.data
      })
    }

    vm.fileName = function (completeFileDir) {
      return completeFileDir !== null ? completeFileDir.split('/').slice(-1).pop() : ''
    }

    initController()

    function initController () {
      vm.getProfesores()
    }

    vm.uploadConstancia = function (curso, $files) {
      Upload.upload({
        url: httpInterface.serviceLoc + 'curso/constancia/' + curso.id,
        file: $files
      })
        .progress(function (e) { })
        .then(function (data, status, headers, config) {
          console.log('File uploaded correctly')
          getProfesores()
        })
    }
  }
})()
