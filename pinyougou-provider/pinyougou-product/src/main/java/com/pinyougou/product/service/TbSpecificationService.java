package com.pinyougou.product.service;

import com.pinyougou.common.base.vo.PageVO;
import com.pinyougou.product.model.domain.TbSpecification;
import com.baomidou.mybatisplus.extension.service.IService;

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
public interface TbSpecificationService extends IService<TbSpecification> {

    /**
     * 对搜索结果进行分页查询
     *
     * @param page     页数
     * @param rows     行数
     * @param specName 搜索条件
     * @return
     */
    PageVO<TbSpecification> findPageAndSearch(Integer page, Integer rows, String specName);

    /**
     * 添加商品规格
     *
     * @param tbSpecification
     */
    void save(TbSpecification tbSpecification);

    /**
     * 跟据商品规格ID查询商品规格
     *
     * @param id
     * @return
     */
    TbSpecification findById(Long id);


    /**
     * 修改规格
     *
     * @param tbSpecification
     */
    void updateSpec(TbSpecification tbSpecification);

    /**
     * 批量删除商品规格
     * @param ids
     */
    void del(Long[] ids);

    /**
     * 获取商品类型模板中关联规格下拉框数据
     * @return
     */
    List<Map> findOptionList();
}
