highSchoolApp.controller('ProfessorLoginController', ['$scope', '$http', '$location', '$rootScope',
    function ($scope, $http, $location, $rootScope) {
        $rootScope.loggedInProfessor = {
            id: "",
            username: "",
            password: "",
            firstName: "",
            lastName: "",
            mail: ""

        };


        $scope.password = '';
        $scope.mail = '';
        $scope.requiredErrorMessage = "Please fill out this form";

        $scope.reset = function () {
            this.mail = {};
            this.passsword = {};
        };

        $scope.create = function (mail, password) {
            $http({url: 'http://localhost:8080/HighschoolPlatform/mvc/loginProfessor', method: 'GET', params: {'mail': mail, 'password': password}}).
                    success(function (data) {
                        if (data === null || data === undefined || data === "") {
                            showNotification("Email or password incorrect!");
                        } else {
                            $rootScope.loggedInProfessor = data;
                            $rootScope.logged = true;
                            hideFields();
                            $location.url('/HighSchoolApp/#/home');
                        }
                    });
        };

        $('.message a').click(function () {
            $('form').animate({height: "toggle", opacity: "toggle"}, "slow");
        });

        var hideFields = function () {
            $rootScope.actionsList[0].show = false;
            $rootScope.actionsList[1].show = false;
            $rootScope.actionsList[2].show = false;
            $rootScope.actionsList[3].show = true;
            $rootScope.actionsList[4].show = true;
            $rootScope.actionsList[5].show = true;
            
        };

        var showNotification = function (message) {
            color = Math.floor((Math.random() * 4) + 1);

            $.notify({
                icon: "pe-7s-gift",
                message: message
            }, {
                timer: 4000,
                placement: {
                    from: "bottom",
                    align: "center"
                }
            });
        };
    }]);