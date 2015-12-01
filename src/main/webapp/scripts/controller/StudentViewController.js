highSchoolApp.controller('StudentViewController', ['$scope', '$http', '$routeParams', '$location',
    function ($scope, $http, $routeParams, $location) {
        $scope.student = {};


        $http({url: 'http://localhost:8080/HighschoolPlatform/mvc/students/' + $routeParams.studentId, method: 'GET'}).
                success(function (data) {
                    $scope.student = data;
                });

        $scope.back = function () {
            $location.url('/studentsList');
        };
    }]);