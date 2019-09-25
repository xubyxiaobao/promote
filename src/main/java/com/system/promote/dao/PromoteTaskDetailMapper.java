package com.system.promote.dao;

import com.system.promote.entity.PromoteTaskDetail;

public interface PromoteTaskDetailMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PromoteTaskDetail record);

    int insertSelective(PromoteTaskDetail record);

    PromoteTaskDetail selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PromoteTaskDetail record);

    int updateByPrimaryKey(PromoteTaskDetail record);
}