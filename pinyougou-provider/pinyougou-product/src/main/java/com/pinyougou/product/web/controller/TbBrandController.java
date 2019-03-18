package com.pinyougou.product.web.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.pinyougou.common.util.wrapper.WrapMapper;
import com.pinyougou.common.util.wrapper.Wrapper;
import com.pinyougou.product.model.domain.TbBrand;
import com.pinyougou.common.base.vo.PageVO;
import com.pinyougou.product.model.vo.BrandVO;
import com.pinyougou.product.service.TbBrandService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import com.pinyougou.common.core.controller.BaseController;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author xuzilou
 * @since 2019-01-12
 */
@RestController
@RequestMapping(value = "/brands", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
@Api(value = "WEB - ProductBrandController", tags = "商品品牌API", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class TbBrandController extends BaseController {

    @Autowired
    private TbBrandService tbBrandService;


    @GetMapping("")
    @ApiOperation(httpMethod = "GET", value = "获取商品品牌列表")
    public Wrapper<List<TbBrand>> list() {
        logger.info("获取商品品牌列表");
        List<TbBrand> tbBrands = this.tbBrandService.selectList(new QueryWrapper<>());
        return WrapMapper.ok(tbBrands);
    }

    @GetMapping("/")
    @ApiImplicitParams({
            @ApiImplicitParam(value = "页数", paramType = "query"),
            @ApiImplicitParam(value = "行数", paramType = "query")
    })
    @ApiOperation(httpMethod = "GET", value = "获取商品品牌列表分页")
    public Wrapper<PageVO<TbBrand>> listByPage(Integer page,
                                               Integer rows) {
        logger.info("品牌列表分页,pageNum={},pageSize={}", page, rows);
        PageVO<TbBrand> brandPageVO = this.tbBrandService.findByPage(page, rows, new BrandVO());
        return WrapMapper.ok(brandPageVO);
    }

    @PostMapping("/")
    @ApiOperation(httpMethod = "POST", value = "添加商品品牌")
    public Wrapper save(@RequestBody @ApiParam("商品品牌") TbBrand tbBrand) {
        logger.info("添加商品品牌,{}", tbBrand);
        this.tbBrandService.save(tbBrand);
        return WrapMapper.ok();
    }

    @PostMapping("/search")
    @ApiImplicitParams({
            @ApiImplicitParam(value = "页数", paramType = "query"),
            @ApiImplicitParam(value = "行数", paramType = "query")
    })
    @ApiOperation(httpMethod = "POST", value = "商品品牌列表搜索")
    public Wrapper<PageVO<TbBrand>> search(Integer page,
                                           Integer rows,
                                           @RequestBody @ApiParam(name = "brandVO", value = "条件") BrandVO brandVO) {
        logger.info("商品品牌列表搜索,pageNum={},pageSize={},brandVO={}", page, rows, brandVO);
        PageVO<TbBrand> brandPageVO = this.tbBrandService.findByPage(page, rows, brandVO);
        return WrapMapper.ok(brandPageVO);
    }

    @GetMapping("/{id}")
    @ApiOperation(httpMethod = "GET", value = "根据品牌ID查询商品品牌")
    public Wrapper<TbBrand> findById(@ApiParam @PathVariable Integer id) {
        logger.info("根据品牌ID查询品牌,ID={}", id);
        TbBrand tbBrand = this.tbBrandService.findById(id);
        return WrapMapper.ok(tbBrand);
    }

    @PutMapping("/")
    @ApiOperation(httpMethod = "PUT", value = "更新商品品牌")
    public Wrapper update(@ApiParam("修改参数") @RequestBody TbBrand brand) {
        logger.info("更新商品品牌,brand={}", brand);
        this.tbBrandService.updateBrand(brand);
        return WrapMapper.ok();
    }

    @DeleteMapping("/{id}")
    @ApiOperation(httpMethod = "DELETE", value = "删除商品品牌")
    public Wrapper del(@ApiParam @PathVariable("id") Long[] ids) {
        logger.info("删除商品品牌,ID={}", Arrays.toString(ids));
        this.tbBrandService.delByIds(ids);
        return WrapMapper.ok();
    }

    @GetMapping("/optionList")
    @ApiOperation(httpMethod = "GET", value = "获取商品类型模板中关联品牌下拉框数据")
    public Wrapper<List<Map>> optionList() {
        logger.info("获取商品类型模板中关联品牌下拉框数据");
        return WrapMapper.ok(this.tbBrandService.findOptionList());
    }
}
