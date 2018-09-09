package com.phy.mappers;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.phy.model.Power;

@Mapper
public interface PowerMapper {
	public boolean insert(Power bean);
	public boolean delete(Integer id);
	public boolean update(Power bean);
	public Power selectOne(Integer id);
	public boolean updateXh(Map<String,Integer> map);
	public List<Power> select1();
	public List<Power> select2();
}
