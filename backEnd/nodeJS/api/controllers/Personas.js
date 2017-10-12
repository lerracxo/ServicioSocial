'use strict'

const pool = require('../database/DAO')
const queries = require('../database/Queries')
const personUtil = require('../utils/PersonasUtil')
const formidable = require('formidable')
const path = require('path')
const fs = require('fs')

exports.uploadExop = function (req, res) {
  let exopDir = '/exop/'
  let fileDir =  project.uploadDir
  let id_profesor = req.params.id

  console.log('uploading a file')

  const form = new formidable.IncomingForm()
  form.multiples = false
  form.uploadDir = fileDir

  form.on('file', function (field, file) {
    // Remove spaces [id_profesor + extension of the file]
    let fileName = exopDir+id_profesor+'.'+file.name.split('.').pop().replace(/[ ]+/g, '')
    fs.rename(file.path, path.join(form.uploadDir, fileName))
    console.log('Nombre archivo: ',fileName)
    console.log('update EXOP of ',id_profesor,' result: ',addExop(id_profesor,fileName))
  })

  form.on('error', function (err) {
    console.log('An error has occur: \n', err)
  })

  form.on('end', function () {
    res.end('success')
  })

  form.parse(req)
}

function addExop (id_profesor, fileName ){
  pool.query(queries.updateProfExop,[fileName,id_profesor],function(err,data){
    return err ? err : data
  })
}

exports.listAll = function (req, res) {
  pool.query(queries.listAllProfessor, [], function (err, data) {
    if (err)
      res.send(err)
    res.json(data)
  })
}

exports.listJson = function (req, res) {
  const query = personUtil.buildQuery(req.body)
  pool.query(query, [], (err, data) => {
    if (err) {
      res.send(err)
    }
    res.json(data.rows)
  })
}

exports.listAllAvg = function (req, res) {
  console.log('params', req.params)
  let param = req.params.filtr.toUpperCase()
  param = '%(' + param.replace(' ', '|') + ')%'
  pool.query(queries.listAllProfessorAVG, [param], function (err, data) {
    if (err)
      res.send(err)
    res.json(data.rows)
  })
}

exports.detail = function (req, res) {
  console.log('params', req.params)
  let param = req.params.id
  pool.query(queries.detailProfessor, [param], function (err, data) {
    if (err)
      res.send(err)
    res.json(data.rows[0])
  })
}

exports.detailCalif = function (req, res) {
  console.log('params', req.params)
  let param = req.params.id
  pool.query(queries.detailProfesorCalif, [param], function (err, data) {
    if (err)
      res.send(err)
    res.json(data.rows)
  })
}

