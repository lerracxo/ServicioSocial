(function () {
  'use strict'

  angular
    .module('app')
    .controller('PeriodoController', ['httpInterface', Controller])

  function Controller (httpInterface) {
    const vm = this

    httpInterface.get('periodo/').then((msg) => {
      vm.searchResult = msg.data.data
    })
    //
    // vm.queryPeriodo = (event, query) => {
    //   if (![13, 1].includes(event.which) || !query) return
    //
    // }

    // vm.getCursoDetails = function (curso) {
    //   profUtils.changeView('/curso/detail/' + httpInterface.toQueryString(JSON.parse(angular.toJson(curso))))
    // }

  }

})()
