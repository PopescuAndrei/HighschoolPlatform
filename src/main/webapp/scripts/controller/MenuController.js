highSchoolApp.controller('MenuController', ['$scope','$rootScope', '$location', function ($scope,$rootScope, $location) {
        $rootScope.actionsList = [
            {
                label: 'Students Login',
                url: '/HighschoolPlatform/#/studentLogin',
                class: 'pe-7s-user',
                show: true
            },
            {
                label: 'Professors Login',
                url: '/HighschoolPlatform/#/professorLogin',
                class: 'pe-7s-user',
                show: true
            },
            {
                label: 'Admin Login',
                url: '/HighschoolPlatform/#/adminLogin',
                class: 'pe-7s-user',
                show: true
            },
            {
                label: 'Professors',
                url: '/HighschoolPlatform/#/professorsList',
                class: 'pe-7s-user',
                show: false
            },
            {
                label: 'Students',
                url: '/HighschoolPlatform/#/studentsList',
                class: 'pe-7s-graph',
                show: false
            },
            {
                label: 'Classes',
                url: '/HighschoolPlatform/#/classesList',
                class: 'pe-7s-note2',
                show: false
            }
        ];
        
        $scope.logout = function () {
            $rootScope.logged = false;
            $rootScope.loggedInStudent = {};
            $rootScope.loggedInProfessor = {};
            $rootScope.loggedInAdmin = {};
            $rootScope.actionsList[0].show = true;
            $rootScope.actionsList[1].show = true;
            $rootScope.actionsList[2].show = true;
            $rootScope.actionsList[3].show = false;
            $rootScope.actionsList[4].show = false;
            $rootScope.actionsList[5].show = false;
            $location.url('/HighschoolPlatform');
        };
    }]);
