'use strict'

const fcsv = require('fast-csv')
const copyFrom = require('pg-copy-streams').from
const fs = require('fs')
const pg = require('../database/DAO')
const calif = require('../controllers/Calificaciones')
const tableName = 'importCalif'

console.log('Init')

const headers = ['NOMBRE (paterno materno nombres)', 'periodo', 'materia', 'grupo', 'puntualidad', 'contenido', 'didactica', 'planeacion', 'evaluacion', 'actitud']

let isError = false
let fileName = '/Users/oscar/Projects/Personal/ServicioSocial/DB Scripts/import1.csv'
let csvStream = fs.createReadStream(fileName)

fcsv.fromStream(csvStream, {
  renameHeaders: true,
  // objectMode: true,
  headers: headers,
  ignoreEmpty: true,
  strictColumnHandling: true,
  trim: true
})
  .validate((data) => {
    let result = true
    console.log('returning: ', result)
    return result //validateFields(data) && validateTypes(data)
  })
  .on('data', (data) => {
    // importCalificacion(data)
  })
  .on('data-invalid', (data) => {
    if (!data) return
    console.log('this row is invalid', data)
    isError = true
  })
  .on('end', () => {
    console.log('finish the flag is: ', isError)
    if (!isError) {
      doImport(fileName)
    }
  })
  .on('error', (error) => {
    console.error(error)
  })

function doImport (fileName) {
  pg.connect((err, client, done) => {
    let stream = client.query(copyFrom('COPY ' + tableName + 'FROM STDIN WITH CSV DELIMITER \',\' HEADER '))
    let fileStream = fs.createReadStream(fileName)

    fileStream.on('error', (error) => {console.error(error)})
    fileStream.pipe(stream)
      .on('finish', () => {
        console.log('import finished')
        done()
      })
      .on('error', (error) => {
        console.log('ERROR: ', error)
        done()
      })
  })
}

function insertProfesores () {

}

function validateFields (data) {
  for (let i = 0; i < headers.length; i++) {
    if (!headers[i]) {
      console.log('there was an error on: ', headers[i], !headers[i])
      return false
    }
  }
  return true
}

function validateTypes (data) {
  return true
}

// All data is should be clean at this point
function importCalificacion (data) {
  const personaName = data[headers[0]]
  const periodo = data[headers[1]]
  const materia = data[headers[2]]
  const grupo = data[headers[3]]
  const puntualidad = data[headers[4]]
  const contenido = data[headers[5]]
  const didactica = data[headers[6]]
  const planeacion = data[headers[7]]
  const evaluacion = data[headers[8]]
  const actitud = data[headers[9]]

  console.log(personaName)

}

// commentconsole.log('Hola que ondas :D ')
