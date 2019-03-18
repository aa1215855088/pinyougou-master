package com.pinyougou.product.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pinyougou.common.base.enums.ErrorCodeEnum;
import com.pinyougou.common.base.exception.BusinessException;
import com.pinyougou.common.util.validators.BeanValidators;
import com.pinyougou.common.util.validators.Insert;
import com.pinyougou.common.util.validators.Update;
import com.pinyougou.product.mapper.TbTypeTemplateMapper;
import com.pinyougou.product.model.domain.TbTypeTemplate;
import com.pinyougou.product.service.TbTypeTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.Validator;
import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

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
public class TbTypeTemplateServiceImpl extends ServiceImpl<TbTypeTemplateMapper, TbTypeTemplate> implements TbTypeTemplateService {

    @Autowired
    private Validator validator;

    @Override
    public void save(TbTypeTemplate tbTypeTemplate) {
        BeanValidators.validateWithException(validator, tbTypeTemplate, Insert.class);
        Integer index = this.baseMapper.insert(tbTypeTemplate);
        if (index != 1) {
            throw new BusinessException(ErrorCodeEnum.GL99990500, "添加商品类型模板信息失败");
        }
    }

    @Override
    public void updateTypeTemplate(TbTypeTemplate tbTypeTemplate) {
        BeanValidators.validateWithException(validator, tbTypeTemplate, Update.class);
        Integer index = this.baseMapper.updateById(tbTypeTemplate);
        if (index != 1) {
            throw new BusinessException(ErrorCodeEnum.GL99990500, "修改商品类型模板信息失败");
        }
    }

    @Override
    public void delIds(Long[] ids) {
        List<Integer> collect = Arrays.stream(ids).map(id -> baseMapper.deleteById(id)).collect(toList());
        if (collect.size() != ids.length) {
            throw new BusinessException(ErrorCodeEnum.GL99990500, "删除商品类型模板信息失败");
        }
    }
}
