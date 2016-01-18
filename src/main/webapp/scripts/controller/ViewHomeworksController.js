highSchoolApp.controller('ViewHomeworksController', ['$scope','$rootScope', '$http','$location',
    function ($scope, $rootScope, $http, $location) {
        
        $scope.homeworks = {};
        
        $http({url: 'http://localhost:8080/HighschoolPlatform/mvc/homework',params: {'studentId':$rootScope.loggedInStudent.id}, method: 'GET'}).
                success(function (data) {
                    $scope.homeworks = data;
                });


        $scope.viewHomework = function(id){
            $location.url('/myHomeworks/' + id);
        };
    }]);