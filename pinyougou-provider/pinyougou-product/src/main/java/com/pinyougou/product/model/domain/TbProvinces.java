package com.pinyougou.product.model.domain;

import com.pinyougou.common.core.mybatis.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableName;


import lombok.Data;
import lombok.experimental.Accessors;

/**
 * <p>
 * 省份信息表
 * </p>
 *
 * @author theodo
 * @since 2019-01-12
 */
@Data
@Accessors(chain = true)
@TableName("tb_provinces")
public class TbProvinces extends BaseEntity<TbProvinces> {

    private static final long serialVersionUID = 1L;

    /**
     * 省份ID
     */
	private String provinceid;
    /**
     * 省份名称
     */
	private String province;



}
