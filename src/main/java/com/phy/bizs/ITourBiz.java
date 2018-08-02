package com.phy.bizs;

import java.util.List;
import java.util.Map;

import com.phy.model.Tour;

public interface ITourBiz {
   public boolean save(Tour bean);
   public boolean remove(Integer id);
   public Tour find(Integer id);
   public List<Tour> query(Map<String,Object> map);
}
