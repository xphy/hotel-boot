package com.phy.control;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.phy.bizs.IHPriceBiz;
import com.phy.model.HPrice;

@RestController
@RequestMapping("/hprice/")
public class HPriceCtrl {
	
	@Resource
	private IHPriceBiz biz;
	
	@RequestMapping("query")
	public Map<String,Object> query(int page,int rows){
		//定义要查询的页码，和行数
		if(page <= 0) {
			page = 1;
		}
		if(rows <= 0) {
			rows=10;
		}
		PageHelper.startPage(page, rows);
		//掉查询结果
		List<HPrice> list = this.biz.query();
		//强制转换查询结果
		Page pg =(Page)list;
		int pages = pg.getPages();
		Map<String,Object> map = new HashMap<>();
		map.put("list",list);
		map.put("pages", pages);
		map.put("page", page);
		return map;
	}
	@RequestMapping("find/{id}")
	public HPrice find(@PathVariable("id") int id){
		return this.biz.find(id);
	}
	@RequestMapping("/get")
	public HPrice getprice(int kid,String date){
		Map<String,Object> map = new HashMap<>();
		map.put("kid", kid);
		map.put("date",date);
		return biz.findDate(map);
	}
	
	@RequestMapping("save")
	public boolean save(HPrice bean) {
		return this.biz.save(bean);
	}
	@RequestMapping("remove/{id}")
    public boolean remove(@PathVariable("id") int id) {
    	return this.biz.remove(id);
    }
}
