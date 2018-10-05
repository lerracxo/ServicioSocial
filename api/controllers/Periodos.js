'use strict'

const pool = require('../database/DAO')
const queries = require('../database/Queries')

module.exports = {
  GET: [    
    {endpoint: '/periodo/', method: listAll},
    {endpoint: '/periodo/:id_periodo', method: listById},
  ],
  POST: [],
  DELETE: []
}

function listAll (req, res) {
  pool.queryResponse(queries.listAllPeriod, [], res)
}

function listById (req, res) {
  pool.queryResponse(queries.periodoById, [req.params.id_periodo], res)
}
