package com.phy.mappers;
/**
 * @author 皮会友
 *
 */

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.phy.model.HPrice;
@Mapper
public interface HPriceMapper {
   public boolean delete(int id);
   public boolean update(HPrice bean);
   public boolean insert(HPrice bean);
   public HPrice selectOne(int id);
   public List<HPrice> select();
}
