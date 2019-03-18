package com.pinyougou.product.service;

import com.pinyougou.product.model.domain.TbSpecificationOption;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author theodo
 * @since 2019-01-12
 */
public interface TbSpecificationOptionService extends IService<TbSpecificationOption> {

    /**
     * 批量添加规格选项
     * @param specificationOptionList
     * @param id
     */
    void saveBeans(List<TbSpecificationOption> specificationOptionList,Long specId);

}
