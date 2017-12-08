(function () {
  'use strict'

  angular
    .module('app')
    .controller('IndexController', ['profUtils', 'AuthenticationService', '$localStorage', Controller])

  function Controller (profUtils, AuthenticationService, $localStorage) {
    let vm = this
    vm.getCurrentUser = () => $localStorage.currentUser
    vm.isAdmin = AuthenticationService.isAdmin

    if (!vm.getCurrentUser()) {
      profUtils.changeView('/logout')
    }
    //console.log('$localStorage',$localStorage)
  }

})()