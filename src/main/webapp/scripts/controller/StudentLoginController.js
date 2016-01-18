highSchoolApp.controller('StudentLoginController', ['$scope', '$http', '$location', '$rootScope',
    function ($scope, $http, $location, $rootScope) {
        $rootScope.loggedInStudent = {
            id: "",
            username: "",
            password: "",
            firstName: "",
            lastName: "",
            mail: "",
            classId: ""

        };
        $rootScope.class = {
            id: "",
            name: ""

        };

        $rootScope.student = {
            id: "",
            firstName: "",
            lastName: "",
            email: "",
            password: "",
            classId: ""

        };


        $scope.password = '';
        $scope.mail = '';
        $scope.requiredErrorMessage = "Please fill out this form";

        $scope.reset = function () {
            this.mail = {};
            this.passsword = {};
        };

        $scope.create = function (mail, password) {
            $http({url: 'http://localhost:8080/HighschoolPlatform/mvc/loginStudent', method: 'GET', params: {'mail': mail, 'password': password}}).
                    success(function (data) {
                        if (data === null || data === undefined || data === "") {
                            showNotification("Email or password incorrect!");
                        } else {
                            $rootScope.loggedInStudent = data;
                            $rootScope.logged = true;
                            hideFields();
                            $location.url('/HighSchoolApp/#/home');
                        }
                    });
        };

        $('.message a').click(function () {
            $('form').animate({height: "toggle", opacity: "toggle"}, "slow");
        });

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

        var hideFields = function () {
            $rootScope.actionsList[0].show = false;
            $rootScope.actionsList[1].show = false;
            $rootScope.actionsList[2].show = false;
            $rootScope.actionsList[3].show = false;
            $rootScope.actionsList[4].show = false;
            $rootScope.actionsList[5].show = false;
            $rootScope.actionsList[6].show = false;
            $rootScope.actionsList[7].show = false;
            $rootScope.actionsList[8].show = false;
<<<<<<< HEAD
=======
            $rootScope.actionsList[9].show = true;
            $rootScope.actionsList[10].show = false;
            $rootScope.actionsList[11].show = true;
            
>>>>>>> ca8b597584122c939c044b380122e55da72ace5a
        };
    }]);