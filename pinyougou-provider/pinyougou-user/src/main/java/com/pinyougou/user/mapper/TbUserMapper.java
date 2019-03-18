package com.pinyougou.user.mapper;

import com.pinyougou.user.model.domain.TbUser;
import com.pinyougou.common.core.mybatis.MyMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
  * 用户表 Mapper 接口
 * </p>
 *
 * @author xuzilou
 * @since 2019-02-01
 */
@Mapper
public interface TbUserMapper extends MyMapper<TbUser> {

}