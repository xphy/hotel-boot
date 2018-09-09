package com.phy.mappers;

import org.apache.ibatis.annotations.Mapper;

import com.phy.model.Rule;

@Mapper
public interface RuleMapper {
	public boolean insert(Rule bean);
	public boolean delete(Integer uid);
}
