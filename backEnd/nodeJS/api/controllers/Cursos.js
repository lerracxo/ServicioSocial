'use strict'

const pool = require('../database/DAO')
const queries = require('../database/Queries')

exports.getById = function (req, res) {
  console.log('params', req.params)
  let param = req.params.id
  pool.query(queries.cursoById, [param], function (err, data) {
    if (err)
      res.send(err)
    res.json(data.rows)
  })
}