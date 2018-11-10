'use strict'

const pool = require('../database/DAO')
const queries = require('../database/Queries')
const filesUtil = require('../utils/FilesUtil')
const dataImport = require('../database/DataImport')

const subDir = '/dataUpload/calif/'
const tableName = 'importCurso'

/*
* Expected Layout
* [NOMBRE (paterno materno nombres), periodo, grupo, materia, puntualidad, contenido, didactica, planeacion, evaluacion,
 * actitud]
*/
module.exports = {
  GET: [],
  POST: [
    {endpoint: '/dataUpload/curso', method: curso},
  ],
  DELETE: []
}

let finalName

function curso (req, res) {
  let fileName = subDir + Date.now()

  console.log(fileName)

  return filesUtil.uploadFile(req, fileName)
        .then(loadCSVtoPG)
        .then(sanitizeFields)
        .then(insertProfessors)
        .then(insertCursos)
        .then(finalizeImport)
        .then(res.send(importSuccess))
        .catch((error) => res.status(500).send(importFail(error)))
}

function loadCSVtoPG (file) {
  console.log('Step loadCSVtoPG')
    finalName = project.uploadDir + file
  return dataImport.doImport(finalName, tableName)
}

function sanitizeFields () {
  console.log('Step sanitizeFields')
  return pool.query(queries.dataImportCursoSanitizeFields)
}

function insertProfessors () {
  console.log('Step insertProfessors')
  return pool.query(queries.dataImportCursoInsertProfessors)
}

function insertCursos () {
  console.log('Step insertCursos')
  return pool.query(queries.dataImportCursoInsertCursos)
}

function finalizeImport () {
  console.log('Step finalizeImport')
  return Promise.all([ filesUtil.removeFile(finalName), pool.query(queries.dataImportCursoFinalizeImport)])
}

function importSuccess () {
  return {success: true}
}

function importFail (error) {
  console.log(error)
  return {success: false, reason: error}
}
