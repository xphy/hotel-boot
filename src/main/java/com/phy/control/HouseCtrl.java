package com.phy.control;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;


import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.phy.bizs.IHouseBiz;
import com.phy.model.House;
import com.phy.util.UpLoad;

@RestController
@RequestMapping("/house/")
public class HouseCtrl {
	@Resource
    private IHouseBiz biz;
	@RequestMapping("query")
	public Map<String,Object> query(HttpServletRequest request){
		//查询参数
		
		String k = request.getParameter("kid");
		String b = request.getParameter("beds");
		Map<String,Object> map =new HashMap<>();
		if(k!=null&&!k.equals("")) {
			map.put("kid", Integer.parseInt(k));
		}
		if(b!=null&&!b.equals("")) {
			map.put("beds",Integer.parseInt(b));
		}
		//分页处理
		int page = 1;
	    int rows = 10;
		String p = request.getParameter("page");
		if(p!=null && !p.equals("")){
			page = Integer.parseInt(p);
		}
		String r = request.getParameter("rows");
		if(r!=null && !r.equals("")){
			rows = Integer.parseInt(r);
		}
		
	    //定义从查哪一页，从哪查起
		PageHelper.startPage(page, rows);
		List<House> list = this.biz.query(map);
		//强制转化为page
		Page pg = (Page)list;
		//获得总页码数
		int pages = pg.getPages();
		//封装一个集合
		Map<String,Object> house =new HashMap<>();
		house.put("list",list);
		house.put("pages",pages);
		house.put("page", page);
		//返回给前端
		System.out.println(list);
		System.out.println(house);
		return house;
	}
	
	@RequestMapping("remove/{id}")
	public boolean remove(@PathVariable("id")int id) {
		return biz.remove(id);
	}
	@RequestMapping("save")
	public House save(House bean) {
		if(biz.save(bean)) {
			return bean;
		}else {
		  return null;
		}		
	}
	
	@RequestMapping("uploads")
	public boolean upload(MultipartFile pica,MultipartFile picb,MultipartFile picc,MultipartFile picd,HttpServletRequest request) {
		//获得系统路径		
		String path =request.getSession().getServletContext().getRealPath("/imgs/house");
		//获得id号
		String hid = request.getParameter("id");
		//处理图片
		House bean = new House();
		bean.setId(Integer.parseInt(hid));
		if(pica!=null&& pica.getSize()>0) {
			String pa = UpLoad.getString(pica, path);
			if(pa!=null) {
				bean.setPica(pa);
			}
		}
		if(picb!=null&& picb.getSize()>0) {
			String pa = UpLoad.getString(picb, path);
			if(pa!=null) {
				bean.setPicb(pa);
			}
		}
		if(picc!=null&& picc.getSize()>0) {
			String pa = UpLoad.getString(picc, path);
			if(pa!=null) {
				bean.setPicc(pa);
			}
		}
		if(picd!=null&& picd.getSize()>0) {
			String pa = UpLoad.getString(picd, path);
			if(pa!=null) {
				bean.setPicd(pa);
			}
		}
		return biz.updateImg(bean);
		
	}
	@RequestMapping("find/{id}")
	public House find(@PathVariable("id") int id) {
		return this.biz.find(id);
	}
	@RequestMapping("state/{id}/{status}")
	public boolean state(@PathVariable("id") int id,@PathVariable("status") int status) {
		//System.out.println(status);
		return this.biz.state(id,status);
	}
	
}
