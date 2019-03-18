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
@TableName("tb_type_template")
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class TbTypeTemplate extends BaseEntity<TbTypeTemplate> {

    private static final long serialVersionUID = 1L;

    /**
     * 模板名称
     */
    @NotBlank(groups = {Update.class, Insert.class})
    private String name;
    /**
     * 关联规格
     */
    @NotBlank(groups = {Update.class, Insert.class})
    @TableField("spec_ids")
    private String specIds;
    /**
     * 关联品牌
     */
    @NotBlank(groups = {Update.class, Insert.class})
    @TableField("brand_ids")
    private String brandIds;
    /**
     * 自定义属性
     */
    @NotBlank(groups = {Update.class, Insert.class})
    @TableField("custom_attribute_items")
    private String customAttributeItems;


}
