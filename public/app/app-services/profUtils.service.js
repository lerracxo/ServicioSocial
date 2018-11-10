(function () {
  'use strict'

  angular
    .module('app')
    .factory('profUtils', ['$location', '$window', Service])

  function Service ($location, $window) {
    let service = {}

    service.filesLoc = '/files/'
    service.reloadPage = function () {
      $window.location.reload()
    }
    service.changeView = function (destiny) {
      $location.path(destiny) // path not hash
    }
    service.validQuery = function (query) {
      return query &&
        (query.name ? this.validString(query.name) : true) &&
        (query.prom ? this.validDecimal(query.prom) : true) &&
        (query.mat ? this.validDecimal(query.mat) : true) &&
        (query.per ? this.validDecimal(query.per) : true)
    }
    service.validString = function (query) {
      let validChars = /^[a-zA-Z!@#\$%\^\&*\) ]+$/g
      return validChars.test(query)
    }
    service.validDecimal = function (query) {
      let validDecimal = /^[0-9.!<>=*\) ]+$/g
      return validDecimal.test(query)
    }
    service.generateCSV = (body, name) => {
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

    return service
  }
})()
