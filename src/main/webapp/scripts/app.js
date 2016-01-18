var highSchoolApp = angular.module('highSchoolApp', ['ngRoute']);
highSchoolApp.config(['$routeProvider',
    function ($routeProvider) {
        $routeProvider
                .when('/studentLogin', {
                    templateUrl: 'views/studentLogin.html',
                    controller: 'StudentLoginController'
                })
                .when('/dropdown', {
                    templateUrl: 'views/exempludropdown.html',
                    controller: 'DropDownController'
                })
                .when('/professorLogin', {
                    templateUrl: 'views/professorLogin.html',
                    controller: 'ProfessorLoginController'
                })
                .when('/adminLogin', {
                    templateUrl: 'views/adminLogin.html',
                    controller: 'AdminLoginController'
                })
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
                .when('/adminStudentsList', {
                    templateUrl: 'views/adminStudentsList.html',
                    controller: 'AdminStudentsListController'
                })
                .when('/adminProfessorsList', {
                    templateUrl: 'views/adminProfessorsList.html',
                    controller: 'AdminProfessorsListController'
                })
               
                .when('/adminClassesList', {
                    templateUrl: 'views/adminClassesList.html',
                    controller: 'AdminClassesListController'
                })
                .when('/classesList', {
                    templateUrl: 'views/classesList.html',
                    controller: 'ClassesListController'
                })
                .when('/classesList/grades/:classId', {
                    templateUrl: 'views/classGradesView.html',
                    controller: 'ClassGradesViewController'
                })
                .when('/classesList/absences/:classId', {
                    templateUrl: 'views/classAbsencesView.html',
                    controller: 'ClassAbsencesViewController'
                })
                .when('/classesList/homework/:classId', {
                    templateUrl: 'views/homeworkAddView.html',
                    controller: 'HomeworkAddController'
                })
                .when('/studentDetails', {
                    templateUrl: 'views/studentDetails.html',
                    controller: 'StudentDetailsController'
                })
                .when('/myHomeworks', {
                    templateUrl: 'views/myHomeworks.html',
                    controller: 'ViewHomeworksController'
                })
                .when('/myHomeworks/:homeworkId', {
                    templateUrl: 'views/homeworkDetails.html',
                    controller: 'HomeworkDetailsController'
                })
                .otherwise({
                    templateUrl: 'views/home.html',
                    controller: 'HomeController'
                });
    }])
        .
        run(['$rootScope',
            function ($rootScope) {
                $rootScope.logged = false;
            }
        ]);