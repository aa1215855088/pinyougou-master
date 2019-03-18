app.service("specificationService", function ($http) {
    this.search = function (page, rows, specName) {
        return $http.get("http://localhost:8888/product/specifications/search?specName=" + specName + "&page=" + page + "&rows=" + rows);
    }
    this.save = function (spec) {
        return $http.post("http://localhost:8888/product/specifications/", spec);
    }
    this.findById = function (id) {
        return $http.get("http://localhost:8888/product/specifications/" + id);
    }
    this.update = function (spec) {
        return $http.put("http://localhost:8888/product/specifications/", spec)
    }
    this.del = function (ids) {
        return $http.delete("http://localhost:8888/product/specifications/" + ids)
    }

    this.selectOptionList = function () {
        return $http.get("http://localhost:8888/product/specifications/optionList")
    }
});