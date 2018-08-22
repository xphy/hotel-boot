package com.phy.bizs;
import com.phy.model.*;
import java.util.List;
import java.util.Map;
public interface IHouseBiz{
	public boolean save(House house);
	public boolean remove(Integer id);
	public House find(Integer id);
	public boolean updateImg(House bean);
	public boolean state(Integer id,Integer status); 
	public List<House> query(Map<String,Object> map);
	public List<House> queryHouses(Map<String,Object> map);
	public List<StateBean> queryBean();
}