'use strict'

const pool = require('../database/DAO')
const queries = require('../database/Queries')
const personUtil = require('../utils/PersonasUtil')
const filesUtil = require('../utils/FilesUtil')

const exopDir = '/exop/'

module.exports = { 
  GET: [
    {endpoint: '/professor/:filtr', method: listAllAvg},
    {endpoint: '/professor/detail/:id', method: detail },
  ],
  POST: [
    {endpoint: '/professor', method: listJson},
    {endpoint: '/professor/exop/:id', method: uploadExop},
    {endpoint: '/professor/curso/', method: personsByCurso},
    {endpoint: '/professor/detail/:id', method: saveDetail},
  ],
  DELETE: [
    {endpoint: '/professor/exop/:id', method: deleteExop}
  ]
}


function uploadExop (req, res) {
  let id_profesor = req.params.id

  let fileName = exopDir + id_profesor
  filesUtil.uploadFile(req, fileName)
    .then((finalName) => addExop(id_profesor, finalName))
    .then(res.send('success'))
    .catch(console.error)
}

function personsByCurso (req, res) {
  let query = req.body
  console.log('On persons by curso', query)
  pool.queryResponse(queries.personsByCurso, [query.short], res)
}

function deleteExop (req, res) {
  getDetail(req.params.id).then((profesor) => {
    pool.query(queries.deleteProfExop, [profesor.id_persona])
    filesUtil.removeFile(project.uploadDir + profesor.ex_oposicion)
    res.send('success')
  })
}

function listJson (req, res) {
  const query = personUtil.buildQuery(req.body)
  return pool.queryResponse(query, [], res)
}

function listAllAvg (req, res) {
  console.log('params', req.params)
  let param = req.params.filtr.toUpperCase()
  param = '%(' + param.replace(' ', '|') + ')%'
  pool.queryResponse(queries.listAllProfessorAVG, [param], res)
}

function detail (req, res) {
  pool.queryResponse(queries.detailProfessor, [req.params.id], res)
}

function cleanHtmlSpaces (str) {
  return str.replace(/&nbsp;/g, ' ')
}

function saveDetail (req, res) {
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

function addExop (id_profesor, fileName) {
  pool.query(queries.updateProfExop, [fileName, id_profesor])
}

function getDetail (param) {
  return pool.query(queries.detailProfessor, [param])
}
