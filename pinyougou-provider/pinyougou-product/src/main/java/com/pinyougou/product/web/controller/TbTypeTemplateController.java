package com.pinyougou.product.web.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.pinyougou.common.util.wrapper.WrapMapper;
import com.pinyougou.common.util.wrapper.Wrapper;
import com.pinyougou.product.model.domain.TbTypeTemplate;
import com.pinyougou.product.service.TbTypeTemplateService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import com.pinyougou.common.core.controller.BaseController;

import java.util.Arrays;
import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author xuzilou
 * @since 2019-01-12
 */
@RestController
@RequestMapping(value = "/typeTemplate", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
@Api(value = "WEB - TypeTemplateController", tags = "商品类型模块API", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class TbTypeTemplateController extends BaseController {

    @Autowired
    private TbTypeTemplateService tbTypeTemplateService;

    @GetMapping("")
    @ApiOperation(httpMethod = "GET", value = "查询所有的商品类型模板")
    public Wrapper<List<TbTypeTemplate>> findAll() {
        logger.info("查询所有的商品类型模板");
        List<TbTypeTemplate> tbTypeTemplates = this.tbTypeTemplateService.selectList(new QueryWrapper<>());
        return WrapMapper.ok(tbTypeTemplates);
    }

    @PostMapping("/")
    @ApiOperation(httpMethod = "POST", value = "添加商品类型模板")
    public Wrapper save(@ApiParam @RequestBody TbTypeTemplate tbTypeTemplate) {
        logger.info("添加商品类型模板,{}", tbTypeTemplate);
        this.tbTypeTemplateService.save(tbTypeTemplate);
        return WrapMapper.ok();
    }

    @GetMapping("/{id}")
    @ApiOperation(httpMethod = "GET", value = "根据类型模板ID查询模板")
    public Wrapper<TbTypeTemplate> findById(@ApiParam @PathVariable Long id) {
        logger.info("根据类型模板ID查询模板,id={}", id);
        return WrapMapper.ok(this.tbTypeTemplateService.selectById(id));
    }

    @PutMapping("/")
    @ApiOperation(httpMethod = "PUT", value = "修改商品类型模板")
    public Wrapper update(@ApiParam @RequestBody TbTypeTemplate tbTypeTemplate) {
        logger.info("修改商品类型模板,{}", tbTypeTemplate);
        this.tbTypeTemplateService.updateTypeTemplate(tbTypeTemplate);
        return WrapMapper.ok();
    }

    @DeleteMapping("/{ids}")
    @ApiOperation(httpMethod = "DELETE", value = "批量删除")
    public Wrapper delIds(@ApiParam @PathVariable Long[] ids) {
        logger.info("批量删除,id={}", Arrays.toString(ids));
        this.tbTypeTemplateService.delIds(ids);
        return WrapMapper.ok();
    }
}
