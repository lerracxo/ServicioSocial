'use strict'

const jwt = require('jsonwebtoken')
const user = require('./User')

const publicEndPoints = ['/authenticate']

exports.authToken = authToken
exports.validateToken = validateToken
exports.failedTokenValidation = failedTokenValidation
exports.isTokenValid = isTokenValid

function authToken (req, res) {
  const params = req.body
  console.log('on auth params', params)

  // check user credentials and return fake jwt token if valid
  if (user.validateUser(params.username, params.password)) {
    let payload = {
      user: params.username
    }
    let token = jwt.sign(payload, project.secret, {
      expiresIn: 86400 // expires in 24 hours
    })
    successTokenValidation(res,token)
  } else {
    failedTokenValidation(res)
  }

}

function isTokenValid (req, res) {
  validateToken(req)
    .then(successTokenValidation(res,getToken(req)))
    .catch(failedTokenValidation(res))
}

function validateToken (req) {
  console.log('validating token', req.headers['token'], ' params ', req.body)
  return new Promise(function (resolve, reject) {

    if (publicEndPoints.includes(req.path)) {return resolve()}

    // check header or url parameters or post parameters for token
    let token = getToken(req)

    // decode token
    if (!token || !jwt.verify(token, project.secret)) {
      return reject('no token is present')
    }
    return resolve()
  })
}

function successTokenValidation(res,token){
  res.json({success: true, message: 'Validation successful', token})
}
function failedTokenValidation (res, error) {
  res.json({success: false, message: 'Failed to authenticate token.'})
}

function getToken (req) {
  return req.body.token || req.headers['token'] || req.headers['x-access-token']
}





