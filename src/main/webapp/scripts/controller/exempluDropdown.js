highSchoolApp.controller('DropDownController', ['$scope', '$http','$location',
    function ($scope, $http, $location) {

        $scope.students = [];
        $scope.class = {
            studentId: ''
        };

        $http({url: 'http://localhost:8080/HighschoolPlatform/mvc/students', method: 'GET'}).
                success(function (data) {
                    $scope.students = data;
                });

        $scope.viewStudent = function (id) {
            $location.url('/studentsList/' + id);
        };
    }]);