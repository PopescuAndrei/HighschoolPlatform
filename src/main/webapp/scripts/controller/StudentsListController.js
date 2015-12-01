highSchoolApp.controller('StudentsListController', ['$scope', '$http','$location',
    function ($scope, $http, $location) {

        $scope.students = [];


        $http({url: 'http://localhost:8080/HighschoolPlatform/mvc/students', method: 'GET'}).
                success(function (data) {
                    $scope.students = data;
                });

        $scope.viewStudent = function (id) {
            $location.url('/studentsList/' + id);
        };
    }]);