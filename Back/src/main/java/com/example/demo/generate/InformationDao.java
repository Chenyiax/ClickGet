package com.example.demo.generate;

import com.example.demo.generate.Information;

public interface InformationDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Information record);

    int insertSelective(Information record);

    Information selectByPrimaryKey(Integer id);

    Information selectByUser(String username);

    int updateByPrimaryKeySelective(Information record);

    int updateByUsername(Information record);

    int updateByPrimaryKey(Information record);
}