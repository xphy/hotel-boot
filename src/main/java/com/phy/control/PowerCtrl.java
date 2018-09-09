package com.phy.control;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.phy.bizs.IPowerBiz;
import com.phy.model.Power;

@RestController
@RequestMapping("/power/")
public class PowerCtrl {
	@Resource
   private IPowerBiz biz;
	@RequestMapping("save")
	public boolean save(Power bean){
		return biz.save(bean);
	}
	@RequestMapping("remove/{id}")
	public boolean remove(@PathVariable("id") int id){
		return biz.remove(id);
	}
	@RequestMapping("find/{id}")
	public Power find(@PathVariable("id") int id){
		return biz.find(id);
	}
	@RequestMapping("query1")
	public List<Power> query1(){
		return biz.query1();
	}
	@RequestMapping("query2")
	public List<Power> query2(){
		return biz.query2();
	}
	@RequestMapping("/savexh")
	public boolean savexh(int id,int flag){ 
		Map<String,Integer> map = new HashMap<>();
		map.put("id", id);
		map.put("flag", flag);
		return biz.saveXh(map);
	}
}
