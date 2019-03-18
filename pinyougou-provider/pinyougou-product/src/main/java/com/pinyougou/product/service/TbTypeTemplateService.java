package com.pinyougou.product.service;

import com.pinyougou.product.model.domain.TbTypeTemplate;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author theodo
 * @since 2019-01-12
 */
public interface TbTypeTemplateService extends IService<TbTypeTemplate> {

    /**
     * 添加商品类型模板
     *
     * @param tbTypeTemplate
     */
    void save(TbTypeTemplate tbTypeTemplate);

    /**
     * 修改商品类型模板
     *
     * @param tbTypeTemplate
     */
    void updateTypeTemplate(TbTypeTemplate tbTypeTemplate);

    /**
     * 批量删除
     * @param ids
     */
    void delIds(Long[] ids);
}
