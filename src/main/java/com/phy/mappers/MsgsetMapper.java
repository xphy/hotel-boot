package com.phy.mappers;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.phy.model.Msgset;

@Mapper
public interface MsgsetMapper {
     public Msgset select();
     public boolean update(Map<String,Object> map);
}
