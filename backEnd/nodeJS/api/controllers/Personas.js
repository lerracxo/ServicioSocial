'use strict'

const pool = require('../database/DAO')
const queries = require('../database/Queries')
const personUtil = require('../utils/PersonasUtil')
const filesUtil = require('../utils/FilesUtil')


let exopDir = '/exop/'

exports.uploadExop = function (req, res) {
  let id_profesor = req.params.id

  let fileName = exopDir + id_profesor
  filesUtil.uploadFile(req, fileName)
    .then((finalName) => addExop(id_profesor, finalName))
    .then(res.send('success'))
      .catch(console.error)
}

exports.deleteExop = function (req, res) {
  getDetail(req.params.id).then((profesor) => {
    deleteExop(profesor)
    filesUtil.removeFile(project.uploadDir + profesor.ex_oposicion)
  }).then(res.send('success')).catch(console.log)
}

function deleteExop(profesor) {
  pool.query(queries.deleteProfExop, [profesor.id_persona], function (err, data) {
    return err ? err : data
  })
}

function addExop(id_profesor, fileName) {
  console.log('update EXOP of ', id_profesor, ' fileName : ', fileName)
  pool.query(queries.updateProfExop, [fileName, id_profesor], function (err, data) {
    return err ? err : data
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
  getDetail(req.params.id).then((data) => res.json(data))
}

function getDetail(param) {
  return new Promise((resolve, reject) => {
    pool.query(queries.detailProfessor, [param], (err, data) => {
      if (err) {
        reject(err)
      }
      resolve(data.rows[0])
    })
  })
}

