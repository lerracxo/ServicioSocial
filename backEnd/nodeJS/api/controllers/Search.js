'use strict'

const pool = require('../database/DAO')
const queries = require('../database/Queries')
//
// exports.getById = function (req, res) {
//   console.log('params', req.params)
//   let param = req.params.id
//   pool.query(queries.cursoById, [param], function (err, data) {
//     if (err){
//       res.send(err)
//     }
//
//     res.json(data.rows)
//   })
// }
//
// const exampleQuery = {
//   materias: ['FUNDAMENTOS DE AUDITORIA', 'TALLER DE MANEJO DE BASE DE  DATOS'],
//   periodos: ['', ''],
//
//   promedioGeneral: 5.0,
//   promedioParcial: 4.5,
//
//
//
// }
//
//
//
// function generateQuery (filters){
//   if(! filters){
//     throw new Error('Filters must not be null')
//   }
//
//   const wMateria = generateWhereArray(filters.materias,'materias')
//   const wPeriodo = generateWhereArray(filters.periodos,'periodo')
//
//   const query = ' SELECT * FROM persona '
//
// }
//
//
// function generateWhereArray(array,field){
//   array = array.map((e) => {return "'" + e+"'"});
//   return field + ' IN ( '+array.join(' OR ') +' ) '
// }
