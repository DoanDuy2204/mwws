package com.mwws.app.Service;

import java.util.List;
import java.util.Map;

import com.mwws.app.entity.WareHouse;

public interface WareHouseService {

	/**
	 * get All List WareHouse 
	 * @return
	 */
	public List<WareHouse> getAllWareHouses();
	
	/**
	 * get list warehouse by first-last and condition search
	 * @return
	 */
	public Map<String,Object> getWareHouses(WareHouse wareHouses);
}
