package com.phy.control;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.phy.bizs.IUserBiz;
import com.phy.model.User;
import com.phy.util.MD5;

@RestController
@RequestMapping("/user/")
public class UseCtrl {
	@Resource
    private IUserBiz biz;
	private MD5 md5 = new MD5();
	
	//登陆
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public User login(String uname,String password){
		User bean = new User();
		bean.setUname(uname);
		bean.setPassword(md5.md5crypt(password));
		return biz.login(bean);
	}
	//保存
	@RequestMapping("save")
	public boolean save(HttpServletRequest request) {
		String uid = request.getParameter("uid");
		String uname = request.getParameter("uname");
		String password = request.getParameter("password");
		String status = request.getParameter("status");
		String pids = request.getParameter("pids");
		List<Integer> list = new ArrayList<>();
		if(pids!=null && pids.length()>0){
			String[] ids = pids.split(",");
			for(String s : ids){
				list.add(Integer.parseInt(s));
			}
		}
		
		User bean = new User();
		bean.setUname(uname);
		bean.setPassword(md5.md5crypt(password));
		bean.setStatus(Integer.parseInt(status));
		if(uid!=null && !"".equals(uid)){
			bean.setUid(Integer.parseInt(uid));
		}
		//保存
		boolean flag =false;
		try {
		   flag = this.biz.save(bean, list);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}
	@RequestMapping("query")
	public List<User> query(){
		return this.biz.query();
	}
	@RequestMapping("/find")
	public User find(Integer uid){
		return  biz.find(uid);
	}
	@RequestMapping("remove/{uid}")
	public boolean remove(@PathVariable("uid") int uid) {
		boolean flag =false;
		try {
			flag =this.biz.remove(uid);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}
	@RequestMapping("updatepwd")
	public boolean updatepwd(HttpServletRequest request) {
		String uname = request.getParameter("uname");
		String uid = request.getParameter("uid");
		String ypwd1 = request.getParameter("ypwd1");
		String ypwd2 = request.getParameter("ypwd2");
		String xpwd = request.getParameter("xpwd");
		String status = request.getParameter("status");
		boolean flag = false;
		//new 一个user 对象
		User bean = new User();
		if(uid!=null&&!"".equals(uid)) {
			bean.setUid(Integer.parseInt(uid));
		}
		if(uname!=null&&!"".equals(uname)) {
			bean.setUname(uname);
		}
		if(status!=null&&!"".equals(status)) {
			bean.setStatus(Integer.parseInt(status));
		}
		if(xpwd!=null&&!"".equals(xpwd)) {
			bean.setPassword(md5.md5crypt(xpwd));
		}
		//保证原密码输入正确
		if(ypwd2!=null && !ypwd2.equals("")) {
			String md5ypwd2 = md5.md5crypt(ypwd2);
			if(ypwd1!=null && !ypwd1.equals("")) {
				if(!ypwd1.equals(md5ypwd2)) {
					return false;
				}else {
				   flag= this.biz.updatepwd(bean);
				}
			}
		}
		return flag;
	}
}
