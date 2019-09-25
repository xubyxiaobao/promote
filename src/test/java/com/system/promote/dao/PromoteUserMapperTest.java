package com.system.promote.dao;

import com.system.promote.entity.PromoteProduct;
import com.system.promote.entity.PromoteUser;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@MapperScan("com.system.promote.dao")
public class PromoteUserMapperTest {
    @Autowired
    private PromoteUserMapper promoteUserMapper;


    private PromoteUser record = new PromoteUser();
    @Before
    public void before(){
        record.setId(1);
        record.setName("helloWorld");
    }

    @Test
    public void insert(){
        promoteUserMapper.insert(record);
    }
    @Test
    public void selectByPrimaryKey(){ promoteUserMapper.selectByPrimaryKey(1);
    }

    @Test
    public void updateByPrimaryKeySelective(){
        record.setName("测试商品-1-update");
        promoteUserMapper.updateByPrimaryKeySelective(record);
    }
    @Test
    public void updateByPrimaryKey(){
        record.setName("测试商品-1-updateAgain");
        promoteUserMapper.updateByPrimaryKey(record);
    }

    @Test
    public void deleteByPrimaryKey(){
        promoteUserMapper.deleteByPrimaryKey(1);
    }
}