package com.system.promote.dao;

import com.system.promote.entity.PromoteProduct;
import com.system.promote.entity.PromoteTaskDetail;
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
public class PromoteTaskDetailMapperTest {
    @Autowired
    private PromoteTaskDetailMapper promoteTaskDetailMapper;

    private  PromoteTaskDetail record  = new PromoteTaskDetail();
    @Before
    public void before(){
        record.setId(1);
        record.setScore(1);
        record.setAcceptUser(1);
        record.setCreateTime(new Date());
        record.setCreateUser(2);
        record.setEndTime(new Date());
        record.setStartTime(new Date());
        record.setStatus(1);
        record.setTaskId(33);
    }
    @Test
    public void insertSelective(){
        promoteTaskDetailMapper.insertSelective(record);
    }
    @Test
    public void insert(){
        promoteTaskDetailMapper.insert(record);
    }
    @Test
    public void selectByPrimaryKey(){
        promoteTaskDetailMapper.selectByPrimaryKey(1);
    }

    @Test
    public void updateByPrimaryKeySelective(){
        record.setScore(100);
        promoteTaskDetailMapper.updateByPrimaryKeySelective(record);
    }
    @Test
    public void updateByPrimaryKey(){
        record.setScore(101);
        promoteTaskDetailMapper.updateByPrimaryKey(record);
    }

    @Test
    public void deleteByPrimaryKey(){
        promoteTaskDetailMapper.deleteByPrimaryKey(1);
    }
}