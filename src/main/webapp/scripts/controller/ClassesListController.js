highSchoolApp.controller('ClassesListController', ['$scope', '$http','$location',
    function ($scope, $http, $location) {

        $scope.clazzes = [];


        $http({url: 'http://localhost:8080/HighschoolPlatform/mvc/clazzes', method: 'GET'}).
                success(function (data) {
                    $scope.clazzes = data;
                });

        $scope.viewClazz = function (id) {
            $location.url('/classesList/' + id);
        };
    }]);