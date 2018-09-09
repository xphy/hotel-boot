package com.phy.control;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.phy.bizs.IReserveBiz;
import com.phy.model.Reserve;

@RestController
@RequestMapping("/reserve/")
public class ReserveCtrl {
   @Resource
   private IReserveBiz biz;
   @RequestMapping("/get/{id}")
	public Reserve get(@PathVariable("id") int id){
		return biz.find(id);
	}
	
	@RequestMapping("/query")
	public Map<String, Object> query(HttpServletRequest request){
		String spage = request.getParameter("page");
		String srows = request.getParameter("rows");
		String sdate = request.getParameter("sdate");
		String edate = request.getParameter("edate");
		String skid = request.getParameter("kid");
		String custom = request.getParameter("custom");
		String sphone = request.getParameter("phone");
		Map<String, Object> map = new HashMap<>();
		if(custom!=null&&!"".equals(custom)) {
			map.put("custom", custom);
		}
		if(sdate!=null&&!"".equals(sdate)) {
			map.put("sdate", sdate);
		}
		if(edate!=null&&!"".equals(edate)) {
			map.put("edate", edate);
		}
		if(skid!=null&&!"".equals(skid)) {
			int kid = Integer.parseInt(skid);
			map.put("kid", kid);
		}
		if(sphone!=null&&!"".equals(sphone)) {
			map.put("phone", sphone);
		}
		int page = 1;
		int rows =10;
		if(spage!=null&&!"".equals(spage)) {
			page = Integer.parseInt(spage);
		}
		if(srows!=null&&!"".equals(srows)) {
			rows = Integer.parseInt(srows);
		}
		PageHelper.startPage(page,rows);
		List<Reserve> list = this.biz.query(map);
		Page pg =(Page)list;
		int pages = pg.getPages();
		Map<String, Object> reserves = new HashMap<>();
		reserves.put("list", list);
		reserves.put("pages", pages);
		reserves.put("page", page);
		return reserves;
	}
	@RequestMapping("/checkIn")
	public boolean checkIn(Reserve bean) {
		return this.biz.checkIn(bean);
	}
	@RequestMapping("/save")
	public boolean save(Reserve bean) {
		System.out.println(bean.getPhone());
		return biz.save(bean);
	}
	@RequestMapping("/remove/{id}")
	public boolean remove(@PathVariable("id")int id) {
		return biz.remove(id);
	}
}
