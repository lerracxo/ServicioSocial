const pg = require('pg')
const config = {
  user: 'oscar',
  password: 'serviciosocial',
  host: 'localhost',
  database: 'oscar',
  port: 5432,
  max: '10',
  idleTimeoutMillis: 30000,
}

const pool = new pg.Pool(config)

pool.on('error', function (err, client) {
  console.log('idle client error', err.message, err.stack)
})

module.exports.query = function (text, values, callback) {
  console.log('query:', text, values)
  return pool.query(text, values, callback)
}

module.exports.connect = function (callback) {
  return pool.connect(callback)
}

control = function (err, client, done) {
  if (err) {
    return console.error('error fetching client from pool', err)
  }
  client.query('SELECT * FROM persona', function (err, result) {
    done()

    if (err) {
      return console.error('error happened during query', err)
    }
    console.log(result.rows)
  })
}

pg.end()

