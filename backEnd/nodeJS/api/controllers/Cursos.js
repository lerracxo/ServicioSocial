'use strict'

const pool = require('../database/DAO')
const queries = require('../database/Queries')
const filesUtil = require('../utils/FilesUtil')

let subDir = '/constancias/'

exports.getById = function (req, res) {
  console.log('params', req.params)
  let param = req.params.id
  pool.query(queries.cursoById, [param], function (err, data) {
    err ? res.send(err) : res.json(data.rows)
  })
}


exports.uploadConstancia = function (req, res) {
  let id_profesor = req.params.id

  let fileName = subDir + id_profesor
  filesUtil.uploadFile(req, fileName)
    .then((finalName) => addConstancia(id_profesor, finalName))
    .then(res.send('success'))
    .catch(console.error)

}

function addConstancia(id, finalName) {
  pool.query(queries.updateCursoConstancia, [finalName, id], function (err, data) {
    return err ? err : data 
  })
}

exports.deleteConstancia = function (req, res) {
  getDetail(req.params.id).then((curso) => {
    deleteConstancia(curso)
    filesUtil.removeFile(project.uploadDir + curso.constancia)
  }).then(res.send('success')).catch(console.log)
}

function deleteConstancia(curso){
  pool.query(queries.deleteCursoConstancia,[curso.id],(err,data)=>{
    return err ? err : data
  })
}

function getDetail(id) {
  return new Promise((resolve, reject) => {
    pool.query(queries.detailCurso, [id], (err, data) => {
      err ? reject(err) : resolve(data.rows[0])
    })
  })
}



