package com.phy.bizs;
/**
 * @author 皮会友
 */

import java.util.List;

import com.phy.model.HPrice;

public interface IHPriceBiz {
	public boolean save(HPrice bean);
	public boolean remove(Integer id);
    public List<HPrice> query();
    public HPrice find(Integer id);
}
