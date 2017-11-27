(function () {
  'use strict'

  angular
    .module('app')
    .controller('LoginController', Controller)

  function Controller ($location, AuthenticationService) {
    const vm = this
    vm.login = login

    function login () {
      vm.loading = true
      AuthenticationService.Login(vm.username, vm.password, function (result) {
        if (result === true) {
          $location.path('/')
        } else {
          vm.error = 'Username or password is incorrect'
          vm.loading = false
        }
      })
    }
  }

})()