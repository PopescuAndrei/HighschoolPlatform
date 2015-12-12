highSchoolApp.controller('MenuController', ['$scope', function ($scope) {
        $scope.actionsList = [
            {
                label: 'Professors',
                url: '/HighschoolPlatform/#/professorsList',
                class: 'pe-7s-user',
                show: true
            },
            {
                label: 'Students',
                url: '/HighschoolPlatform/#/studentsList',
                class: 'pe-7s-graph',
                show: true
            },
            {
                label: 'Classes',
                url: '/HighschoolPlatform/#/classesList',
                class: 'pe-7s-note2',
                show: true
            }
        ];
    }]);
