(function () {
  'use strict'

  angular
        .module('app')
        .controller('HomeController', Controller)

  function Controller () {
    var vm = this
    vm.title = ' home '

    initController()

    function initController () {
    }
  }
})()
