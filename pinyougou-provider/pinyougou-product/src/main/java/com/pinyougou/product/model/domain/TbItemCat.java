package com.pinyougou.product.model.domain;

import com.pinyougou.common.core.mybatis.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableField;


import lombok.Data;
import lombok.experimental.Accessors;

/**
 * <p>
 * 商品类目
 * </p>
 *
 * @author theodo
 * @since 2019-01-12
 */
@Data
@Accessors(chain = true)
@TableName("tb_item_cat")
public class TbItemCat extends BaseEntity<TbItemCat> {

    private static final long serialVersionUID = 1L;


    /**
     * 父类目ID=0时，代表的是一级的类目
     */
	@TableField("parent_id")
	private Long parentId;
    /**
     * 类目名称
     */
	private String name;
    /**
     * 类型id
     */
	@TableField("type_id")
	private Long typeId;


}
