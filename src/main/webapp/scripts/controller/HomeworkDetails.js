highSchoolApp.controller('HomeworkDetailsController', ['$scope', '$http', '$routeParams', '$location', '$rootScope',
    function ($scope, $http, $routeParams, $location, $rootScope) {
        $scope.homework = {};
        
        var url = document.URL;
        var homeworkId = url.substr(url.lastIndexOf('/') + 1);
        
        $http({url: 'http://localhost:8080/HighschoolPlatform/mvc/homework/' + homeworkId, method: 'GET'}).
                success(function (data) {
                    $scope.homework = data;
                });


        $scope.back = function () {
            $location.url('/myHomeworks');
        };

    }]);