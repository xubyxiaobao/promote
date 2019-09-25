package com.system.promote.dao;

import com.system.promote.entity.PromoteProduct;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

import java.util.Date;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@MapperScan("com.system.promote.dao")
public class PromoteProductMapperTest {

    @Autowired
    private PromoteProductMapper promoteProductMapper;

    private  PromoteProduct product1 = new PromoteProduct();
    private  PromoteProduct product2 = new PromoteProduct();

    @Before
    public void before(){
        product1.setName("测试商品-1");
        product1.setCreateUser(1);
        product1.setScore(5);
        product1.setId(1);
        product1.setCreateTime(new Date());
        product2.setName("测试商品-2");
        product2.setCreateUser(2);
        product2.setScore(10);
        product2.setId(2);
        product2.setCreateTime(new Date());
        product2.setUpdateTime(new Date());

    }

    @Test
    public void insertSelective(){
        promoteProductMapper.insertSelective(product1);
    }
    @Test
    public void insert(){
        promoteProductMapper.insert(product2);
    }
    @Test
    public void selectByPrimaryKey(){
        PromoteProduct promoteProduct = promoteProductMapper.selectByPrimaryKey(1);
    }

    @Test
    public void updateByPrimaryKeySelective(){
        product1.setName("测试商品-1-update");
        promoteProductMapper.updateByPrimaryKeySelective(product1);
    }
    @Test
    public void updateByPrimaryKey(){
        product1.setName("测试商品-1-updateAgain");
        promoteProductMapper.updateByPrimaryKey(product1);
    }

    @Test
    public void deleteByPrimaryKey(){
        promoteProductMapper.deleteByPrimaryKey(1);
        promoteProductMapper.deleteByPrimaryKey(2);
    }
}