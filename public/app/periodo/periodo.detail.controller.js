(function () {
  'use strict'

  angular
    .module('app')
    .controller('CursoDetailController', ['httpInterface', 'profUtils', '$stateParams', Controller])

  function Controller (httpInterface, profUtils, $stateParams) {
    const vm = this

    vm.filesLoc = profUtils.filesLoc
    vm.curso = httpInterface.fromQueryString($stateParams.curso)

    vm.getProfesores = () => {
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

  }

})()





