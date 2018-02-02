(function () {
  'use strict'

  angular
    .module('app')
    .controller('PeriodoMateriaController', ['profUtils', 'httpInterface', '$stateParams', Controller])

  function Controller (profUtils, httpInterface, $stateParams) {
    const vm = this
    const id_periodo = $stateParams.id_periodo

    httpInterface.get('periodo/' + id_periodo).then((msg) => {
      vm.periodo = msg.data.data[0]
      console.log('id_periodo: ', vm.periodo)
    })

    httpInterface.get('materia/periodo/' + id_periodo).then((msg) => {
      vm.searchResult = msg.data.data
    })

    vm.getCalifByMateriaPeriodo = function (materia) {
      console.log('/periodo/calif/' + materia.id + '/' + id_periodo)
      profUtils.changeView('/periodo/calif/' + materia.id + '/' + id_periodo)
    }
  }
})()
