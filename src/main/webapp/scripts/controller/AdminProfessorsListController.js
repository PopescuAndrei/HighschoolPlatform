highSchoolApp.controller('AdminProfessorsListController', ['$scope', '$http', '$location',
    function ($scope, $http, $location) {

        $scope.professors = [];
        $scope.courses = [];
        $http({url: 'http://localhost:8080/HighschoolPlatform/mvc/professors', method: 'GET'}).
                success(function (data) {
                    $scope.professors = data;
                });
        $http({url: 'http://localhost:8080/HighschoolPlatform/mvc/courses', method: 'GET'}).
                success(function (data) {
                    $scope.courses = data;
                    //window.alert(JSON.stringify($scope.courses));
                });

        $scope.viewProfessor = function (id) {
            $location.url('/adminProfessorsList/' + id);
        };
        $scope.insertProfessor = function ()
        {
            name = $("#inputName").val();
            email = $("#inputEmail").val();
            course = $("#inputCourse").val();
            
            if (name.length !== "" && email !== "" && course !== "")
            {
                var pass = window.prompt("Insert password:","");
                 $http({url: 'http://localhost:8080/HighschoolPlatform/mvc/professors'
                    , method: 'POST'
                    , params: {name: name, email: email, course: course, password:pass}}).
                        success(function (data) {

                            window.alert(JSON.stringify(data));
                        });
                $location.url('/adminProfessorsList/');
            }
            else
            {
                window.alert("Please fill all fields !");
            }
        }

    }]);