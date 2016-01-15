highSchoolApp.controller('ClassViewController', ['$scope', '$http', '$routeParams', '$location', '$rootScope',
    function ($scope, $http, $routeParams, $location, $rootScope) {
        $scope.clazz = {};
        $scope.students = [];
        $scope.studentsA = [];
        $rootScope.courseId = 3;
        $scope.gradeValue = 0;

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
        
        $http({url: 'http://localhost:8080/HighschoolPlatform/mvc/studentsClass/' + clazzId, method: 'GET'}).
                success(function (data) {
                    $scope.studentsA = data;
                });
                
        $scope.addGrade = function (gradeValue, studentId) {
            $http({
                url: 'http://localhost:8080/HighschoolPlatform/mvc/grades/',
                method: 'POST',
                headers: {'Content-Type': 'application/json'},
                params: {'studentId': studentId, 'gradeValue': $scope.gradeValue, 'courseId': $rootScope.courseId}})
                    .success(function (data) {
                        $scope.result = data;
                        if ($scope.result === true) {
                            showNotification("Grade " + $scope.gradeValue + "was added")
                        } else {
                            showNotification("Ups...Something went wrong. Try adding again")
                        }
                    });
        };

        $scope.back = function () {
            $location.url('/classesList');
        };

        var showNotification = function (message) {
            color = Math.floor((Math.random() * 4) + 1);

            $.notify({
                icon: "pe-7s-gift",
                message: message
            }, {
                timer: 4000,
                placement: {
                    from: "bottom",
                    align: "center"
                }
            });
        };
    }]);