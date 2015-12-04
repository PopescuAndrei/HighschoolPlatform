highSchoolApp.controller('StudentViewController', ['$scope', '$http', '$routeParams', '$location',
    function ($scope, $http, $routeParams, $location) {
        $scope.student = {};
        $scope.clazz = undefined;
        $scope.grades = [];

        $http({url: 'http://localhost:8080/HighschoolPlatform/mvc/students/' + $routeParams.studentId, method: 'GET'}).
                success(function (data) {
                    $scope.student = data;
                });

        $http({url: 'http://localhost:8080/HighschoolPlatform/mvc/clazzes/' + $routeParams.studentId, method: 'GET'})
                .success(function (data) {
                    $scope.clazz = data;
                });
                
        $http({url: 'http://localhost:8080/HighschoolPlatform/mvc/grades/' + $routeParams.studentId, method: 'GET'})
                .success(function (data) {
                    $scope.grades = data;
                });
                
        $scope.back = function () {
            $location.url('/studentsList');
        };
    }]);