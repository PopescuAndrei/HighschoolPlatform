highSchoolApp.controller('StudentDetailsController', ['$scope', '$http', '$routeParams', '$location', '$rootScope',
    function ($scope, $http, $routeParams, $location, $rootScope) {
        $scope.student = {};
        $scope.clazz = undefined;
        $scope.grades = [];
        $scope.absences = [];
        $scope.path = "http://localhost:8080/HighschoolPlatform/mvc/students/downloadPDF/" + $rootScope.loggedInStudent.id;

        $http({url: 'http://localhost:8080/HighschoolPlatform/mvc/students/' + $rootScope.loggedInStudent.id, method: 'GET'}).
                success(function (data) {
                    $scope.student = data;
                });

        $http({url: 'http://localhost:8080/HighschoolPlatform/mvc/clazzes/' + $rootScope.loggedInStudent.id, method: 'GET'})
                .success(function (data) {
                    $scope.clazz = data;
                });

        $http({url: 'http://localhost:8080/HighschoolPlatform/mvc/grades/' + $rootScope.loggedInStudent.id, method: 'GET'})
                .success(function (data) {
                    $scope.grades = data;
                });

        $http({url: 'http://localhost:8080/HighschoolPlatform/mvc/absences/' + $rootScope.loggedInStudent.id, method: 'GET'})
                .success(function (data) {
                    $scope.absences = data;
                });

        $scope.back = function () {
            $location.url('/home');
        };

    }]);