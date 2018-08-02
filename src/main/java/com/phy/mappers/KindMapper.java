package com.phy.mappers;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;


import com.phy.model.*;
@Mapper
public interface KindMapper{
	public boolean insert(Kind bean);
	public boolean delete(Integer id);
	public boolean update(Kind bean);
	public List<Kind> select1();
	public List<Kind> select2();
	public Kind selectOne(Integer id);
}