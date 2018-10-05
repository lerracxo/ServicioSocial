(function () {
  'use strict'

  angular
    .module('app')
    .factory('httpInterface', ['$http',
      Service])

  function Service ($http) {
    let service = {}

    service.serviceLoc = '/'

    service.setToken = (token) => $http.defaults.headers.common.token = token
    service.removeToken = (token) => delete $http.defaults.headers.common.token

    service.post = (url, data) => $http.post(service.serviceLoc + url, data)

    service.get = (url) => $http.get(service.serviceLoc + url)

    service.delete = (url) => $http.delete(service.serviceLoc + url)

    service.http = () => $http

    service.toQueryString = function (obj) {
      return Object.keys(obj).map((x) => {
        console.log(x, obj[x])
        return x + '=' + encodeURIComponent(obj[x])
      }).join('&')
    }
    service.fromQueryString = function (params) {
      let pairs = params.split('&')

      let result = {}
      pairs.forEach(function (pair) {
        pair = pair.split('=')
        result[pair[0]] = decodeURIComponent(pair[1] || '')
      })
      return JSON.parse(JSON.stringify(result))
    }
    return service
  }
})()
