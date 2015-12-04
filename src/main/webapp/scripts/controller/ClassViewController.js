highSchoolApp.controller('ClassViewController', ['$scope', '$http', '$routeParams', '$location',
    function ($scope, $http, $routeParams, $location) {
        $scope.clazz = {};


        $http({url: 'http://localhost:8080/HighschoolPlatform/mvc/clazzes/' + $routeParams.clazzId, method: 'GET'}).
                success(function (data) {
                    $scope.clazz = data;
                });

        $scope.back = function () {
            $location.url('/classesList');
        };
    }]);