highSchoolApp.controller('AdminChartsController', ['$scope', '$http', '$location',
    function ($scope, $http, $location) {
        $(function () {

            var barOptions = {
                series: {
                    bars: {
                        show: true,
                        barWidth: 1
                    }
                },
                grid: {
                    hoverable: true
                },
                tooltip: true,
                tooltipOpts: {
                    content: "x: %x, y: %y"
                }
            };
            var barData = {
                label: "bar",
                data: new Array(10)
            };
            var data2 = [[2, 3], [3, 4], [4, 9], [5, 8], [6, 12], [7, 10], [8, 7], [9, 14], [10, 14]];
            $http({url: 'http://localhost:8080/HighschoolPlatform/mvc/grades', method: 'PUT'}).
                    success(function (data) {

                        $.each(data, function (index, value) {
                            data2[index][1] = value;

                        });
                        

                        $.plot($("#flot-bar-chart"), [data2],
                                {
                                    data: data2,
                                    bars: {
                                        show: true
                                    }
                                }
                        );

                    });




        });

    }]);