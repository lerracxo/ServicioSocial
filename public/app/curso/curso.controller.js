(function () {
  'use strict'

  angular
    .module('app')
    .controller('CursoController', ['httpInterface', 'profUtils', Controller])

  function Controller (httpInterface, profUtils) {
    const vm = this

    vm.queryCursos = (event, query) => {
      if (![13, 1].includes(event.which) || !query) return
      httpInterface.post('curso/', query).then((msg) => {
        vm.searchResult = msg.data.data
      })
    }

    vm.getCursoDetails = function (curso) {
      profUtils.changeView('/curso/detail/' + httpInterface.toQueryString(JSON.parse(angular.toJson(curso))))
    }
  }
})()
