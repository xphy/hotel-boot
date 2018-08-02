package com.phy.bizs;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.phy.mappers.TourMapper;
import com.phy.model.Tour;


@Service
public class TourBIz implements ITourBiz{
	@Resource
	private TourMapper mapper;

	@Override
	public boolean save(Tour bean) {
		if(bean.getId()!= 0) {
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
	public Tour find(Integer id) {
		return this.mapper.selectOne(id);
	}

	@Override
	public List<Tour> query(Map<String, Object> map) {
		return this.mapper.select(map);
	}

}
