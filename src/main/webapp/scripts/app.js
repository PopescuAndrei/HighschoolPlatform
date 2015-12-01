var highSchoolApp = angular.module('highSchoolApp', ['ngRoute']);
highSchoolApp.config(['$routeProvider',
    function ($routeProvider) {
        $routeProvider
                .when('/professorsList/:professorId', {
                    templateUrl: 'views/professorView.html',
                    controller: 'ProfessorViewController'
                })
                .when('/professorsList', {
                    templateUrl: 'views/professorsList.html',
                    controller: 'ProfessorsListController'
                })
                .when('/studentsList/:studentId', {
                    templateUrl: 'views/studentView.html',
                    controller: 'StudentViewController'
                })
                .when('/studentsList', {
                    templateUrl: 'views/studentsList.html',
                    controller: 'StudentsListController'
                })
                .otherwise({
                    templateUrl: 'views/home.html',
                    controller: 'HomeController'
                });
    }])
        .
        run(['$rootScope',
            function ($rootScope) {

            }
        ]);