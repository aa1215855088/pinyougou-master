package com.pinyougou.product.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pinyougou.product.mapper.TbItemMapper;
import com.pinyougou.product.model.domain.TbItem;
import com.pinyougou.product.service.TbItemService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 商品表 服务实现类
 * </p>
 *
 * @author xuzilou
 * @since 2019-01-13
 */
@Service
public class TbItemServiceImpl extends ServiceImpl<TbItemMapper, TbItem> implements TbItemService {
	
}
