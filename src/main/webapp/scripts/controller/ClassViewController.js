highSchoolApp.controller('ClassViewController', ['$scope', '$http', '$routeParams', '$location',
    function ($scope, $http, $routeParams, $location) {
        $scope.clazz = {};
        $scope.students = [];
        
        var url = document.URL;
        var clazzId = url.substr(url.lastIndexOf('/') + 1);

        $http({url: 'http://localhost:8080/HighschoolPlatform/mvc/clazzes/' + clazzId, method: 'GET'}).
                success(function (data) {
                    $scope.clazz = data;
                });
        
        
        $http({url: 'http://localhost:8080/HighschoolPlatform/mvc/studentsClass/' + clazzId, method: 'GET'}).
                success(function (data) {
                    $scope.students = data;
                });
//        $scope.create = function (addProject) {
//            $http({url: 'http://localhost:8080/AngularSpring/mvc/projects/', method: 'POST', data: addProject, headers: {'Content-Type': 'application/json'}}).
//                    success(function (data) {
//                        $scope.project = data;
//                        $scope.message = "Saved Succesfull";
//                        $location.url('/AngularSpring/#/home');
//                    });
//        };
        
        $scope.back = function () {
            $location.url('/classesList');
        };
    }]);