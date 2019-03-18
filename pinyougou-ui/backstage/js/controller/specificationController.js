app.controller("specificationController", function ($scope, $controller, $http, specificationService) {
    // AngularJS中的继承:伪继承
    $controller('baseController', {$scope: $scope});

    $scope.specName = "";

    $scope.search = function (page, rows) {
        // 向后台发送请求获取数据:
        specificationService.search(page, rows, $scope.specName).success(function (response) {
            $scope.paginationConf.totalItems = response.result.total;
            $scope.list = response.result.rows;
        });
    }

    $scope.spec = {};

    $scope.save = function () {
        var object;
        if ($scope.spec.id != null) {
            //更新
            object = specificationService.update($scope.spec)
        } else {
            //添加
            object = specificationService.save($scope.spec);
        }
        object.success(function (response) {
            // 判断保存是否成功:
            if (response.code == 200) {
                // 保存成功
                layer.msg(response.message, {
                    time: 1000,
                    icon: 1
                }, function () {
                    $scope.reloadList();
                });

            } else {
                layer.msg(response.message, {
                    time: 1000,
                    icon: 2
                });
            }
        })

    }
    $scope.findById = function (id) {
        specificationService.findById(id).success(function (response) {
            $scope.spec = response.result;
        })
    };
    $scope.addTableRow = function () {
        $scope.spec.specificationOptionList.push({
            "optionName": "",
            "orders": ""
        });
    };
    $scope.init = function () {
        $scope.spec = {
            "id": null,
            "specName": null,
            "specificationOptionList": [
                {
                    "optionName": null,
                    "orders": null,
                    "specId": $scope.spec.id
                }
            ]
        }
    };
    $scope.deleteTableRow = function (index) {
        $scope.spec.specificationOptionList.splice(index, 1);
    }

    $scope.del = function () {
        if ($scope.selectIds.length == 0) {
            layer.msg("请选择需要删除的一行")
        }
        specificationService.del($scope.selectIds).success(function (response) {
            layer.confirm('确定要删除以下数据,将无法恢复？', {
                btn: ['确定', '取消'] //按钮
            }, function () {
                if (response.code == 200) {
                    layer.msg(response.message, {
                        time: 1000,
                        icon: 1
                    }, function () {
                        $scope.reloadList();
                    });
                } else {
                    layer.msg(response.message, {
                        time: 1000,
                        icon: 2
                    });
                }
            }, function () {

            });

        })
    }
});
