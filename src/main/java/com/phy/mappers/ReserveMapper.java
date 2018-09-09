package com.phy.mappers;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.phy.model.Reserve;

@Mapper
public interface ReserveMapper {
	public boolean insert(Reserve bean);
	public boolean delete(Integer id);
	public boolean update(Reserve bean);
	public List<Reserve> selectall(Map<String, Object> map);
	public Reserve selectOne(Integer id);
}
