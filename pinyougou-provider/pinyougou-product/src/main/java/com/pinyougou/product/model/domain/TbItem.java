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
 * 商品表
 * </p>
 *
 * @author theodo
 * @since 2019-01-12
 */
@Data
@Accessors(chain = true)
@TableName("tb_item")
public class TbItem extends BaseEntity<TbItem> {

    private static final long serialVersionUID = 1L;


    /**
     * 商品标题
     */
	private String title;
    /**
     * 商品卖点
     */
	@TableField("sell_point")
	private String sellPoint;
    /**
     * 商品价格，单位为：元
     */
	private BigDecimal price;
	@TableField("stock_count")
	private Integer stockCount;
    /**
     * 库存数量
     */
	private Integer num;
    /**
     * 商品条形码
     */
	private String barcode;
    /**
     * 商品图片
     */
	private String image;
    /**
     * 所属类目，叶子类目
     */
	private Long categoryId;
    /**
     * 商品状态，1-正常，2-下架，3-删除
     */
	private String status;
    /**
     * 创建时间
     */
	@TableField("create_time")
	private LocalDateTime createTime;
    /**
     * 更新时间
     */
	@TableField("update_time")
	private LocalDateTime updateTime;
	@TableField("item_sn")
	private String itemSn;
	@TableField("cost_pirce")
	private BigDecimal costPirce;
	@TableField("market_price")
	private BigDecimal marketPrice;
	@TableField("is_default")
	private String isDefault;
	@TableField("goods_id")
	private Long goodsId;
	@TableField("seller_id")
	private String sellerId;
	@TableField("cart_thumbnail")
	private String cartThumbnail;
	private String category;
	private String brand;
	private String spec;
	private String seller;



}
