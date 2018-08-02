package com.phy.control;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.phy.bizs.IKindBiz;
import com.phy.model.Kind;


@RestController
@RequestMapping("/kind")
public class KindCtrl {
	@Resource
	private IKindBiz biz;
	private static final Logger log = LoggerFactory.getLogger(KindCtrl.class);
	
	@RequestMapping("/get/{kid}")
	public Kind get(@PathVariable("kid") int id){
		return biz.find(id);
	}
	
	@RequestMapping("/query")
	public List<Kind> query(){
		log.info("-----------查询所有客房类型-----------");
		return biz.query2();
	}
	@RequestMapping("/save")
	public boolean save(Kind bean) {
		return biz.save(bean);
	}
	@RequestMapping("/remove/{id}")
	public boolean remove(@PathVariable("id")int id) {
		return biz.remove(id);
	}
}
