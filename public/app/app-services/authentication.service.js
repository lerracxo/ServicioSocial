(function () {
  'use strict'

  angular
    .module('app')
    .factory('AuthenticationService', Service)

  function Service (httpInterface, $localStorage) {
    let service = {}

    service.Login = Login
    service.Logout = Logout
    service.isTokenValid = isTokenValid

    return service

    function Login (username, password, callback) {
      const payload = {username: username, password: password}
      httpInterface.post('authenticate', payload).then((response) => {
        const token = response.data.token
        console.log('token', token)
        // login successful if there's a token in the response
        if (token) {
          // store username and token in local storage to keep user logged in between page refreshes
          $localStorage.currentUser = {username: username, token: token}

          httpInterface.setToken(token)
          // add jwt token to auth header for all requests made by the $http service
          // $http.defaults.headers.common.Authorization = 'Bearer ' + response.token

          // execute callback with true to indicate successful login
          callback(true)
        } else {
          // execute callback with false to indicate failed login
          callback(false)
        }

      })
    }

    function isTokenValid () {
      return new Promise((resolve, reject) => {
        httpInterface.get('authenticate/verify')
          .then((response) => {
            if (response.data.success) {
              resolve()
            } else {
              reject()
            }
          })
      })
    }

    function Logout () {
      // remove user from local storage and clear http auth header
      httpInterface.removeToken()
      delete $localStorage.currentUser
      console.log('Login out ')
    }
  }
})()