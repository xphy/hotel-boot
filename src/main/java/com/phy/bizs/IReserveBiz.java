package com.phy.bizs;

import java.util.List;
import java.util.Map;

import com.phy.model.Reserve;

public interface IReserveBiz {
	public boolean save(Reserve bean);
	public boolean remove(Integer id);
	public boolean checkIn(Reserve bean);
	public Reserve find(Integer id);
	public List<Reserve> query(Map<String, Object> map);
}
