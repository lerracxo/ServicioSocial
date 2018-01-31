(function () {
  'use strict'

  angular
    .module('app')
    .controller('ProfessorController', ['httpInterface', 'profUtils', Controller])

  function Controller (httpInterface, profUtils) {

    let vm = this

    vm.searchResult = {}
    vm.generateCSV = profUtils.generateCSV
    vm.activePeriod = undefined
    vm.promedioLabel = () => (vm.activePeriod ? 'Promedio del periodo '+ vm.activePeriod.periodo + ':': 'Promedio:')

    httpInterface.get('materia/').then((msg) => vm.materias = msg.data.data)
    httpInterface.get('periodo/').then((msg) => vm.periodos = msg.data.data)

    vm.queryProfessors = (event, query) => {
      if (![13, 1].includes(event.which)) {
        return
      }
      if (profUtils.validQuery(query)) {
        httpInterface.post('professor/', query).then((msg) => {
          vm.searchResult = msg.data.data
          console.log('received data', vm.searchResult)
          vm.activePeriod = vm.periodos.find(periodo => periodo.id_tempo == query.per)
          console.log('query.per', query.per)
          console.log('vm.activePeriod', vm.activePeriod)
        })
      }
    }

    vm.getProfessorDetails = function (profesor) {
      profUtils.changeView('/professor/detail/' + profesor.id_persona)
    }

  }

})
()
