'use strict'

const pool = require('../database/DAO')
const queries = require('../database/Queries')

exports.listAll = function (req, res) {
  pool.queryResponse(queries.listAllPeriod, [],res)
}

