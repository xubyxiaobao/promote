package com.system.promote.dao;

import com.system.promote.entity.PromoteProduct;

public interface PromoteProductMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PromoteProduct record);

    int insertSelective(PromoteProduct record);

    PromoteProduct selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PromoteProduct record);

    int updateByPrimaryKey(PromoteProduct record);
}