highSchoolApp.controller('ProfessorViewController', ['$scope', '$http', '$routeParams', '$location',
    function ($scope, $http, $routeParams, $location) {
        $scope.professor = {};


        $http({url: 'http://localhost:8080/HighschoolPlatform/mvc/professors/' + $routeParams.professorId, method: 'GET'}).
                success(function (data) {
                    $scope.professor = data;
                });

        $scope.back = function () {
            $location.url('/professorsList');
        };
    }]);