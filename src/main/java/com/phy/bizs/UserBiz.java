package com.phy.bizs;


import java.sql.*;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.phy.mappers.RuleMapper;
import com.phy.mappers.UserMapper;
import com.phy.model.Rule;
import com.phy.model.User;

@Service
public class UserBiz implements IUserBiz {
	
	@Resource
	private UserMapper umapper;
	@Resource
	private RuleMapper rmapper;

	@Override
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor = SQLException.class)
	public boolean save(User bean, List<Integer> pids) throws SQLException {
        boolean flag =true;
		if(bean.getUid()!=0) {
			int uid = bean.getUid();
        	if(this.umapper.update(bean)) {
        		if(this.rmapper.delete(uid)) {
        			for(int pid : pids){
            		    Rule ru =new Rule(uid,pid);
            			if(!this.rmapper.insert(ru)) {
            				throw new SQLException("用户权限保存失败");
            			}
            	   }
        		}
        	}else {
        		flag = false;
        	}
        }else {
        	boolean flag1  = this.umapper.insert(bean);
        	int uid = bean.getUid();
        	if(flag1) {
        		for(int pid : pids){
        			Rule ru =new Rule(uid,pid);
        			if(!this.rmapper.insert(ru)) {
        				throw new SQLException("用户权限保存失败");
        			}
        		}
        	}else {
        		flag =false;
        	}
        }
		return flag;
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor = SQLException.class)
	public boolean remove(Integer uid) throws SQLException {
		boolean flag =true;
		 if(this.umapper.delete(uid)) {
			 boolean delete = this.rmapper.delete(uid);
			 if(!delete) {
				 throw new SQLException("用户权限删除失败");
			 }
		 }else {
			 flag =false;
		 }
		 return flag;
	}

	@Override
	public User login(User bean){
		return umapper.login(bean);
	}

	@Override
	public List<User> query() {
		return umapper.select();
	}

	@Override
	public User find(Integer uid) {
		return umapper.selectOne(uid);
	}

	@Override
	public boolean updatepwd(User bean) {
		return umapper.update(bean);
	}
	

}
