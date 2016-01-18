highSchoolApp.controller('AdminStudentsListController', ['$scope', '$http', '$location',
    function ($scope, $http, $location) {

        $scope.students = [];
        $scope.clazzes = [];
        
        $http({url: 'http://localhost:8080/HighschoolPlatform/mvc/students', method: 'GET'}).
                success(function (data) {
                    $scope.students = data;
                });
        $http({url: 'http://localhost:8080/HighschoolPlatform/mvc/clazzes', method: 'GET'}).
                success(function (data) {
                    $scope.clazzes = data;
                    
                });

        $scope.viewStudent = function (id) {
            $location.url('/adminStudentsList/' + id);
        };
        $scope.insertStudent = function ()
        {
            name = $("#inputName").val();
            email = $("#inputEmail").val();
            clazz = $("#inputClass").val();
            window.alert(clazz);
            if (name.length !== "" && email !== "" && clazz !== "")
            {
                var pass = window.prompt("Insert password:", "");
                $http({url: 'http://localhost:8080/HighschoolPlatform/mvc/students'
                    , method: 'POST'
                    , params: {name: name, email: email, clazz:clazz, password: pass}}).
                        success(function (data) {

                            window.alert(JSON.stringify(data));
                        });
                $location.url('/adminStudentsList/');
            } else
            {
                window.alert("Please fill all fields !");
            }
        }
    }]);