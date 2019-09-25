package com.system.promote.dao;

import com.system.promote.entity.PromoteScoreDetail;

public interface PromoteScoreDetailMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PromoteScoreDetail record);

    int insertSelective(PromoteScoreDetail record);

    PromoteScoreDetail selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PromoteScoreDetail record);

    int updateByPrimaryKey(PromoteScoreDetail record);
}