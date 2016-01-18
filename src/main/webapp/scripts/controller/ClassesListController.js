highSchoolApp.controller('ClassesListController', ['$scope','$rootScope', '$http','$location',
    function ($scope, $rootScope, $http, $location) {
        
        $scope.className = {};
        $scope.clazzes = [];
        
        $http({url: 'http://localhost:8080/HighschoolPlatform/mvc/clazzes',method: 'GET'}).
                success(function (data) {
                    $scope.className = data;
                });

        $http({url: 'http://localhost:8080/HighschoolPlatform/mvc/clazzes/withProfessor', params: {professorId: $rootScope.loggedInProfessor.id}, method: 'GET'}).
                success(function (data) {
                    $scope.clazzes = data;
                });

        $scope.viewClazz = function (id) {
            $location.url('/classesList/grades/' + id);
        };
        
        $scope.viewAbsences = function(id){
            $location.url('/classesList/absences/' + id);
        };
        
        $scope.addHomework = function(id){
            $location.url('/classesList/homework/' + id);
        };
    }]);