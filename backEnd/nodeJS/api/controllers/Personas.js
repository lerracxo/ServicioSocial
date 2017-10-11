'use strict'

const pool = require('../database/DAO')
const queries = require('../database/Queries')
const personUtil = require('../utils/PersonasUtil')

exports.listAll = function (req, res) {
  pool.query(queries.listAllProfessor, [], function (err, data) {
    if (err)
      res.send(err)
    res.json(data)
  })
}

exports.listJson = function (req, res) {
  const query = personUtil.buildQuery(req.body)
  pool.query(query, [],(err, data) => {
    if (err) {
      res.send(err)
    }
    res.json(data.rows)
  })
}

exports.listAllAvg = function (req, res) {
  console.log('params', req.params)
  let param = req.params.filtr.toUpperCase()
  param = '%(' + param.replace(' ', '|') + ')%'
  pool.query(queries.listAllProfessorAVG, [param], function (err, data) {
    if (err)
      res.send(err)
    res.json(data.rows)
  })
}

exports.detail = function (req, res) {
  console.log('params', req.params)
  let param = req.params.id
  pool.query(queries.detailProfessor, [param], function (err, data) {
    if (err)
      res.send(err)
    res.json(data.rows[0])
  })
}

exports.detailCalif = function (req, res) {
  console.log('params', req.params)
  let param = req.params.id
  pool.query(queries.detailProfesorCalif, [param], function (err, data) {
    if (err)
      res.send(err)
    res.json(data.rows)
  })
}