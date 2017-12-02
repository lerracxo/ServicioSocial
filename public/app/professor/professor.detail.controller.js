(function () {
  'use strict'

  angular
    .module('app')
    .controller('ProfessorDetailController',
      ['httpInterface', 'profUtils', '$stateParams', 'Upload', Controller]
    )

  function Controller (httpInterface, profUtils, $stateParams, Upload) {

    const vm = this
    vm.filesLoc = profUtils.filesLoc
    vm.personId = $stateParams.personId

    initController()

    function initController () {
      if (!vm.personId) {
        profUtils.changeView('/professor')
        return
      }
      getDetalle()
      getCursos()
      getCalificaciones()
    }

    vm.saveChanges = (profDetail) => {
      httpInterface.post('professor/detail/' + profDetail.id_persona, profDetail).then(getDetalle)
    }

    vm.removeExop = function (profesor) {
      httpInterface.delete('professor/exop/' + profesor.id_persona).then(getDetalle)
    }

    vm.generateCSV = function (body, name) {
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

    vm.uploadFile = function ($files) {
      Upload.upload({
        url: httpInterface.serviceLoc + 'professor/exop/' + vm.profDet.id_persona,
        file: $files,
      })
        .progress(function (e) { console.log(e)})
        .then(function (data, status, headers, config) {
          console.log('File uploaded correctly')
          getDetalle()
        })
    }

    vm.uploadConstancia = function (curso, $files) {
      Upload.upload({
        url: httpInterface.serviceLoc + 'curso/constancia/' + curso.id,
        file: $files,
      })
        .progress(function (e) { })
        .then(function (data, status, headers, config) {
          console.log('File uploaded correctly')
          getCursos()
        })
    }

    vm.fileName = function (completeFileDir) {
      return completeFileDir !== null ? completeFileDir.split('/').slice(-1).pop() : ''
    }

    vm.removeConstancia = function (curso) {
      httpInterface.delete('curso/constancia/' + curso.id).then(getCursos)
    }

    vm.uploadComprobante = function (calificacion, $files) {
      Upload.upload({
        url: httpInterface.serviceLoc + 'calificaciones/comprobante/' + calificacion.id,
        file: $files,
      })
        .progress(function (e) { })
        .then(function (data, status, headers, config) {
          console.log('File uploaded correctly')
          getCalificaciones()
        })
    }

    vm.removeComprobante = function (calificacion) {
      httpInterface.delete('calificaciones/comprobante/' + calificacion.id).then(getCalificaciones)
    }

    function getDetalle () {
      httpInterface.get('professor/detail/' + vm.personId).then((data) => {
        vm.profDet = data.data.data[0]
      })
    }

    function getCursos () {
      httpInterface.get('curso/' + vm.personId).then((data) => {
        vm.profCursos = data.data.data
      })
    }

    function getCalificaciones () {
      httpInterface.get('calificaciones/profesor/' + vm.personId).then((data) => {
        vm.profCal = data.data.data
      })
    }

  }

})
()
