package com.phy.bizs;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.phy.mappers.CompanyMapper;
import com.phy.model.Company;

@Service
public class CompanyBiz implements ICompanyBiz {
	
	@Resource
	private CompanyMapper mapper;

	@Override
	public Company find() {
		return this.mapper.selectOne();
	}

	@Override
	public boolean save(Company bean) {
		return this.mapper.update(bean);
	}

	@Override
	public boolean saveImage(Company bean) {
		return this.mapper.updateImg(bean);
	}

}
