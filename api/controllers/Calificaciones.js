'use strict'

const pool = require('../database/DAO')
const queries = require('../database/Queries')
const filesUtil = require('../utils/FilesUtil')

let subDir = '/calificaciones/'

module.exports = {
  GET: [
    {endpoint: '/calificaciones/profesor/:id', method: detailCalif},
    {endpoint: '/calificaciones/:id_materia/:id_periodo', method: califByMateriaPeriod}
  ],
  POST: [
    {endpoint: '/calificaciones/comprobante/:id', method: uploadComprobante}
  ],
  DELETE: [
    {endpoint: '/calificaciones/comprobante/:id', method: deleteCompobante}
  ]
}

function detailCalif (req, res) {
  let param = req.params.id
  return pool.queryResponse(queries.detailProfesorCalif, [param], res)
}

function uploadComprobante (req, res) {
  let id = req.params.id

  let fileName = subDir + id
  filesUtil.uploadFile(req, fileName)
    .then((finalName) => addComprobante(id, finalName))
    .then(res.send('success'))
    .catch( error => console.error(error))
}

function deleteCompobante (req, res) {
  getDetail(req.params.id).then((calificacion) => {
    calificacion = calificacion[0]
    console.log('calificacion obj: ', calificacion)
    console.log('calificacion id: ', calificacion.id)
    console.log('calificacion comprobante: ', calificacion.comprobante)
    deleteConstancia(calificacion)
    filesUtil.removeFile(project.uploadDir + calificacion.comprobante)
  }).then(res.send('success')).catch(console.log)
}

function califByMateriaPeriod (req, res) {
  pool.queryResponse(queries.califByMateriaPeriod, [req.params.id_materia, req.params.id_periodo], res)
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
