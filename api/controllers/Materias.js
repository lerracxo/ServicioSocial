'use strict'

const pool = require('../database/DAO')
const queries = require('../database/Queries')

exports.listAll = function (req, res) {
  pool.queryResponse(queries.listAllMateria, [], res)
}

exports.materiasByPeriod = (req, res) => {
  pool.queryResponse(queries.listMateriaByPeriod, [req.params.id_periodo], res)
}

exports.materiaById = (req, res) => {
  pool.queryResponse(queries.materiaById, [req.params.id], res)
}
