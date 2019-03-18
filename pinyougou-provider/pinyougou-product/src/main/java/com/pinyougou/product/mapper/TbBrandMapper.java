package com.pinyougou.product.mapper;

import com.pinyougou.product.model.domain.TbBrand;
import com.pinyougou.common.core.mybatis.MyMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * <p>
  *  Mapper 接口
 * </p>
 *
 * @author theodo
 * @since 2019-01-12
 */
@Mapper
public interface TbBrandMapper extends MyMapper<TbBrand> {

    List<Map> findOptionList();
}