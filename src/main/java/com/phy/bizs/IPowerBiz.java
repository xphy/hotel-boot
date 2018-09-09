package com.phy.bizs;

import java.util.List;
import java.util.Map;

import com.phy.model.Power;

public interface IPowerBiz {
	public boolean save(Power bean);
	public boolean saveXh(Map<String,Integer> map);
	public boolean remove(Integer id);
	public Power find(Integer id);
	public List<Power> query1();
	public List<Power> query2();
}
