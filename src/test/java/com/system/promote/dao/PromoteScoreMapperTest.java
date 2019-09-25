package com.system.promote.dao;

import com.system.promote.entity.PromoteProduct;
import com.system.promote.entity.PromoteScore;
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
public class PromoteScoreMapperTest {
    @Autowired
    private PromoteScoreMapper promoteScoreMapper;

    private PromoteScore record =  new PromoteScore();

    @Before
    public void before(){
        record.setId(1);
        record.setScore(2);
        record.setCreateTime(new Date());
        record.setUpdateTime(new Date());
        record.setUserId(1);
    }
    @Test
    public void insertSelective(){
        promoteScoreMapper.insertSelective(record);
        promoteScoreMapper.deleteByPrimaryKey(1);

    }
    @Test
    public void insert(){
        promoteScoreMapper.insert(record);
        promoteScoreMapper.deleteByPrimaryKey(1);

    }
    @Test
    public void selectByPrimaryKey(){
       promoteScoreMapper.selectByPrimaryKey(1);
    }

    @Test
    public void updateByPrimaryKeySelective(){
        record.setScore(100);
        promoteScoreMapper.updateByPrimaryKeySelective(record);
    }
    @Test
    public void updateByPrimaryKey(){
        record.setScore(200);
        promoteScoreMapper.updateByPrimaryKey(record);
    }


}