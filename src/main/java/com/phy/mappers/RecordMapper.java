package com.phy.mappers;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.phy.model.Record;

@Mapper
public interface RecordMapper {
	public boolean insert(Record bean);
	public boolean checkOut(Integer id);
	public boolean delete(Integer id);
	public boolean update(Record bean);
	public List<Record> selectall(Map<String, Object> map);
	public Record selectOne(Integer id);
}
