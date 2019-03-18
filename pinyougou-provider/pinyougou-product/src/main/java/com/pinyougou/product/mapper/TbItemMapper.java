package com.pinyougou.product.mapper;

import com.pinyougou.product.model.domain.TbItem;
import com.pinyougou.common.core.mybatis.MyMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
  * 商品表 Mapper 接口
 * </p>
 *
 * @author theodo
 * @since 2019-01-12
 */
@Mapper
public interface TbItemMapper extends MyMapper<TbItem> {

}