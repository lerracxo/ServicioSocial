(function () {
  'use strict'

  angular
    .module('app')
    .controller('PeriodoController', ['profUtils','httpInterface', Controller])

  function Controller (profUtils,httpInterface) {
    const vm = this

    httpInterface.get('periodo/').then((msg) => {
      vm.searchResult = msg.data.data
    })

    vm.getMateriasByPeriodo = function (periodo) {
      profUtils.changeView('/periodo/materia/'+periodo.id_tempo)
    }

  }

})()
