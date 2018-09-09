package com.phy.bizs;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.phy.mappers.RecordMapper;
import com.phy.mappers.ReserveMapper;
import com.phy.model.Record;
import com.phy.model.Reserve;

@Service
public class ReserveBiz implements IReserveBiz{
    
	@Resource
	private ReserveMapper mapper;
	@Resource
	private RecordMapper dao;
	
	@Transactional(propagation=Propagation.REQUIRED)
	public boolean checkIn(Reserve bean) {
		Record record = new Record();
		String custom = bean.getCustom();
		String wxnick = bean.getWxnick();
		String phone = bean.getPhone();
		Integer persons = bean.getPersons();
		String rdate = bean.getRdate();
		String ldate = bean.getLdate();
		Integer hid = bean.getHid();
		Float price = bean.getPrice();
		Float total = bean.getTotal();
		if(custom!=null&&!"".equals(custom)) {
			record.setCustom(custom);
		}
		if(wxnick!=null&&!"".equals(wxnick)) {
			record.setWxnick(wxnick);
		}
		if(phone!=null&&!"".equals(phone)) {
			record.setPhone(phone);
		}
		if(persons!=null) {
			record.setPersons(persons);
		}
		if(rdate!=null&&!"".equals(rdate)) {
			record.setRdate(rdate);
		}
		if(ldate!=null&&!"".equals(ldate)) {
			record.setLdate(ldate);
		}
		if(hid!=null) {
			record.setHid(hid);
		}
		if(price!=null) {
			record.setPrice(price);
		}
		if(total!=null) {
			record.setTotal(total);
		}
		if(this.dao.insert(record)) {
			if(this.mapper.delete(bean.getId())) {
				return true;
			}else {
				return false;
			}
		}else {
			return false;
		}
		
	}
	@Override
	public boolean save(Reserve bean) {
		if(bean.getId()!=0) {
			return this.mapper.update(bean);
		}else {
			return this.mapper.insert(bean);
		}
	}

	@Override
	public boolean remove(Integer id) {
		return this.mapper.delete(id);
	}
     
	@Override
	public Reserve find(Integer id) {
		return this.mapper.selectOne(id);
	}

	@Override
	public List<Reserve> query(Map<String, Object> map) {
		return this.mapper.selectall(map);
	}

	

}
