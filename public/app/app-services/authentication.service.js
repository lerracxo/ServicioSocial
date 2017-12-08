(function () {
  'use strict'

  angular
    .module('app')
    .factory('AuthenticationService', Service)

  function Service (httpInterface, $localStorage) {
    let service = {}

    service.isAdmin = isAdmin
    service.Login = Login
    service.Logout = Logout
    service.isTokenValid = isTokenValid

    return service

    function isUserLogged () {
      return !!$localStorage.currentUser
    }

    function isAdmin () {
      if (!isUserLogged())
        return false
      return $localStorage.currentUser.rol === 'admin'
    }

    function Login (username, password, callback) {
      const payload = {username: username, password: password}
      httpInterface.post('authenticate', payload).then((response) => {
        const token = response.data.token
        const rol = response.data.rol
        console.log('rol', rol)
        console.log('token', token)
        // login successful if there's a token in the response
        if (token) {
          // store username and token in local storage to keep user logged in between page refreshes
          $localStorage.currentUser = {username, token, rol}

          httpInterface.setToken(token)
          // add jwt token to auth header for all requests made by the $http service

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