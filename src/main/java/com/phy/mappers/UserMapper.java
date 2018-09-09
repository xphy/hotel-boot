package com.phy.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.phy.model.User;

@Mapper
public interface  UserMapper {
	public boolean insert(User bean);
	public boolean delete(Integer uid);
	public boolean update(User bean);
	public User selectOne(Integer uid);
	public User login(User bean);
	
	public List<User> select();
}
