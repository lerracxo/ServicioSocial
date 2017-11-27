'use strict'

const queries = require('../database/Queries')
const dao = require('../database/DAO')

exports.validateUser = function (user, pass) {
  return dao.query(queries.validateUser, [user, pass])
}

exports.isUserValid = (data) => {
  let valid = false
  try {
    valid = data[0].id_usuario !== undefined
  } catch (error) {}
  return valid
}