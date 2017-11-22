(function () {
  'use strict'

  angular
    .module('app')
    .controller('IndexController', ['profUtils','$localStorage', Controller])

  function Controller (profUtils,$localStorage) {
    let vm = this
    vm.currentUser = $localStorage.currentUser

    if(! vm.currentUser ){
      profUtils.changeView('/logout')
    }
    console.log('$localStorage',$localStorage)

    initController()

    function initController () {

    }
  }

})()