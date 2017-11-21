'use strict'

exports.validateUser = function (user, pass) {
  const testUser = {username: 'test', password: 'test', firstName: 'Test', lastName: 'User'}
  return user === testUser.username && pass === testUser.password
}