package com.phy.mappers;

import org.apache.ibatis.annotations.Mapper;

import com.phy.model.Company;

@Mapper
public interface CompanyMapper {
    public Company selectOne();
    public boolean update(Company bean);
    public boolean updateImg(Company bean);
}
