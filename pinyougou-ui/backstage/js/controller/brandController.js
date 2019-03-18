app.controller('brandController', function ($scope, $controller, $http, brandService) {
    // AngularJS中的继承:伪继承
    $controller('baseController', {$scope: $scope});

    $scope.findAll = function () {
        //向后台发送请求
        brandService.findAll().success(function (response) {
            $scope.list = response.result;
        });
    }


    $scope.findByPage = function (page, rows) {
        brandService.findByPage(page, rows).success(function (response) {
            $scope.paginationConf.totalItems = response.result.total;
            $scope.list = response.result.rows;
        })
    }
    $scope.findById = function (id) {
        brandService.findById(id).success(function (response) {
            $scope.brand = response.result;
        })
    }
    $scope.save = function () {
        var object;
        if ($scope.brand.id != null) {
            //更新
            object = brandService.update($scope.brand)
        } else {
            //添加
            object = brandService.save($scope.brand);
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
    //查询条件初始化
    $scope.searchVO = {};
    // 假设定义一个查询的实体：searchEntity
    $scope.search = function (page, rows) {
        // 向后台发送请求获取数据:
        brandService.search(page, rows, $scope.searchVO).success(function (response) {
            $scope.paginationConf.totalItems = response.result.total;
            $scope.list = response.result.rows;
        });
    }

    $scope.del = function () {
        if ($scope.selectIds.length == 0) {
            layer.msg("请选择需要删除的一行")
        }
        brandService.del($scope.selectIds).success(function (response) {
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
