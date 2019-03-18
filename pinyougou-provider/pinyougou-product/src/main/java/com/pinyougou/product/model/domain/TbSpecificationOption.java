package com.pinyougou.product.model.domain;

import com.pinyougou.common.core.mybatis.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableField;


import com.pinyougou.common.util.validators.Insert;
import com.pinyougou.common.util.validators.Update;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

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
@TableName("tb_specification_option")
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class TbSpecificationOption extends BaseEntity<TbSpecificationOption> {

    private static final long serialVersionUID = 1L;


    /**
     * 规格项名称
     */
    @NotBlank(groups = {Update.class, Insert.class})
    @TableField("option_name")
    private String optionName;
    /**
     * 规格ID
     */
    @Min(1)
    @NotNull(groups = {Update.class, Insert.class})
    @TableField("spec_id")
    private Long specId;
    /**
     * 排序值
     */
    @NotNull(groups = {Update.class, Insert.class})
    private Integer orders;


}
