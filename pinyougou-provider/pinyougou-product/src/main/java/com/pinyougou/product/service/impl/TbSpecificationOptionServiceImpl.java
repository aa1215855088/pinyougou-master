package com.pinyougou.product.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pinyougou.common.base.enums.ErrorCodeEnum;
import com.pinyougou.common.base.exception.BusinessException;
import com.pinyougou.product.mapper.TbSpecificationOptionMapper;
import com.pinyougou.product.model.domain.TbSpecificationOption;
import com.pinyougou.product.service.TbSpecificationOptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.Validator;
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
public class TbSpecificationOptionServiceImpl extends ServiceImpl<TbSpecificationOptionMapper, TbSpecificationOption> implements TbSpecificationOptionService {
    @Autowired
    private Validator validator;

    @Override
    public void saveBeans(List<TbSpecificationOption> specificationOptionList, Long specId) {

        specificationOptionList.stream().forEach(specOption ->
                specOption.setSpecId(specId)
        );
        List<Integer> indexs =
                specificationOptionList.stream().map(specOption -> baseMapper.insert(specOption)).collect(toList());

        if (indexs.size() != specificationOptionList.size()) {
            throw new BusinessException(ErrorCodeEnum.GL99990500, "添加商品规格选项信息失败");
        }

//        Integer num = 0;
//        for (TbSpecificationOption tbSpecificationOption : specificationOptionList) {
//            tbSpecificationOption.setSpecId(specId);
//            BeanValidators.validateWithException(validator, tbSpecificationOption);
//            Integer i = this.baseMapper.insert(tbSpecificationOption);
//            num += i;
//        }
//        if (num != specificationOptionList.size()) {
//            throw new BusinessException(ErrorCodeEnum.GL99990500, "添加商品规格选项信息失败");
//        }
    }
}
