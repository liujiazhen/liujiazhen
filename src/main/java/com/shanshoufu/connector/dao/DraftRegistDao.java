package com.shanshoufu.connector.dao;

import com.shanshoufu.connector.entity.model.DraftRegist;

public interface DraftRegistDao {
    int deleteByPrimaryKey(String id);

    int insert(DraftRegist record);

    int insertSelective(DraftRegist record);

    DraftRegist selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(DraftRegist record);

    int updateByPrimaryKey(DraftRegist record);
}