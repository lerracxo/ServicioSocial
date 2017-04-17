var app = angular.module('administracion', ['ngRoute']);

app.factory('servicesLocation', function () {
    return {
        name: '/'
    };
});

app.config(['$routeProvider', '$locationProvider', '$sceDelegateProvider',
    function ($routeProvider, $locationProvider, $sceDelegateProvider) {
        $sceDelegateProvider.resourceUrlWhitelist([
            // Allow same origin resource loads.
            'self',
            // Allow loading from our assets domain.  Notice the difference between * and **.
            'http://localhost:8081/mansysSS/professor/generic/*'
        ]);

        // The blacklist overrides the whitelist so the open redirect here is blocked.
        $sceDelegateProvider.resourceUrlBlacklist([
            'http://myapp.example.com/clickThru**'
        ]);


        $routeProvider.when('/', {
            templateUrl: 'welcome.html',
            controller: 'welcomeController'
        });
        $routeProvider.when('/profesor', {
            templateUrl: 'profesor.html',
            controller: 'profesorController'
        });
        $routeProvider.when('/curso', {
            templateUrl: 'curso.html',
            controller: 'cursoController'
        });
        $routeProvider.when('/periodo', {
            templateUrl: 'periodo.html',
            controller: 'periodoController'
        });
        $routeProvider.when('/calificacion', {
            templateUrl: 'calificacion.html',
            controller: 'calificacionController'
        });
        $routeProvider.when('/cambioContra', {
            templateUrl: 'cambioContra.html',
            controller: 'cambioContraController'
        });
        $routeProvider.when('/oposicion', {
            templateUrl: 'oposicion.html',
            controller: 'oposicionController'
        });
        $routeProvider.when('/archivo', {
            templateUrl: 'archivo.html',
            controller: 'arvhivoController'
        });
        $routeProvider.when('/perfil', {
            templateUrl: 'perfil.html',
            controller: 'perfilController'
        });
// .otherwise({
// redirectTo : 'databases.html'
// });
// $locationProvider.html5Mode(true); //Remove the '#' from URL.
    }
]);

app.controller('profesorController', ['$scope', '$http', '$location', '$routeParams', function ($scope, $http, $location, $routeParams) {

        $scope.queryProfessors = function () {
            $http.get('http://localhost:8081/mansysSS/professor/generic/' + $scope.query)
                    .success(function (data) {
                        $scope.searchResult = data;
                    })
                    .error(function (error, status) {
                        alert("An error ocurs: " + error + " " + status);
                });
        };

        $scope.errorType = "ERROR";
        $scope.warnType = "WARN";

        $scope.search = "";
        $scope.databaseSearch = "";

        $scope.order = "status";

        $scope.selectedIndexDatabase = null;
        $scope.selectedDatabase = null;

        $scope.databaseSensitiveSearch = function (database) {
            if ($scope.databaseSearch) {
                return database.name.indexOf($scope.databaseSearch) === 0
                        ||
                        database.status.indexOf($scope.databaseSearch) === 0;
            }
            return true;
        };

        $scope.selectDatabase = function (database, index) {
            $scope.selectedIndexDatabase = index;
            $scope.selectedDatabase = database;
        };

        $scope.getDatabaseDetails = function () {
            $scope.changeView('/detail/' + $scope.selectedDatabase.internalID);
        };

        $scope.changeView = function (view) {
            $location.path(view); // path not hash
        }


    }]);


app.controller('databaseDetails', ['$scope', '$http', '$location', '$routeParams',
    function ($scope, $http, $location, $routeParams) {

        $scope.errorType = "ERROR";
        $scope.warnType = "WARN";

        $http({
            method: 'GET',
            url: '/database/' + $routeParams.databaseName
        }).then(function (response) {
            $scope.selectedDatabase = response.data;
        }, function (response) {
            alert("An error ocurs" + response.data);
        });

        $scope.changeView = function (view) {
            $location.path(view); // path not hash
        };
    }]);
