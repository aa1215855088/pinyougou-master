package com.pinyougou.user.service;

import com.pinyougou.user.model.domain.TbUser;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author xuzilou
 * @since 2019-02-01
 */
public interface TbUserService extends IService<TbUser> {
    /**
     * 根据用户名查询用户
     *
     * @param username
     * @return
     */
    TbUser findByLoginName(String username);
}
