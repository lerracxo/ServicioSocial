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
    let importSuccess

    vm.isImportComplete = () => {
      let result = {
        classes: ['alert', 'center', 'hide'],
        message: 'Message test'
      }
      if (importSuccess !== undefined && importSuccess) {
        result.classes = result.classes.filter(item => item !== 'hide')
        result.classes.push('alert-success')
        result.message = 'El arhivo se importó exitosamente :D'
      }
      if (importSuccess !== undefined && importSuccess === false) {
        result.classes = result.classes.filter(item => item !== 'hide')
        result.classes.push('alert-danger')
        result.message = 'Ha ocurrido un error al importar el archivo :('
      }
      return result
    }

    function uploadCalif ($files) {
      Upload.upload({
        url: httpInterface.serviceLoc + 'dataUpload/curso/',
        file: $files
      })
            .progress(function (e) {
              vm.progress = e.loaded / e.total * 100
            })
            .then(function (data) {
              importSuccess = true
            }, (error) => { throw error })
            .catch((error) => {
              importSuccess = false
            })
    }
  }
})()
