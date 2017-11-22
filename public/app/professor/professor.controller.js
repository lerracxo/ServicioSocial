(function () {
  'use strict'

  angular
    .module('app')
    .controller('ProfessorController', ['httpInterface', 'profUtils', Controller])

  function Controller (httpInterface, profUtils) {

    let vm = this

    vm.searchResult = {}

    httpInterface.get('materia/').then((msg) => vm.materias = msg.data)
    httpInterface.get('periodo/').then((msg) => vm.periodos = msg.data)

    vm.queryProfessors = (event, query) => {
      if (![13, 1].includes(event.which)) {
        return
      }
      if (profUtils.validQuery(query)) {
        httpInterface.post('professor/', query).then((msg) => {
          vm.searchResult = msg.data.data
          console.log('received data', vm.searchResult)
        })
      }
    }

    vm.getProfessorDetails = function (profesor) {
      profUtils.changeView('/professor/detail/' + profesor.id_persona)
    }

  }

})
()
