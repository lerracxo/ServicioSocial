'use strict'

const pool = require('../database/DAO')
const queries = require('../database/Queries')
const filesUtil = require('../utils/FilesUtil')
const dataImport = require('../database/DataImport')

const subDir = '/dataUpload/calif/'
const tableName = 'importCalif'

module.exports = {
  GET: [
    {endpoint: '/dataUpload/calif', method: calif}
  ],
  POST: [
  ],
  DELETE: []
}

/*
* Expected Layout
* [NOMBRE (paterno materno nombres), periodo, grupo, materia, puntualidad, contenido, didactica, planeacion, evaluacion,
 * actitud]
*/

let finalName

function calif (req, res) {
  let fileName = subDir + Date.now()

  console.log(fileName)

  filesUtil.uploadFile(req, fileName)
    // .then(loadCSVtoPG)
    // .then(sanitizeFields)
    // .then(insertProfessors)
    // .then(insertGrupos)
    // .then(insertMaterias)
    // .then(insertPeriodos)
    // .then(insertCalifs)
    .then(() => res.send(importSuccess()))
    .catch((error) => res.status(500).send(importFail(error)))
    .then(() => finalizeImport())
}

function loadCSVtoPG (fileName) {
  console.log('Step loadCSVtoPG')
  finalName = project.uploadDir + fileName
  return dataImport.doImport(finalName, tableName)
}

function sanitizeFields () {
  console.log('Step sanitizeFields')
  return pool.query(queries.dataImportCalifsanitizeFields)
}

function insertProfessors () {
  console.log('Step insertProfessors')
  return pool.query(queries.dataImportCalifInsertProfessors)
}

function insertGrupos () {
  console.log('Step insertGrupos')
  return pool.query(queries.dataImportCalifInsertGrupos)
}

function insertMaterias () {
  console.log('Step insertMaterias')
  return pool.query(queries.dataImportCalifInsertMaterias)
}

function insertPeriodos () {
  console.log('Step insertPeriodos')
  return pool.query(queries.dataImportCalifInsertPeriodos)
}

function insertCalifs () {
  console.log('Step insertCalifs')
  return pool.query(queries.dataImportCalifInsertCalifs)
}

function finalizeImport () {
  console.log('Step finalizeImport')
  return Promise.all([
    pool.query(queries.dataImportCalifFinalizeImport),
    filesUtil.removeFile(finalName)
  ])
}

function importSuccess () {
  console.log('All import is ok')
  return {success: true}
}

function importFail (error) {
  console.log('ImportFail method', error)
  return {success: false, error}
}
