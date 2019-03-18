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
import com.pinyougou.common.base.vo.PageVO;
import com.pinyougou.product.mapper.TbSpecificationMapper;
import com.pinyougou.product.model.domain.TbSpecification;
import com.pinyougou.product.model.domain.TbSpecificationOption;
import com.pinyougou.product.service.TbSpecificationOptionService;
import com.pinyougou.product.service.TbSpecificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.google.common.base.Preconditions.checkNotNull;

import javax.validation.Validator;
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
public class TbSpecificationServiceImpl extends ServiceImpl<TbSpecificationMapper, TbSpecification> implements TbSpecificationService {

    @Autowired
    private Validator validator;
    @Autowired
    private TbSpecificationOptionService specificationOptionService;

    @Override
    public PageVO<TbSpecification> findPageAndSearch(Integer page, Integer rows, String specName) {
        if (page == null || page == 0) {
            page = TbSpecification.PAGE_NUM;
        }
        if (rows == null || rows == 0) {
            rows = TbSpecification.PAGE_SIZE;
        }
        IPage<TbSpecification> iPage = this.baseMapper.selectPage(new Page<>(page, rows),
                new QueryWrapper<TbSpecification>()
                        .like(StrUtil.isNotBlank(specName), "spec_name", specName));
        PageVO<TbSpecification> pageVO = new PageVO<>();
        pageVO.setRows(iPage.getRecords());
        pageVO.setTotal(iPage.getTotal());
        return pageVO;
    }

    @Override
    public void save(TbSpecification tbSpecification) {

        BeanValidators.validateWithException(validator, tbSpecification, Insert.class);
        Integer index = this.baseMapper.insert(tbSpecification);
        if (index != 1) {
            throw new BusinessException(ErrorCodeEnum.GL99990500, "添加商品规格信息失败");
        }
        this.specificationOptionService.saveBeans(tbSpecification.getSpecificationOptionList(),
                tbSpecification.getId());
    }

    @Override
    public TbSpecification findById(Long id) {
        checkNotNull(id);
        TbSpecification tbSpecification = this.baseMapper.findById(id);
        if (tbSpecification == null) {
            throw new BusinessException(ErrorCodeEnum.GL99990500, "没有该商品规格信息");
        }
        return tbSpecification;
    }

    @Override
    public void updateSpec(TbSpecification tbSpecification) {
        BeanValidators.validateWithException(validator,tbSpecification, Update.class);
        Integer i = this.baseMapper.updateById(tbSpecification);
        if (i != 1) {
            throw new BusinessException(ErrorCodeEnum.GL99990500, "更新商品规格信息失败");
        }
        this.specificationOptionService.delete(new QueryWrapper<TbSpecificationOption>().eq("spec_id",
                tbSpecification.getId()));
        this.specificationOptionService.saveBeans(tbSpecification.getSpecificationOptionList(),
                tbSpecification.getId());
    }

    @Override
    public void del(Long[] ids) {

        Arrays.stream(ids).forEach(id -> baseMapper.deleteById(id));
        Arrays.stream(ids).forEach(id -> specificationOptionService.delete(new QueryWrapper<TbSpecificationOption>().eq("spec_id",
                id)));

//        for (Long id : ids) {
//            this.baseMapper.deleteById(id);
//            this.specificationOptionService.delete(new QueryWrapper<TbSpecificationOption>().eq("spec_id",
//                    id));
//        }
    }

    @Override
    public List<Map> findOptionList() {
        return this.baseMapper.findOptionList();
    }
}
