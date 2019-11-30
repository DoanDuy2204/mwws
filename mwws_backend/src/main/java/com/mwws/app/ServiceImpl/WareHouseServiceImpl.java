package com.mwws.app.ServiceImpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mwws.app.DAO.WareHouseDAO;
import com.mwws.app.Service.WareHouseService;
import com.mwws.app.entity.WareHouse;
@Service
public class WareHouseServiceImpl implements WareHouseService{

	@Autowired
	WareHouseDAO wareHouseDAO;
	
	@Override
	public List<WareHouse> getAllWareHouses() {
		return wareHouseDAO.getAllWareHouses();
	}

	@Override
	public Map<String, Object> getWareHouses(WareHouse wareHouse) {
		if(wareHouse!=null) {
			return wareHouseDAO.getWareHouses(wareHouse);
		}
		return null;
	}

	
}
