package com.phy.mappers;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.phy.model.Tour;
@Mapper
public interface TourMapper {
    public boolean insert(Tour bean);
    public boolean update(Tour bean);
    public boolean delete(int id);
    public Tour selectOne(int id);
    public List<Tour> select(Map<String, Object> map);
    
}
