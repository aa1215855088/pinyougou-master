package com.pinyougou.product.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.pinyougou.product.model.domain.TbBrand;
import com.pinyougou.product.model.vo.BrandVO;
import com.pinyougou.product.service.TbBrandService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Map;

/**
 * ┏┓　　　┏┓
 * ┏┛┻━━━┛┻┓
 * ┃　　　　　　　┃
 * ┃　　　━　　　┃
 * ┃　┳┛　┗┳　┃
 * ┃　　　　　　　┃
 * ┃　　　┻　　　┃
 * ┃　　　　　　　┃
 * ┗━┓　　　┏━┛
 * 　　┃　　　┃神兽保佑
 * 　　┃　　　┃代码无BUG！
 * 　　┃　　　┗━━━┓
 * 　　┃　　　　　　　┣┓
 * 　　┃　　　　　　　┏┛
 * 　　┗┓┓┏━┳┓┏┛
 * 　　　┃┫┫　┃┫┫
 * 　　　┗┻┛　┗┻┛
 *
 * @program: pinyougou-master
 * @description:
 * @author: 徐子楼
 * @create: 2019-01-13 16:25
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class TbBrandServiceImplTest {
    @Autowired
    private TbBrandService brandServicel;


    @Test
    public void list() {
        QueryWrapper<TbBrand> queryWrapper = new QueryWrapper<>();
        this.brandServicel.list(queryWrapper).stream().forEach(System.out::println);
    }

    @Test
    public void listPage() {
        BrandVO brandVO = new BrandVO();
        brandVO.setName("诺基亚");
        brandVO.setFirstChar("N");
//        this.brandServicel.findByPage(1, 10).getRows().stream().forEach(System.out::println);
        this.brandServicel.findByPage(1, 10, brandVO).getRows().stream().forEach(System.out::println);
    }


    @Test
    public void save() {
        TbBrand tbBrand = new TbBrand();
        tbBrand.setName("123");
        tbBrand.setFirstChar(null);
        this.brandServicel.save(tbBrand);
    }

    @Test
    public void findOptionList(){
        List<Map> optionList = this.brandServicel.findOptionList();
        for (Map map : optionList) {
            System.out.println(map);
        }
    }
    @Test
    public void test(){
        System.out.println(10>>1);
    }
}