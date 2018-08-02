package com.phy.bizs;

import com.phy.model.Company;

public interface ICompanyBiz {
	public Company find();
	public boolean save(Company bean);
	public boolean saveImage(Company bean);
}
