package com.phy.bizs;
import java.util.*;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.phy.mappers.*;
import com.phy.model.*;
@Service
public class HouseBiz implements IHouseBiz{
    @Resource
	private HouseMapper mapper;

	@Override
	public boolean save(House house) {
		if(house.getId()!=0) {
			return this.mapper.update(house);
		}else {
			return this.mapper.insert(house);
			
		}
	}

	@Override
	public boolean remove(Integer id) {
		boolean flag = false;
		try{
			flag = this.mapper.delete(id);
		}catch(Exception ex){
			//log.error(ex.getMessage());
		}
		return flag;
	}

	@Override
	public House find(Integer id) {
		return this.mapper.selectOne(id);
	}

	@Override
	public List<House> query(Map<String,Object> map) {
		return this.mapper.select(map);
	}

	@Override
	public boolean state(Integer id, Integer status) {
		House bean = new House();
		bean.setId(id);
		bean.setStatus(status);
		return this.mapper.state(bean);
	}

	@Override
	public boolean updateImg(House bean) {
		return this.mapper.updateImg(bean);
	}


}
