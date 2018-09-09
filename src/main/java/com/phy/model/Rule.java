package com.phy.model;
/**
 * 
 * @author 皮会友
 *
 */

public class Rule {
    private Integer uid;
    private Integer pid;
    
    public Rule() {
    	
    }
    public Rule(Integer uid,Integer pid) {
    	this.uid =uid;
    	this.pid =pid;
    }
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
    
    
    
}
