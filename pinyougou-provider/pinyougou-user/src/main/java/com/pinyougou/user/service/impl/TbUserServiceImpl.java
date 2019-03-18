package com.pinyougou.user.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.pinyougou.user.model.domain.TbUser;
import com.pinyougou.user.mapper.TbUserMapper;
import com.pinyougou.user.service.TbUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author xuzilou
 * @since 2019-02-01
 */
@Service
@Transactional
public class TbUserServiceImpl extends ServiceImpl<TbUserMapper, TbUser> implements TbUserService {

    @Override
    public TbUser findByLoginName(String username) {
        return this.baseMapper.selectOne(new QueryWrapper<TbUser>().eq(StrUtil.isNotBlank(username), "username",
                username));
    }
}
