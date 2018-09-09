package com.phy.control;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.phy.bizs.IMsgsetBiz;
import com.phy.model.Msgset;

@RestController
@RequestMapping("/msgset/")
public class MsgsetCtrl {
	@Resource
	private IMsgsetBiz biz;
	
	@RequestMapping("query")
	public Msgset query() {
		return this.biz.query();
	}
	@RequestMapping("update")
	public boolean update(Msgset bean) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("total", bean.getTotal());
		map.put("phone", bean.getPhone());
		return biz.update(map);
	}

}
