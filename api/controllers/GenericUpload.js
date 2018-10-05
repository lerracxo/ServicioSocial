'use strict'

const pool = require('../database/DAO')
const queries = require('../database/Queries')
const filesUtil = require('../utils/FilesUtil')
const dataImport = require('../database/DataImport')

const subDir = '/dataUpload/calif/'
const tableName = 'importCalif'

module.exports = {
  GET: [],
  POST: [
    {endpoint: '/genericUpload/file', method: calif}
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
    .then(() => res.send(importSuccess()))
    .catch((error) => res.status(500).send(importFail(error)))
}


function importSuccess () {
  console.log('All import is ok')
  return {success: true}
}

function importFail (error) {
  console.log('ImportFail method', error)
  return {success: false, error}
}
