(function () {
  'use strict'

  angular
    .module('app', ['ngFileUpload', 'ui.router', 'ngMessages', 'ngStorage', 'ngRoute'])
    .config(config)
    .run(run)

  function config ($stateProvider, $urlRouterProvider, $locationProvider) {
    // default route
    $locationProvider.hashPrefix('')
    $urlRouterProvider.otherwise('/')

    // app routes
    $stateProvider
      .state('login', {
        url: '/login',
        templateUrl: 'login/index.view.html',
        controller: 'LoginController',
        controllerAs: 'vm'
      })
      .state('logout', {
        url: '/logout',
        // templateUrl: 'login/index.view.html',
        controller: 'LogoutController',
        // controllerAs: 'vm'
      })
      .state('home', {
        url: '/home',
        templateUrl: 'home/index.view.html',
        controller: 'HomeController',
        controllerAs: 'vm'
      })
      .state('welcome', {
        url: '/',
        templateUrl: 'welcome/welcome.html',
      })
      .state('professor', {
        url: '/professor',
        templateUrl: 'professor/professor.html',
        controller: 'ProfessorController',
        controllerAs: 'vm'
      }).state('curso', {
        url: '/curso',
        templateUrl: 'curso/curso.view.html',
        controller: 'CursoController',
        controllerAs: 'vm'
      }).state('cursoDetail', {
        url: '/curso/detail/:curso',
        templateUrl: 'curso/curso.detail.view.html',
        controller: 'CursoDetailController',
        controllerAs: 'vm'
      })
      .state('professorDetail', {
        url: '/professor/detail/:personId',
        templateUrl: 'professor/professor_detail.html',
        controller: 'ProfessorDetailController',
        controllerAs: 'vm'
      })

      .state('dataUpload', {
        url: '/data/upload/',
        templateUrl: 'dataUpload/dataUpload.view.html',
        // controller: 'ProfessorDetailController',
        // controllerAs: 'vm'
      })
      .state('uploadCalif', {
        url: '/data/upload/calif/',
        templateUrl: 'dataUpload/dataUpload.calif.view.html',
        controller: 'dataUploadCalifController',
        controllerAs: 'vm'
      })
      .state('uploadCurso', {
        url: '/data/upload/curso/',
        templateUrl: 'dataUpload/dataUpload.curso.view.html',
        controller: 'dataUploadCursoController',
        controllerAs: 'vm'
      })

  }

  function run (httpInterface, $rootScope, $location, $localStorage, AuthenticationService) {
    let publicPages = ['/login', '/logout']
    // keep user logged in after page refresh
    if ($localStorage.currentUser) {
      httpInterface.setToken($localStorage.currentUser.token)
      AuthenticationService.isTokenValid().catch((error) =>
        $location.path('/logout')
      )
      // $http.defaults.headers.common.Authorization = 'Bearer ' + $localStorage.currentUser.token
    }

    // redirect to login page if not logged in and trying to access a restricted page
    $rootScope.$on('$locationChangeStart', function (event, next, current) {
      const hasAccess = $localStorage.currentUser || publicPages.includes($location.path())
      if (!hasAccess) {
        $location.path('/login')
      }
    })
  }
})()