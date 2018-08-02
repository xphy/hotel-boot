package com.phy.bizs;
import com.phy.model.*;

import com.phy.mappers.*;
import java.util.*;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

@Service
public class KindBiz implements IKindBiz{
	@Resource
	private KindMapper mapper;

	@Override
	public boolean save(Kind bean) {
		if(bean.getId()!=null){
			return this.mapper.update(bean);
		}else{
			return this.mapper.insert(bean);
		}
	}

	@Override
	public boolean remove(Integer id) {
		boolean flag = false;
		try{
			flag = this.mapper.delete(id);
		}catch(Exception ex){
			//log.error(ex.getMessage());
		}
		return flag;
	}

	@Override
	public Kind find(Integer id) {
		return this.mapper.selectOne(id);
	}

	@Override
	public List<Kind> query2() {
		return this.mapper.select2();
	}
	
}
