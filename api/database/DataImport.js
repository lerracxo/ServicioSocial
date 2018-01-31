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
      let rs = fs.createReadStream(fileName)

      rs.on('error', (error) => {console.error(error)})
      rs.pipe(stream)
        .on('end', () => {
          console.log('loadCSV finished')
          done()
          resolve()
        })
        .on('error', (error) => {
          console.log('loadCSV ERROR')
          done()
          reject(error)
        })
    })
  })
}

