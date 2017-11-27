(function () {
  'use strict'

  angular
    .module('app')
    .controller('dataUploadCursoController', ['Upload', 'httpInterface', Controller])

  function Controller (Upload, httpInterface) {
    const vm = this

    vm.helloWorld = 'hello world'
    vm.uploadCalif = uploadCalif
    vm.progress = 0

    initController()

    function uploadCalif ($files) {
      Upload.upload({
        url: httpInterface.serviceLoc + 'dataUpload/curso/',
        file: $files,
      })
        .progress(function (e) {
          console.log(e)
          vm.progress = e.loaded / e.total * 100
        })
        .then(function (data, status, headers, config) {
          // console.log('File uploaded correctly')
          // console.log('data', data)
          // console.log('status', status)
          // console.log('headers', headers)
          // console.log('config', config)
        })
    }

    function initController () {
      // reset login status
      // AuthenticationService.Logout()
    }

  }

})()