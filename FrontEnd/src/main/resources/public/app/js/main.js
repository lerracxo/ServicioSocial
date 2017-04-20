var app = angular.module('administracion',  ['ngRoute']);

// //'ngResource' , ,$resource
//

//app.config(['$sceDelegateProvider', function($sceDelegateProvider) {
//$sceDelegateProvider.resourceUrlWhitelist(['self', 'http://localhost:8081/mansysSS**']);
//}])

app.config([ '$routeProvider', '$locationProvider','$sceDelegateProvider',
    function($routeProvider, $locationProvider,$sceDelegateProvider) {
     $sceDelegateProvider.resourceUrlWhitelist([
        // Allow same origin resource loads.
        'self',
        // Allow loading from our assets domain.  Notice the difference between * and **.
        'http://localhost:8080/mansysSS/professor/generic/*'
      ]);

      // The blacklist overrides the whitelist so the open redirect here is blocked.
      $sceDelegateProvider.resourceUrlBlacklist([
        'http://myapp.example.com/clickThru**'
      ]);


        $routeProvider.when('/', {
            templateUrl : '/app/welcome.html',
            controller : 'welcomeController'
        })
        $routeProvider.when('/profesor', {
            templateUrl : '/app/profesor.html',
            controller : 'profesorController'
        })
        $routeProvider.when('/curso', {
            templateUrl : '/app/curso.html',
            controller : 'cursoController'
        })
        $routeProvider.when('/periodo', {
            templateUrl : '/app/periodo.html',
            controller : 'periodoController'
        })
        $routeProvider.when('/calificacion', {
            templateUrl : '/app/calificacion.html',
            controller : 'calificacionController'
        })
        $routeProvider.when('/cambioContra', {
            templateUrl : '/app/cambioContra.html',
            controller : 'cambioContraController'
        })
        $routeProvider.when('/oposicion', {
            templateUrl : '/app/oposicion.html',
            controller : 'oposicionController'
        })
        $routeProvider.when('/archivo', {
            templateUrl : '/app/archivo.html',
            controller : 'archivoController'
        })
        $routeProvider.when('/perfil', {
            templateUrl : '/app/perfil.html',
            controller : 'perfilController'
        })
        $routeProvider.when('/detallesProfesor', {
            templateUrl : '/app/detallesProfesor.html',
            controller : 'detallesController'
        })
        $routeProvider.when('/graficas', {
            templateUrl : '/app/graficas.html',
            controller : 'graficasController'
        })
        $routeProvider.when('/detallesOposicion', {
            templateUrl : '/app/detallesOposicion.html',
            controller : 'oposicionController'
        })
// .otherwise({
// redirectTo : 'databases.html'
// });
// $locationProvider.html5Mode(true); //Remove the '#' from URL.
    }
]);

app.controller('profesorController',['$scope','$http','$location','$routeParams', function ($scope,$http,$location,$routeParams) {

//alert("Esto es una llamada desde el contexto");
    $scope.queryProfessors = function(){

//        alert('Querying to : http://localhost:8081/mansysSS/professor/generic/'+$scope.query)
//     $http.jsonp()
        $http.get('http://localhost:8080/mansysSS/professor/generic/'+$scope.query)
        	.success(
        		function (data) {
        			$scope.searchResult = data;
        		}
        	).error(
        		function (error, status) {
        		    alert("An error ocurs: "+error+" "+status);
        		  }
        	);
    };
    $scope.details = function(){

      $http.get(searchResult)
      	.success(
      		function (idProfesor) {
      			$scope.searchResult = idProfesor;
      		}
      	).error(
      		function (error, status) {
      		    alert("An error ocurs: "+error+" "+status);
      		  }
      	);
  };

	$scope.errorType = "ERROR";
	$scope.warnType = "WARN";
	
	$scope.search = "";
	$scope.databaseSearch = "";
	
	$scope.order = "status";
	
	$scope.selectedIndexDatabase = null;
	$scope.selectedDatabase = null;
	
	$scope.databaseSensitiveSearch = function(database) {
		if ($scope.databaseSearch) {
			return database.name.indexOf($scope.databaseSearch) == 0
			||
				database.status.indexOf($scope.databaseSearch) == 0;
		}
		return true;
	};
	
	$scope.selectDatabase = function (database, index) {
		$scope.selectedIndexDatabase = index;
		$scope.selectedDatabase = database;
	};
	
	$scope.getDatabaseDetails = function(){
		$scope.changeView('/detail/'+$scope.selectedDatabase.internalID);
	};
	
    $scope.changeView = function(view){
        $location.path(view); // path not hash
    }

	
}]);


app.controller('databaseDetails',['$scope','$http','$location','$routeParams', 
	function ($scope,$http,$location,$routeParams) {
	
	$scope.errorType = "ERROR";
	$scope.warnType = "WARN";
	
// alert('database Name: '+$routeParams.databaseName)
	
	$http({
		  method: 'GET',
		  url: '/database/'+$routeParams.databaseName
		}).then(function successCallback(response) {
			$scope.selectedDatabase = response.data;
		  }, function errorCallback(response) {
		    alert("An error ocurs");
		  });
	
	 $scope.changeView = function(view){
	        $location.path(view); // path not hash
	    }
	
}]);
