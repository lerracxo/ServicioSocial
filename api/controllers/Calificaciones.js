'use strict'

const pool = require('../database/DAO')
const queries = require('../database/Queries')
const personUtil = require('../utils/PersonasUtil')
const filesUtil = require('../utils/FilesUtil')

let subDir = '/calificaciones/'

exports.detailCalif = function (req, res) {
  let param = req.params.id
  return pool.queryResponse(queries.detailProfesorCalif, [param], res)
}

exports.uploadComprobante = function (req, res) {
  let id = req.params.id

  let fileName = subDir + id
  filesUtil.uploadFile(req, fileName)
    .then((finalName) => addComprobante(id, finalName))
    .then(res.send('success'))
    .catch(console.error)
}

exports.deleteCompobante = function (req, res) {
  getDetail(req.params.id).then((calificacion) => {
    calificacion = calificacion[0]
    console.log('calificacion obj: ', calificacion)
    console.log('calificacion id: ', calificacion.id)
    console.log('calificacion comprobante: ', calificacion.comprobante)
    deleteConstancia(calificacion)
    filesUtil.removeFile(project.uploadDir + calificacion.comprobante)
  }).then(res.send('success')).catch(console.log)
}

// This data is already validated
exports.importCalificacion = function (data) {

}

function addComprobante (id, finalName) {
  pool.query(queries.updateCalificacionComprobante, [finalName, id])
}

async function getDetail (id) {
  return await pool.query(queries.detailCalificacion, [id])
}

async function deleteConstancia (cal) {
  return await pool.query(queries.deleteCalificacionComprobante, [cal.id])
}
