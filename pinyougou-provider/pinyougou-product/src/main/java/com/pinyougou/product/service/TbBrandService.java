package com.pinyougou.product.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.pinyougou.product.model.domain.TbBrand;
import com.baomidou.mybatisplus.extension.service.IService;
import com.pinyougou.common.base.vo.PageVO;
import com.pinyougou.product.model.vo.BrandVO;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author theodo
 * @since 2019-01-12
 */
public interface TbBrandService extends IService<TbBrand> {

    /**
     * 条件查询
     *
     * @param queryWrapper
     * @return
     */
    List<TbBrand> list(QueryWrapper<TbBrand> queryWrapper);

    /**
     * 分页查询
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    PageVO<TbBrand> findByPage(Integer pageNum, Integer pageSize, BrandVO brandVO);

    /**
     * 添加商品品牌
     *
     * @param tbBrand
     */
    void save(TbBrand tbBrand);

    /**
     * 根据品牌Id查询品牌
     *
     * @param id
     * @return
     */
    TbBrand findById(Integer id);

    /**
     * 根据ID更新品牌
     *
     * @param brandVO
     */
    void updateBrand(TbBrand brandVO);

    /**
     * 批量删除
     *
     * @param ids
     */
    void delByIds(Long[] ids);

    /**
     * 获取商品类型模板中关联品牌下拉框数据
     *
     * @return
     */
    List<Map> findOptionList();

}
