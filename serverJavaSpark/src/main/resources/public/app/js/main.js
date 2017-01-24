var app = angular.module('administracion',  ['ngRoute']);


// //'ngResource' , ,$resource
//
app.config([ '$routeProvider', '$locationProvider',
    function($routeProvider, $locationProvider) {
        $routeProvider.when('/', {
            templateUrl : '/app/welcome.html',
            controller : 'profesorController'
        })
        $routeProvider.when('/profesor', {
            templateUrl : '/app/profesor.html',
            controller : 'profesorController'
        })
// .otherwise({
// redirectTo : 'databases.html'
// });
// $locationProvider.html5Mode(true); //Remove the '#' from URL.
    }
]);

app.controller('profesor',['$scope','$http','$location','$routeParams', function ($scope,$http,$location,$routeParams) {
	$scope.errorType = "ERROR";
	$scope.warnType = "WARN";
	
	$scope.search = "";
	$scope.databaseSearch = "";
	
	$scope.order = "status";
	
	$scope.selectedIndexDatabase = null;
	$scope.selectedDatabase = null;
	

	$http.get('/database')
	.success(
		function (data) {
			$scope.databases = data;
		}
	).error(
		function (error, status) {
		    alert("An error ocurs: "+error+" "+status);
		  }
	);
	
		 
	
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
