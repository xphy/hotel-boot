package com.phy.bizs;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.phy.mappers.HPriceMapper;
import com.phy.model.HPrice;

@Service
public class HPriceBiz implements IHPriceBiz {
	
	@Resource
	private HPriceMapper mapper;

	@Override
	public boolean save(HPrice bean) {
		if(bean.getId()!=null) {
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
	public List<HPrice> query() {
		return this.mapper.select();
	}

	@Override
	public HPrice find(Integer id) {
		return this.mapper.selectOne(id);
	}

}
