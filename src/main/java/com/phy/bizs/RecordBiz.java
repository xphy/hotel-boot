package com.phy.bizs;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.phy.mappers.RecordMapper;
import com.phy.model.Record;

@Service
public class RecordBiz implements IRecordBiz{
    
	@Resource
	private RecordMapper mapper;
	@Override
	public boolean save(Record bean) {
		if(bean.getId()!=0) {
			return this.mapper.update(bean);
		}else {
			return this.mapper.insert(bean);
		}
	}

	@Override
	public boolean remove(Integer id) {
		return this.mapper.delete(id);
	}

	@Override
	public Record find(Integer id) {
		return this.mapper.selectOne(id);
	}

	@Override
	public List<Record> query(Map<String, Object> map) {
		return this.mapper.selectall(map);
	}

	@Override
	public boolean checkOut(Integer id) {
		return this.mapper.checkOut(id);
	}

	

}
