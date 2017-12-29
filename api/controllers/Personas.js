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

exports.personsByCurso = function (req, res) {
  let query = req.body
  console.log('On persons by curso', query)
  pool.queryResponse(queries.personsByCurso, [query.short], res)
}

exports.deleteExop = (req, res) => {
  getDetail(req.params.id).then((profesor) => {
    deleteExop(profesor)
    filesUtil.removeFile(project.uploadDir + profesor.ex_oposicion)
    res.send('success')
  })
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

exports.detail = function (req, res) {
  pool.queryResponse(queries.detailProfessor, [req.params.id], res)
}

function cleanHtmlSpaces (str) {
  return str.replace(/&nbsp;/g, ' ')
}

exports.saveDetail = function (req, res) {
  const professor = req.body
  console.log('at saving changes', professor)
  const arg = [
    professor.id_persona,
    professor.f_telefono,
    professor.m_telefono,
    professor.t_telefono,
    professor.ext,
    professor.mail,
    professor.cedula,
    professor.rfc,
    professor.f_ingreso,
    professor.grado]

  const upPersona = [
    professor.id_persona,
    cleanHtmlSpaces(professor.nombres),
    cleanHtmlSpaces(professor.a_paterno),
    cleanHtmlSpaces(professor.a_materno)
  ]

  console.log(professor)
  pool.query(queries.saveDetailProfessor, arg)
    .catch(res.json({success: false}))
    .then(pool.query(queries.updatePersonaDetail, upPersona))
    .catch(res.json({success: false}))
    .then(res.json({success: true}))
}

function deleteExop (profesor) {
  pool.query(queries.deleteProfExop, [profesor.id_persona])
}

function addExop (id_profesor, fileName) {
  pool.query(queries.updateProfExop, [fileName, id_profesor])
}

function getDetail (param) {
  return pool.query(queries.detailProfessor, [param])
}

