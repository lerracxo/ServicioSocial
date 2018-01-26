'use strict'

const copyFrom = require('pg-copy-streams').from
const fs = require('fs')
const pg = require('../database/DAO')

const delimiter = ' \',\''

module.exports.doImport = doImport

function doImport (fileName, tableName) {
  return new Promise((resolve, reject) => {
    pg.connect((err, client, done) => {
      const sentence = 'COPY ' + tableName + ' FROM STDIN WITH CSV DELIMITER ' + delimiter + ' HEADER ' +
        ' ENCODING \'WIN1252\' '
      console.log('SQL SENTENCE: ', sentence)
      let stream = client.query(copyFrom(sentence))
      let fileStream = fs.createReadStream(fileName)

      fileStream.on('error', (error) => {console.error(error)})
      fileStream.pipe(stream)
        .on('finish', () => {
          console.log('import finished')
          done()
          resolve()
        })
        .on('error', (error) => {
          console.log('IMPORT ERROR: ', error)
          reject()
          done()
        })
    })
  })
}

// Test purposes
// main()
//
// function main () {
//   const fileName = '/Users/oscar/Projects/Personal/ServicioSocial/DB Scripts/import1.csv'
//
//   console.log('hola')
//   doImport(fileName, 'importCalif')
//   console.log('waiting')
// }

