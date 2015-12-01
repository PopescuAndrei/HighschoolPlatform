highSchoolApp.controller('ProfessorsListController', ['$scope', '$http','$location',
    function ($scope, $http, $location) {

        $scope.professors = [];


        $http({url: 'http://localhost:8080/HighschoolPlatform/mvc/professors', method: 'GET'}).
                success(function (data) {
                    $scope.professors = data;
                });

        $scope.viewProfessor = function (id) {
            $location.url('/professorsList/' + id);
        };
    }]);