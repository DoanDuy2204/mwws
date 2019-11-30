package com.mwws.app.rest;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mwws.app.Service.WareHouseService;
import com.mwws.app.entity.WareHouse;

@RestController
@RequestMapping("/warehouse")
@CrossOrigin
public class RestWareHouseController {

	@Autowired
	WareHouseService wareHouseService;
	
	/**
	 * Get list wareHouses by page- max record and search condition
	 * @return
	 */
	@PostMapping("list")
	public Map<String,Object> getWareHouses(@RequestBody WareHouse wareHouses){
		if(wareHouses!=null) {
			return wareHouseService.getWareHouses(wareHouses);
		}
		return null;
	}
}
