package com.pinyougou.user.model.domain;

import java.math.BigDecimal;

import com.pinyougou.common.core.mybatis.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableName;

import java.time.LocalDateTime;

import com.baomidou.mybatisplus.annotation.TableField;

import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author xuzilou
 * @since 2019-02-01
 */
@Data
@Accessors(chain = true)
@TableName("tb_user")
@ToString(callSuper = true)
public class TbUser extends BaseEntity<TbUser> {

    private static final long serialVersionUID = 1L;

    /**
     * 用户名
     */
    private String username;
    /**
     * 密码，加密存储
     */
    private String password;
    /**
     * 注册手机号
     */
    private String phone;
    /**
     * 注册邮箱
     */
    private String email;
    /**
     * 创建时间
     */
    private LocalDateTime created;
    private LocalDateTime updated;
    /**
     * 会员来源：1:PC，2：H5，3：Android，4：IOS，5：WeChat
     */
    @TableField("source_type")
    private String sourceType;
    /**
     * 昵称
     */
    @TableField("nick_name")
    private String nickName;
    /**
     * 真实姓名
     */
    private String name;
    /**
     * 使用状态（Y正常 N非正常）
     */
    private String status;
    /**
     * 头像地址
     */
    @TableField("head_pic")
    private String headPic;
    /**
     * QQ号码
     */
    private String qq;
    /**
     * 账户余额
     */
    @TableField("account_balance")
    private BigDecimal accountBalance;
    /**
     * 手机是否验证 （0否  1是）
     */
    @TableField("is_mobile_check")
    private String isMobileCheck;
    /**
     * 邮箱是否检测（0否  1是）
     */
    @TableField("is_email_check")
    private String isEmailCheck;
    /**
     * 性别，1男，2女
     */
    private String sex;
    /**
     * 会员等级
     */
    @TableField("user_level")
    private Integer userLevel;
    /**
     * 积分
     */
    private Integer points;
    /**
     * 经验值
     */
    @TableField("experience_value")
    private Integer experienceValue;
    /**
     * 生日
     */
    private LocalDateTime birthday;
    /**
     * 最后登录时间
     */
    @TableField("last_login_time")
    private LocalDateTime lastLoginTime;


}
