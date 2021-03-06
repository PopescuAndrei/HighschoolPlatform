highSchoolApp.controller('AdminLoginController', ['$scope', '$http', '$location', '$rootScope',
    function ($scope, $http, $location, $rootScope) {
        $rootScope.loggedInAdmin = {
            id: "",
            username: "",
            password: "",
            mail: ""
        };
        $rootScope.professor = {
            id: "",
            username: "",
            password: "",
            firstName: "",
            lastName: "",
            email: ""

        };
        $rootScope.clas = {
            id: "",
            name: "",
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
            $http({url: 'http://localhost:8080/HighschoolPlatform/mvc/loginAdmin', method: 'GET', params: {'mail': mail, 'password': password}}).
                    success(function (data) {
                        if (data === null || data === undefined || data === "") {
                            showNotification("Email or password incorrect!");
                        } else {
                            $rootScope.loggedInAdmin = data;
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
            $rootScope.actionsList[3].show = false;
            $rootScope.actionsList[4].show = false;
            $rootScope.actionsList[5].show = false;
            $rootScope.actionsList[6].show = true;
            $rootScope.actionsList[7].show = true;
            $rootScope.actionsList[8].show = true;
            $rootScope.actionsList[9].show = false;
            $rootScope.actionsList[10].show = true;
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