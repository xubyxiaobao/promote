package com.system.promote.dao;

import com.system.promote.entity.PromoteScore;

public interface PromoteScoreMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PromoteScore record);

    int insertSelective(PromoteScore record);

    PromoteScore selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PromoteScore record);

    int updateByPrimaryKey(PromoteScore record);
}