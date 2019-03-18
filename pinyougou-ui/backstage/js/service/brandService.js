app.service('brandService', function ($http) {

    this.findAll = function () {
        return $http.get("http://localhost:8888/product/brands");
    }
    this.findByPage = function (page, rows) {
        return $http.get("http://localhost:8888/product/brands/?page=" + page + "&rows=" + rows);
    }
    this.save = function (brand) {
        return $http.post("http://localhost:8888/product/brands/", brand);
    }
    this.search = function (page, rows, searchVO) {
        return $http.post("http://localhost:8888/product/brands/search?page=" + page + "&rows=" + rows, searchVO);
    }
    this.update = function (searchVO) {
        return $http.put("http://localhost:8888/product/brands/", searchVO);
    }
    this.findById = function (id) {
        return $http.get("http://localhost:8888/product/brands/" + id);
    }
    this.del = function (ids) {
        return $http.delete("http://localhost:8888/product/brands/" + ids);
    }

    this.selectOptionList = function () {
        return $http.get("http://localhost:8888/product/brands/optionList")
    }
});