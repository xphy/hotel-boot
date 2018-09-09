package com.phy.model;
/**
 * 
 * @author 皮会友
 *
 */

public class Power {
	private Integer id;
	private String name;
	private String fname;
	private String url;
	private Integer pid;
	private String icon;
	private Integer status;
	private Integer xh;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Integer getXh() {
		return xh;
	}
	public void setXh(Integer xh) {
		this.xh = xh;
	}
	public String getFname() {
		if(fname==null){
			return "无";
		}else{
			return fname;
		}
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	
}
