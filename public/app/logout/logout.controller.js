(function () {
  'use strict'

  angular
    .module('app')
    .controller('LogoutController', ['profUtils', 'AuthenticationService', Controller])

  function Controller (profUtils, AuthenticationService) {
    let vm = this
    AuthenticationService.Logout()
    profUtils.changeView('/')
  }
})()
