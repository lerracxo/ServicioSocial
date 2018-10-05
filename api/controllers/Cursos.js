'use strict'

const pool = require('../database/DAO')
const queries = require('../database/Queries')
const filesUtil = require('../utils/FilesUtil')

let subDir = '/constancias/'
   
module.exports = {
  GET: [ {endpoint: '/curso/:id', method: getById}],
  POST: [
    {endpoint: '/curso/constancia/:id', method: uploadConstancia},
    {endpoint: '/curso/', method: search},
  ],
  DELETE: [
    {endpoint: '/curso/constancia/:id', method: deleteConstancia}
  ],
}


function getById (req, res) {
  pool.queryResponse(queries.cursoById, [req.params.id], res)
}

function search (req, res) {
  const query = '' +
    '%(' + req.body.name.toUpperCase().replace(' ', '|') + ')%'
  console.log('Query curso: ', query)
  return pool.queryResponse(queries.searchCurso, [query], res)
}

function uploadConstancia (req, res) {
  let id_profesor = req.params.id

  let fileName = subDir + id_profesor
  filesUtil.uploadFile(req, fileName)
    .then((finalName) => addConstancia(id_profesor, finalName))
    .then(res.send('success'))
    .catch(console.error)
}

function addConstancia (id, finalName) {
  return pool.query(queries.updateCursoConstancia, [finalName, id])
}

function deleteConstancia (req, res) {
  getDetail(req.params.id).then((curso) => {
    curso = curso[0]
    console.log('deleting', curso)
    deleteConstanciaInternal(curso)
    filesUtil.removeFile(project.uploadDir + curso.constancia)
  }).then(res.send('success')).catch(console.log)
}

function deleteConstanciaInternal (curso) {
  return pool.query(queries.deleteCursoConstancia, [curso.id])
}

function getDetail (id) {
  return pool.query(queries.detailCurso, [id])
}
