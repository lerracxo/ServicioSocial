'use strict'

const pool = require('../database/DAO')
const queries = require('../database/Queries')
const personUtil = require('../utils/PersonasUtil')
const filesUtil = require('../utils/FilesUtil')

const exopDir = '/exop/'

exports.uploadExop = function (req, res) {
  let id_profesor = req.params.id

  let fileName = exopDir + id_profesor
  filesUtil.uploadFile(req, fileName)
    .then((finalName) => addExop(id_profesor, finalName))
    .then(res.send('success'))
    .catch(console.error)
}

exports.personsByCurso = function (req,res) {
  let query = req.body
  console.log(query)
  pool.queryResponse(queries.personsByCurso, [query.curso], res)
}

exports.deleteExop = async function (req, res) {
  let profesor = await getDetail(req.params.id)
  deleteExop(profesor)
  filesUtil.removeFile(project.uploadDir + profesor.ex_oposicion)
  res.send('success')
}

exports.listJson = function (req, res) {
  const query = personUtil.buildQuery(req.body)
  return pool.queryResponse(query, [], res)
}

exports.listAllAvg = function (req, res) {
  console.log('params', req.params)
  let param = req.params.filtr.toUpperCase()
  param = '%(' + param.replace(' ', '|') + ')%'
  pool.queryResponse(queries.listAllProfessorAVG, [param], res)
}

exports.detail = async function (req, res) {
  pool.queryResponse(queries.detailProfessor,[req.params.id],res)
}

function deleteExop (profesor) {
  pool.query(queries.deleteProfExop, [profesor.id_persona])
}

function addExop (id_profesor, fileName) {
  pool.query(queries.updateProfExop, [fileName, id_profesor])
}

async function getDetail (param) {
  const result = await pool.query(queries.detailProfessor, [param])
  return result[0]
}

