app.service("typeTemplateService", function ($http) {
    this.findAll = function () {
        return $http.get("http://localhost:8888/product/typeTemplate")
    }

    this.save = function (typeTemplate) {
        return $http.post("http://localhost:8888/product/typeTemplate/", typeTemplate)
    }

    this.findById = function (id) {
        return $http.get("http://localhost:8888/product/typeTemplate/" + id);
    }
    this.update = function (typeTemplate) {
        return $http.put("http://localhost:8888/product/typeTemplate/", typeTemplate);
    }
    this.del = function (ids) {
        return $http.delete("http://localhost:8888/product/typeTemplate/" + ids)
    }
});