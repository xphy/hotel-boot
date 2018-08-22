package com.phy.mappers;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.phy.model.*;
@Mapper
public interface HouseMapper{
	public House selectOne(int id);
	public List<House> select(Map<String,Object> map);
	public List<House> selectByDate(Map<String,Object> map);
	public List<StateBean> selectTu();
	public boolean insert(House bean);
	public boolean delete(int id);
	public boolean update(House bean);
	public boolean updateImg(House bean);
	public boolean state(House bean);
}