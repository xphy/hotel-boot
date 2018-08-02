package com.phy.mappers;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.phy.model.*;
@Mapper
public interface HouseMapper{
	public boolean insert(House bean);
	public House selectOne(int id);
	public boolean delete(int id);
	public List<House> select(Map<String,Object> map);
	public boolean update(House bean);
	public boolean updateImg(House bean);
	public boolean state(House bean);
}