package com.phy.bizs;

import java.sql.SQLException;
import java.util.List;

import com.phy.model.User;

public interface IUserBiz {
	public boolean save(User bean,List<Integer> pids) throws SQLException;
	public boolean remove(Integer id)throws SQLException;
	public boolean updatepwd(User bean);
	public User find(Integer id);
	public User login(User bean);
	public List<User> query();
}
