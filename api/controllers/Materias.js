'use strict'

const pool = require('../database/DAO')
const queries = require('../database/Queries')

module.exports = {
  GET: [
    {endpoint: '/materia/', method: listAll},
    {endpoint: '/materia/:id', method: materiaById},
    {endpoint: '/materia/periodo/:id_periodo', method: materiasByPeriod},
  ],
  POST: [],
  DELETE: []
}

function listAll (req, res) {
  pool.queryResponse(queries.listAllMateria, [], res)
}

function materiasByPeriod (req, res) {
  pool.queryResponse(queries.listMateriaByPeriod, [req.params.id_periodo], res)
}

function materiaById (req, res) {
  pool.queryResponse(queries.materiaById, [req.params.id], res)
}
