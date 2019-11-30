package com.mwws.app.DAO;

import java.util.List;
import java.util.Map;

import com.mwws.app.entity.WareHouse;

public interface WareHouseDAO {

	/**
	 * Get list all WareHouses
	 * @return
	 */
	public List<WareHouse> getAllWareHouses();
	
	/**
	 * Get List wareHouses by _Min-Max, filed search
	 */
	public Map<String,Object> getWareHouses(WareHouse wareHouse);
	
	/**
	 * Get WareHouse by Id
	 * @param id
	 * @return
	 */
	public WareHouse getWareHouseById(Integer id);
	
	/**
	 * Delete warehouse by Id
	 * @param id
	 * @return
	 */
	public boolean deleteWareHousesById(Integer id);
	
	/**
	 * Update wareHouses by Id
	 * @param wareHouses
	 * @return
	 */
	public boolean updateWareHousesById(WareHouse wareHouse);
	
	/**
	 * Add new WareHouse 
	 * @param wareHouse
	 * @return
	 */
	public boolean addWareHouses(WareHouse wareHouse);
}
