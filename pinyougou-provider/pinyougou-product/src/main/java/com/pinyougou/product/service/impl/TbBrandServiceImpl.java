package com.pinyougou.product.service.impl;


import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pinyougou.common.base.enums.ErrorCodeEnum;
import com.pinyougou.common.base.exception.BusinessException;
import com.pinyougou.common.util.validators.BeanValidators;
import com.pinyougou.common.util.validators.Insert;
import com.pinyougou.common.util.validators.Update;
import com.pinyougou.product.mapper.TbBrandMapper;
import com.pinyougou.product.model.domain.TbBrand;
import com.pinyougou.common.base.vo.PageVO;
import com.pinyougou.product.model.vo.BrandVO;
import com.pinyougou.product.service.TbBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.Validator;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author xuzilou
 * @since 2019-01-13
 */
@Service
@Transactional
public class TbBrandServiceImpl extends ServiceImpl<TbBrandMapper, TbBrand> implements TbBrandService {


    @Autowired
    private Validator validator;

    @Override
    public List<TbBrand> list(QueryWrapper<TbBrand> queryWrapper) {
        return baseMapper.selectList(queryWrapper);
    }

    @Override
    public PageVO<TbBrand> findByPage(Integer pageNum, Integer pageSize, BrandVO brandVO) {
        if (pageNum == null || pageNum == 0) {
            pageNum = TbBrand.PAGE_NUM;
        }
        if (pageSize == null || pageSize == 0) {
            pageSize = TbBrand.PAGE_SIZE;
        }

        IPage<TbBrand> brandIPage = this.baseMapper.selectPage(
                new Page<>(pageNum, pageSize),
                new QueryWrapper<TbBrand>()
                        .like(StrUtil.isNotBlank(brandVO.getName()), "name", brandVO.getName())
                        .eq(StrUtil.isNotBlank(brandVO.getFirstChar()), "first_char", brandVO.getFirstChar()));
        PageVO<TbBrand> pageVO = new PageVO<>();
        pageVO.setRows(brandIPage.getRecords());
        pageVO.setTotal(brandIPage.getTotal());
        return pageVO;
    }

    @Override
    public void save(TbBrand tbBrand) {
        BeanValidators.validateWithException(validator, tbBrand, Insert.class);
        Integer index = this.baseMapper.insert(tbBrand);
        if (index != 1) {
            throw new BusinessException(ErrorCodeEnum.GL99990500, "添加商品品牌信息失败");
        }
    }

    @Override
    public TbBrand findById(Integer id) {
        checkNotNull(id);
        TbBrand tbBrand = this.baseMapper.selectById(id);
        if (null == tbBrand) {
            throw new BusinessException(ErrorCodeEnum.GL99990500, "没有该商品品牌信息");
        }
        return tbBrand;
    }

    @Override
    public void updateBrand(TbBrand brand) {
        BeanValidators.validateWithException(validator, brand, Update.class);
        Integer index = this.baseMapper.updateById(brand);
        if (index != 1) {
            throw new BusinessException(ErrorCodeEnum.GL99990500, "更新商品品牌信息失败");
        }
    }

    @Override
    public void delByIds(Long[] ids) {
        checkNotNull(ids);
        Integer index = this.baseMapper.deleteBatchIds(Arrays.asList(ids));
        if (index != ids.length) {
            throw new BusinessException(ErrorCodeEnum.GL99990500, "删除商品品牌信息失败");
        }
    }

    @Override
    public List<Map> findOptionList() {
        return this.baseMapper.findOptionList();
    }
}
