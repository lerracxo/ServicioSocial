const errors = require('../Errors')
const {Pool} = require('pg')
const message = require('../database/Message')

const config = {
  user: 'oscar',
  password: 'serviciosocial',
  host: 'localhost',
  database: 'oscar',
  port: 5432,
  max: '10',
  idleTimeoutMillis: 30000,
}

const pool = new Pool(config)

module.exports.pool = pool

pool.on('error', function (err, client) {
  console.log('idle client error', err.message, err.stack)
})

module.exports.queryResponse = async function (query, values, res) {
  try {
    const data = await this.query(query, values)
    let response = new message.message(null, data, null)
    res.json(response)
  } catch (error) {
    console.log(error)
    let response = new message.message(new errors.QueryError(error), null, null)
    res.json(response)
  }
}

module.exports.query = function (text, values) {
  console.log('query:', text, values)
  return new Promise(function (resolve, reject) {
    pool.query(text, values, (err, data) => {
      if (err && !data) {
        reject(err)
      } else {
        resolve(data.rows)
      }
    })
  })
}

module.exports.connect = function (callback) {
  return pool.connect(callback)
}



