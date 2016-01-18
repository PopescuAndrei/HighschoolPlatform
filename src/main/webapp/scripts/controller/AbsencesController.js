highSchoolApp.controller('ClassAbsencesViewController', ['$scope', '$http', '$routeParams', '$location', '$rootScope',
    function ($scope, $http, $routeParams, $location, $rootScope) {
        $scope.clazz = {};
        $scope.students = [];

        var url = document.URL;
        var clazzId = url.substr(url.lastIndexOf('/') + 1);

        $http({url: 'http://localhost:8080/HighschoolPlatform/mvc/clazzes/' + clazzId, method: 'GET'}).
                success(function (data) {
                    $scope.clazz = data;
                });


        $http({url: 'http://localhost:8080/HighschoolPlatform/mvc/studentsAbsenceClass/',params:{'classId': clazzId, 'courseId': $rootScope.loggedInProfessor.courseId}, method: 'GET'}).
                success(function (data) {
                    $scope.students = data;
                });
        
                
        $scope.addAbsence = function (studentId) {
            $http({
                url: 'http://localhost:8080/HighschoolPlatform/mvc/absences',
                method: 'POST',
                headers: {'Content-Type': 'application/json'},
                params: {'studentId': studentId, 'courseId': $rootScope.loggedInProfessor.courseId}})
                    .success(function (data) {
                        $scope.result = data;
                        if ($scope.result === true) {
                            showNotification("Absence was added")
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