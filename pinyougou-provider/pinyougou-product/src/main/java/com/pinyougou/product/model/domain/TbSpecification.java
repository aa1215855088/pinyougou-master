package com.pinyougou.product.model.domain;

import java.util.List;

import com.pinyougou.common.core.mybatis.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableField;


import com.pinyougou.common.util.validators.Insert;
import com.pinyougou.common.util.validators.Update;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;

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
@TableName("tb_specification")
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class TbSpecification extends BaseEntity<TbSpecification> {

    private static final long serialVersionUID = 1L;

    public static final Integer PAGE_NUM = 1;

    public static final Integer PAGE_SIZE = 20;

    /**
     * 名称
     */
    @NotBlank(groups = {Update.class, Insert.class})
    @TableField("spec_name")
    private String specName;


    @TableField(exist = false)
    private List<TbSpecificationOption> specificationOptionList;
}
