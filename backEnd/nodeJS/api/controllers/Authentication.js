'use strict'

const pool = require('../database/DAO')
const queries = require('../database/Queries')
const personUtil = require('../utils/PersonasUtil')
const filesUtil = require('../utils/FilesUtil')

exports.authToken = function (req, res) {
  const testUser = {username: 'test', password: 'test', firstName: 'Test', lastName: 'User'}
  const params = req.body

  console.log('params',params)
  // check user credentials and return fake jwt token if valid
  if (params.username === testUser.username && params.password === testUser.password) {
    res.json({token: 'fake-jwt-token'})
  } else {
    res.json({})
  }

}
