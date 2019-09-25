package com.system.promote.dao;

import com.system.promote.entity.PromoteUser;

public interface PromoteUserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PromoteUser record);


    PromoteUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PromoteUser record);

    int updateByPrimaryKey(PromoteUser record);
}