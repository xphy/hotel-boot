package com.phy.model;

import java.util.List;

/**
 * 
 * @author 皮会友
 *
 */
public class User {
   private Integer uid;
   private String uname;
   private String password;
   private Integer status;
   private List<Power> powers;
   
   
   
   
   
	public List<Power> getPowers() {
		return powers;
	}
	public void setPowers(List<Power> powers) {
		this.powers = powers;
	}
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
   
   
}
