package com.phy.bizs;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.phy.mappers.PowerMapper;
import com.phy.model.Power;

@Service
public class PowerBiz implements IPowerBiz{
	@Resource
    private PowerMapper mapper;
	@Override
	public boolean save(Power bean) {
		if(bean.getId()!= 0){
			return mapper.update(bean);
		}else{
			return mapper.insert(bean);
		}
	}

	@Override
	public boolean saveXh(Map<String, Integer> map) {
		return mapper.updateXh(map);
	}

	@Override
	public boolean remove(Integer id) {
		return mapper.delete(id);
	}

	@Override
	public Power find(Integer id) {
		return mapper.selectOne(id);
	}

	@Override
	public List<Power> query1() {
		return mapper.select1();
	}

	@Override
	public List<Power> query2() {
		return mapper.select2();
	}

}
