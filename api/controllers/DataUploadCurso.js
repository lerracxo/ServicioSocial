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

exports.curso = curso
let finalName

function curso (req, res) {
  let fileName = subDir + Date.now()

  console.log(fileName)

  filesUtil.uploadFile(req, fileName)
    .then((x) => {
      finalName = x
      loadCSVtoPG(finalName)
    })
    .then(sanitizeFields)
    .then(insertProfessors)
    .then(insertCursos)
    .then(finalizeImport)
    .then(res.send(importSuccess))
    .catch((error) => res.send(importFail(error)))

}

function loadCSVtoPG (fileName) {
  console.log('Step loadCSVtoPG')
  const finalName = project.uploadDir + fileName
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

function insertCursos(){
  console.log('Step insertCursos')
  return pool.query(queries.dataImportCursoInsertCursos)
}

function finalizeImport () {
  console.log('Step finalizeImport')
  filesUtil.removeFile(project.uploadDir + finalName)
  return pool.query(queries.dataImportCursoFinalizeImport)
}

function importSuccess () {
  return {success: true}
}

function importFail (error) {
  console.log(error)
  return {success: false, reason: error}
}
