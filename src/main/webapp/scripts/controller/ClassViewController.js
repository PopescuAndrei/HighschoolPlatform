highSchoolApp.controller('ClassGradesViewController', ['$scope', '$http', '$routeParams', '$location', '$rootScope',
    function ($scope, $http, $routeParams, $location, $rootScope) {
        $scope.clazz = {};
        $scope.students = [];
        $scope.grade = {};

        var url = document.URL;
        var clazzId = url.substr(url.lastIndexOf('/') + 1);

        $http({url: 'http://localhost:8080/HighschoolPlatform/mvc/clazzes/' + clazzId, method: 'GET'}).
                success(function (data) {
                    $scope.clazz = data;
                });


        $http({url: 'http://localhost:8080/HighschoolPlatform/mvc/studentsGradesClass/', params:{'classId': clazzId, 'courseId': $rootScope.loggedInProfessor.courseId}, method: 'GET'}).
                success(function (data) {
                    $scope.students = data;
                });
                
        $scope.addGrade = function (gradeValue, studentId) {
            console.log(gradeValue);
            console.log($scope.gradeValue);
            $http({
                url: 'http://localhost:8080/HighschoolPlatform/mvc/grades/',
                method: 'POST',
                headers: {'Content-Type': 'application/json'},
                params: {'studentId': studentId, 'courseId': $rootScope.loggedInProfessor.courseId, 'gradeValue': this.gradeValue}})
                    .success(function (data) {
                        $scope.result = data;
                        console.log(gradeValue);
                        if ($scope.result === true) {
                            showNotification("Grade " + this.gradeValue + "was added")
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