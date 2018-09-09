package com.phy.bizs;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.phy.mappers.MsgsetMapper;
import com.phy.model.Msgset;

@Service
public class MsgsetBiz implements IMsgsetBiz{
    
	@Resource
	private MsgsetMapper mapper;
	@Override
	public Msgset query() {
		return mapper.select();
	}

	@Override
	public boolean update(Map<String,Object> map) {
		return mapper.update(map);
	}

}
