package com.pinyougou.product.web.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.pinyougou.common.base.vo.PageVO;
import com.pinyougou.common.util.wrapper.WrapMapper;
import com.pinyougou.common.util.wrapper.Wrapper;
import com.pinyougou.product.model.domain.TbSpecification;
import com.pinyougou.product.service.TbSpecificationService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import com.pinyougou.common.core.controller.BaseController;

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
@RequestMapping(value = "/specifications", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
@Api(value = "WEB - ProductSpecificationController", tags = "商品规格API", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class TbSpecificationController extends BaseController {

    @Autowired
    private TbSpecificationService tbSpecificationService;


    @GetMapping("")
    @ApiOperation(httpMethod = "GET", value = "查询所有商品规格")
    public Wrapper<List<TbSpecification>> findAll() {
        logger.info("查询所有商品规格");
        return WrapMapper.ok(this.tbSpecificationService.selectList(new QueryWrapper<>()));
    }

    @GetMapping("/search")
    @ApiImplicitParams({
            @ApiImplicitParam(value = "页数", paramType = "query"),
            @ApiImplicitParam(value = "行数", paramType = "query"),
            @ApiImplicitParam(value = "规格名称", paramType = "query")
    })
    @ApiOperation(httpMethod = "GET", value = "商品规格列表搜索")
    public Wrapper<PageVO<TbSpecification>> findPageAndSearch(Integer page,
                                                              Integer rows,
                                                              String specName) {
        logger.info("商品规格列表搜索，pageNum={},pageSize={},specName={}", page, rows, specName);
        PageVO<TbSpecification> specificationPage = this.tbSpecificationService.findPageAndSearch(page, rows, specName);
        return WrapMapper.ok(specificationPage);
    }

    @PostMapping("/")
    @ApiOperation(httpMethod = "POST", value = "添加商品规格")
    public Wrapper save(@ApiParam @RequestBody TbSpecification tbSpecification) {
        logger.info("添加商品规格,tbSpecification={}", tbSpecification);
        this.tbSpecificationService.save(tbSpecification);
        return WrapMapper.ok();
    }

    @GetMapping("/{id}")
    @ApiOperation(httpMethod = "GET", value = "跟据规格ID获取商品规格")
    public Wrapper<TbSpecification> findById(@ApiParam @PathVariable Long id) {
        logger.info("跟据规格ID查询商品规格,ID={}", id);
        TbSpecification tbSpecification = this.tbSpecificationService.findById(id);
        return WrapMapper.ok(tbSpecification);
    }

    @PutMapping("/")
    @ApiOperation(httpMethod = "PUT", value = "跟据规格ID修改商品规格")
    public Wrapper update(@ApiParam @RequestBody TbSpecification tbSpecification) {
        logger.info("根据规格ID修改规格,spec={}", tbSpecification);
        this.tbSpecificationService.updateSpec(tbSpecification);
        return WrapMapper.ok();
    }

    @DeleteMapping("/{ids}")
    @ApiOperation(httpMethod = "DELETE", value = "批量删除商品规格")
    public Wrapper del(@PathVariable("ids") Long[] ids) {
        logger.info("批量删除商品规格，ID={}", ids);
        this.tbSpecificationService.del(ids);
        return WrapMapper.ok();
    }

    @GetMapping("/optionList")
    @ApiOperation(httpMethod = "GET", value = "获取商品类型模板中关联规格下拉框数据")
    public Wrapper<List<Map>> optionList() {
        logger.info("获取商品类型模板中关联规格下拉框数据");

        return WrapMapper.ok(this.tbSpecificationService.findOptionList());
    }
}
