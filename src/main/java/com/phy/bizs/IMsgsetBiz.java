package com.phy.bizs;

import java.util.Map;

import com.phy.model.Msgset;

public interface IMsgsetBiz {
	public Msgset query();
	public boolean update(Map<String,Object> map);

}
