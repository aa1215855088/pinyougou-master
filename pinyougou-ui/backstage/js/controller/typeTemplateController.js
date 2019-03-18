app.controller("typeTemplateController", function ($scope, $controller, $http, brandService, specificationService, typeTemplateService) {

    // AngularJS中的继承:伪继承
    $controller('baseController', {$scope: $scope});

    $scope.findAll = function () {
        typeTemplateService.findAll().success(function (response) {
            $scope.list = response.result;
        })
    }


    $scope.brandList = {data: []}
    // 查询关联的品牌信息:
    $scope.findBrandList = function () {
        brandService.selectOptionList().success(function (response) {
            $scope.brandList = {data: response.result};
        });
    }

    $scope.specList = {data: []};
    // 查询关联的品牌信息:
    $scope.findSpecList = function () {
        specificationService.selectOptionList().success(function (response) {
            $scope.specList = {data: response.result};
        });
    };

    //给扩展属性添加行
    $scope.typeTemplate = {customAttributeItems: []};
    $scope.addTableRow = function () {
        $scope.typeTemplate.customAttributeItems.push({});
    };

    $scope.deleteTableRow = function (index) {
        $scope.typeTemplate.customAttributeItems.splice(index, 1);
    }
    //查询实体
    $scope.findOne = function (id) {
        typeTemplateService.findById(id).success(
            function (response) {
                $scope.typeTemplate = response.result;
                // eval()   JSON.parse();
                $scope.typeTemplate.brandIds = JSON.parse($scope.typeTemplate.brandIds);

                $scope.typeTemplate.specIds = JSON.parse($scope.typeTemplate.specIds);

                $scope.typeTemplate.customAttributeItems = JSON.parse($scope.typeTemplate.customAttributeItems);
            }
        );
    }

    //保存
    $scope.save = function () {
        var serviceObject;//服务层对象
        if ($scope.typeTemplate.id != null) {//如果有ID
            serviceObject = typeTemplateService.update($scope.typeTemplate); //修改
        } else {
            serviceObject = typeTemplateService.save($scope.typeTemplate);//增加
        }
        serviceObject.success(
            function (response) {
                // 判断保存是否成功:
                if (response.code == 200) {
                    // 保存成功
                    layer.msg(response.message, {
                        time: 1000,
                        icon: 1
                    }, function () {
                        window.location = location
                    });

                } else {
                    layer.msg(response.message, {
                        time: 2000,
                        icon: 2
                    });
                }
            }
        );
    }

    $scope.del = function () {
        if ($scope.selectIds.length == 0) {
            layer.msg("请选择需要删除的一行")
        }
        typeTemplateService.del($scope.selectIds).success(function (response) {
            layer.confirm('确定要删除以下数据,将无法恢复？', {
                btn: ['确定', '取消'] //按钮
            }, function () {
                if (response.code == 200) {
                    layer.msg(response.message, {
                        time: 1000,
                        icon: 1
                    }, function () {
                        window.location = location
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