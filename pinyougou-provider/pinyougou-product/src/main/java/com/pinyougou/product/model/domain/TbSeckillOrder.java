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
@TableName("tb_seckill_order")
public class TbSeckillOrder extends BaseEntity<TbSeckillOrder> {

    private static final long serialVersionUID = 1L;


    /**
     * 秒杀商品ID
     */
	@TableField("seckill_id")
	private Long seckillId;
    /**
     * 支付金额
     */
	private BigDecimal money;
    /**
     * 用户
     */
	@TableField("user_id")
	private String userId;
    /**
     * 商家
     */
	@TableField("seller_id")
	private String sellerId;
    /**
     * 创建时间
     */
	@TableField("create_time")
	private LocalDateTime createTime;
    /**
     * 支付时间
     */
	@TableField("pay_time")
	private LocalDateTime payTime;
    /**
     * 状态
     */
	private String status;
    /**
     * 收货人地址
     */
	@TableField("receiver_address")
	private String receiverAddress;
    /**
     * 收货人电话
     */
	@TableField("receiver_mobile")
	private String receiverMobile;
    /**
     * 收货人
     */
	private String receiver;
    /**
     * 交易流水
     */
	@TableField("transaction_id")
	private String transactionId;


}
