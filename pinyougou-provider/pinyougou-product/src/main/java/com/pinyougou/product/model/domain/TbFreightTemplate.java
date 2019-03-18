package com.pinyougou.product.model.domain;

import java.math.BigDecimal;
import com.pinyougou.common.core.mybatis.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableName;

import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;


import lombok.Data;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author theodo
 * @since 2019-01-12
 */
@Data
@Accessors(chain = true)
@TableName("tb_freight_template")
public class TbFreightTemplate extends BaseEntity<TbFreightTemplate> {

    private static final long serialVersionUID = 1L;

    /**
     * 商家ID
     */
	@TableField("seller_id")
	private String sellerId;
    /**
     * 是否默认   （‘Y’是   'N'否）
     */
	@TableField("is_default")
	private String isDefault;
    /**
     * 模版名称
     */
	private String name;
    /**
     * 发货时间（1:12h  2:24h  3:48h  4:72h  5:7d 6:15d ）
     */
	@TableField("send_time_type")
	private String sendTimeType;
    /**
     * 统一价格
     */
	private BigDecimal price;
    /**
     * 创建时间
     */
	@TableField("create_time")
	private LocalDateTime createTime;



}
