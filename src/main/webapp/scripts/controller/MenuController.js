highSchoolApp.controller('MenuController', ['$scope', function ($scope) {
        $scope.actionsList = [
            {
                label: 'Professors',
                url: '/HighschoolPlatform/#/professorsList',
                class: 'fa fa-fw fa-dashboard',
                show: true
            },
            {
                label: 'Students',
                url: '/HighschoolPlatform/#/studentsList',
                class: 'fa fa-fw fa-dashboard',
                show: true
            },
            {
                label: 'Oana',
                url: '/HighschoolPlatform/#/professorsList',
                class: 'fa fa-fw fa-eraser',
                show: true
            }
        ];
    }]);
