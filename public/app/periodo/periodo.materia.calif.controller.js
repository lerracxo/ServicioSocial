(function () {
  'use strict'

  angular
    .module('app')
    .controller('PeriodoMateriaCalifController',
      ['httpInterface', 'AuthenticationService', 'profUtils', '$stateParams', Controller])

  function Controller (httpInterface, AuthenticationService, profUtils, $stateParams) {
    const vm = this
    const id_periodo = $stateParams.id_periodo
    const id_materia = $stateParams.id_materia

    console.log('id_periodo', id_periodo)
    console.log('id_materia', id_materia)

    httpInterface.get('materia/' + id_materia).then((msg) => {
      vm.materia = msg.data.data[0]
    })

    httpInterface.get('periodo/' + id_periodo).then((msg) => {
      vm.periodo = msg.data.data[0]
    })

    httpInterface.get('calificaciones/' + id_materia + '/' + id_periodo).then((msg) => {
      vm.calificaciones = msg.data.data
      console.log('calificaciones', vm.calificaciones)
    })
  }
})()
