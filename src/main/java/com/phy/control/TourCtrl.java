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
import com.phy.bizs.ITourBiz;
import com.phy.model.Tour;

@RestController
@RequestMapping("/tour/")
public class TourCtrl {
	@Resource
	private ITourBiz biz;
	
	@RequestMapping("query")
	public Map<String,Object> query(HttpServletRequest request){
		String title = request.getParameter("title");
		String sdate = request.getParameter("sdate");
		String edate = request.getParameter("edate");
		//参数处理
		Map<String,Object> map =new HashMap<>();
		if(title!=null&&!title.equals("")) {
			map.put("title", title);
		}
		if(sdate!=null&&!sdate.equals("")) {
			map.put("sdate", sdate);
		}
		if(edate!=null&&!edate.equals("")) {
			map.put("edate", edate);
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
		PageHelper.startPage(page, rows);
		List<Tour> list = this.biz.query(map);
		
		Page pg = (Page)list;
		int pages = pg.getPages();
		Map<String,Object> tours = new HashMap<>();
		tours.put("list", list);
		tours.put("pages",pages);
		tours.put("page",p);
		
		return tours;
	}
	@RequestMapping("save")
	public boolean save(Tour bean) {
		return this.biz.save(bean);
	}
	@RequestMapping("remove/{id}")
	public boolean remove(@PathVariable("id") int id) {
		return this.biz.remove(id);
	}
	@RequestMapping("find/{id}")
	public Tour find(@PathVariable("id") int id) {
		return this.biz.find(id);
	}

}
