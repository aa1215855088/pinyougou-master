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
import org.hibernate.validator.constraints.Length;

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
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@TableName("tb_brand")
public class TbBrand extends BaseEntity<TbBrand> {

    private static final long serialVersionUID = 1L;

    public static final Integer PAGE_NUM = 1;

    public static final Integer PAGE_SIZE = 20;
    /**
     * 品牌名称
     */
    @NotBlank(groups = {Update.class, Insert.class})
    private String name;
    /**
     * 品牌首字母
     */
    @NotBlank(groups = {Update.class, Insert.class})
    @Length(max = 1, groups = {Update.class, Insert.class})
    @TableField("first_char")
    private String firstChar;


}
