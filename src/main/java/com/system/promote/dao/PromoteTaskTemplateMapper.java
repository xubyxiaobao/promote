package com.system.promote.dao;

import com.system.promote.entity.PromoteTaskTemplate;

public interface PromoteTaskTemplateMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PromoteTaskTemplate record);

    int insertSelective(PromoteTaskTemplate record);

    PromoteTaskTemplate selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PromoteTaskTemplate record);

    int updateByPrimaryKey(PromoteTaskTemplate record);
}