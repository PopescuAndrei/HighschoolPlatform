highSchoolApp.controller('MenuController', ['$scope', '$rootScope', '$location', function ($scope, $rootScope, $location) {
        $rootScope.actionsList = [
            {
                label: 'Students Login',
                url: '/HighschoolPlatform/#/studentLogin',
                class: 'pe-7s-unlock',
                show: true
            },
            {
                label: 'Professors Login',
                url: '/HighschoolPlatform/#/professorLogin',
                class: 'pe-7s-unlock',
                show: true
            },
            {
                label: 'Admin Login',
                url: '/HighschoolPlatform/#/adminLogin',
                class: 'pe-7s-tools',
                show: true
            },
            {
                label: 'Students',
                url: '/HighschoolPlatform/#/studentsList',
                class: 'pe-7s-user',
                show: false
            },
            {
                label: 'My Details',
                url: '/HighschoolPlatform/#/studentDetails',
                class: 'pe-7s-note2',
                show: false,
            },
            {
                label: 'My Classes',
                url: '/HighschoolPlatform/#/classesList',
                class: 'pe-7s-study',
                show: false
            },
            {
                label: 'Students',
                url: '/HighschoolPlatform/#/adminStudentsList',
                class: 'pe-7s-graph',
                show: false
            },
            {
                label: 'Classes',
                url: '/HighschoolPlatform/#/adminClassesList',
                class: 'pe-7s-note2',
                show: false
            },
            {
                label: 'Professors',
                url: '/HighschoolPlatform/#/adminProfessorsList',
                class: 'pe-7s-user',
                show: false
            },
            {
                label:'My Homeworks',
                url: '/HighschoolPlatform/#/myHomeworks',
                class: 'pe-7s-pen',
                shown: false
            },
            {
                label:'Charts',
                url: '/HighschoolPlatform/#/adminCharts',
                class: 'pe-7s-pen',
                shown: false
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
            $rootScope.actionsList[6].show = false;
            $rootScope.actionsList[7].show = false;
            $rootScope.actionsList[8].show = false;
            $rootScope.actionsList[9].show = false;
            $rootScope.actionsList[10].show = false;

            $location.url('/HighschoolPlatform');
        };
    }]);
