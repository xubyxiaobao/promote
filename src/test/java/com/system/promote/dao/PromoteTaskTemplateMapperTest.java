package com.system.promote.dao;

import com.system.promote.entity.PromoteProduct;
import com.system.promote.entity.PromoteTaskTemplate;
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
public class PromoteTaskTemplateMapperTest {
    @Autowired
    private PromoteTaskTemplateMapper promoteTaskTemplateMapper;

    private PromoteTaskTemplate record = new PromoteTaskTemplate();
    @Before
    public void before(){
        record.setAcceptTime(new Date());
        record.setAcceptUser(1);
        record.setCreateTime(new Date());
        record.setCreateUser(2);
        record.setDescription("呵呵");
        record.setId(1);
        record.setIntervalUnit("222");
        record.setScore(2);
        record.setStatus(1);
        record.setTimes(2);
    }

    @Test
    public void insertSelective(){
        promoteTaskTemplateMapper.insertSelective(record);
    }
    @Test
    public void insert(){
        promoteTaskTemplateMapper.insert(record);
        promoteTaskTemplateMapper.deleteByPrimaryKey(1);
    }
    @Test
    public void selectByPrimaryKey(){
        promoteTaskTemplateMapper.deleteByPrimaryKey(1);
        promoteTaskTemplateMapper.selectByPrimaryKey(1);
    }

    @Test
    public void updateByPrimaryKeySelective(){
        record.setScore(100);
        promoteTaskTemplateMapper.updateByPrimaryKeySelective(record);
    }
    @Test
    public void updateByPrimaryKey(){
        record.setScore(200);
        promoteTaskTemplateMapper.updateByPrimaryKey(record);
    }

}