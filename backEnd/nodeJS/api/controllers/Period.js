'use strict'

const pool = require('../database/DAO')
const queries = require('../database/Queries')

exports.listAll = function (req, res) {
  pool.query(queries.listAllPeriod, [], function (err, data) {
    if (err)
      res.send(err)
    res.json(data.rows)
  })
}