highSchoolApp.controller('AdminClassesListController', ['$scope', '$http', '$location',
    function ($scope, $http, $location) {

        $scope.classes = [];
        $scope.clazzes = [];
        $scope.courses = [];
        $scope.professors = [];

        $http({url: 'http://localhost:8080/HighschoolPlatform/mvc/clazzes', method: 'GET'}).
                success(function (data) {
                    $scope.classes = data;


                });
        $http({url: 'http://localhost:8080/HighschoolPlatform/mvc/courses', method: 'GET'}).
                success(function (data) {
                    $scope.courses = data;

                });
         $http({url: 'http://localhost:8080/HighschoolPlatform/mvc/adminClazzController'
                , method: 'POST', params: {classId: 1}}).
                    success(function (data) {
                        $scope.pairsSC = data;
                        

                    });
            classId = $("#selectClazz").val();
            $http({url: 'http://localhost:8080/HighschoolPlatform/mvc/adminClazzController'
                , method: 'DELETE', params: {classId: 1}}).
                    success(function (data) {
                        $scope.pairsPS = data;
                        


                    });

        $scope.viewClazz = function (id) {
            $location.url('/classesList/' + id);
        };
        $('#inputCourse').on('change', function () {
            courseId = $("#inputCourse").val();

            $http({url: 'http://localhost:8080/HighschoolPlatform/mvc/adminClazzController'
                , method: 'GET', params: {courseId: courseId}}).
                    success(function (data) {
                        $scope.professors = data;


                    });
        });
        $scope.updateClazz = function ()
        {
            courseId = $("#inputCourse").val();
            classId = $("#inputClazz").val();
            profId = $("#inputProfessor").val();

            $http({url: 'http://localhost:8080/HighschoolPlatform/mvc/adminClazzController', method: 'PUT'
                , params: {classId: classId, courseId: courseId, profId: profId}}).
                    success(function (data) {
                        $scope.className = data;
                    });


        };
        $('#selectClazz').on('change', function () {
            classId = $("#selectClazz").val();

            $http({url: 'http://localhost:8080/HighschoolPlatform/mvc/adminClazzController'
                , method: 'POST', params: {classId: classId}}).
                    success(function (data) {
                        $scope.pairsSC = data;
                        

                    });
            classId = $("#selectClazz").val();
            $http({url: 'http://localhost:8080/HighschoolPlatform/mvc/adminClazzController'
                , method: 'DELETE', params: {classId: classId}}).
                    success(function (data) {
                        $scope.pairsPS = data;
                        


                    });
        });
    }]);