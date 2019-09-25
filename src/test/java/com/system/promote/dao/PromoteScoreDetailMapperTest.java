package com.system.promote.dao;

import com.system.promote.entity.PromoteProduct;
import com.system.promote.entity.PromoteScoreDetail;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
@MapperScan("com.system.promote.dao")
public class PromoteScoreDetailMapperTest {
    
    @Autowired
    private PromoteScoreDetailMapper promoteScoreDetailMapper;

    private PromoteScoreDetail record1 = new PromoteScoreDetail();
    @Before
    public void before(){
        record1.setScore(10);
        record1.setCreateTime(new Date());
        record1.setUpdateTime(new Date());
        record1.setId(1);
        record1.setRelateId(100);
        record1.setScoreType(1);
        record1.setUserId(1);

    }

    @Test
    public void insertSelective(){
        promoteScoreDetailMapper.insertSelective(record1);
        promoteScoreDetailMapper.deleteByPrimaryKey(1);

    }
    @Test
    public void insert(){
        promoteScoreDetailMapper.insert(record1);
        promoteScoreDetailMapper.deleteByPrimaryKey(1);
    }
    @Test
    public void selectByPrimaryKey(){
        promoteScoreDetailMapper.selectByPrimaryKey(1);
    }

    @Test
    public void updateByPrimaryKeySelective(){
        record1.setScore(33);
        promoteScoreDetailMapper.updateByPrimaryKeySelective(record1);
    }
    @Test
    public void updateByPrimaryKey(){
        record1.setScore(44);
        promoteScoreDetailMapper.updateByPrimaryKey(record1);
    }


}