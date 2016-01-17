highSchoolApp.controller('HomeworkAddController', ['$scope', '$http', '$routeParams', '$location', '$rootScope',
    function ($scope, $http, $routeParams, $location, $rootScope) {
        $scope.clazz = {};
        $scope.dueDate = '';
        $scope.description = '';

        var url = document.URL;
        var clazzId = url.substr(url.lastIndexOf('/') + 1);

        $http({url: 'http://localhost:8080/HighschoolPlatform/mvc/clazzes/' + clazzId, method: 'GET'}).
                success(function (data) {
                    $scope.clazz = data;
                });

        $scope.addHomework = function (description, dueDate) {
            $http({
                url: 'http://localhost:8080/HighschoolPlatform/mvc/homework',
                method: 'POST',
                headers: {'Content-Type': 'application/json'},
                params: {'clazzId': this.clazz.id, 'courseId': $rootScope.loggedInProfessor.courseId, 'description': description, 'dueDate': dueDate}})
                    .success(function (data) {
                        $scope.result = data;
                        if ($scope.result === true) {
                            showNotification("Homework posted")
                        } else {
                            showNotification("Ups...Something went wrong. Try adding again")
                        }
                    });
        };

        $scope.back = function () {
            $location.url('/classesList/' + clazz.id);
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