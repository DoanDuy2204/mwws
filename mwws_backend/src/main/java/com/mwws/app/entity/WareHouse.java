package com.mwws.app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="warehouses")
public class WareHouse {

	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	@Column(name = "WAREHOUSE_ID")
	private Integer wareHouseId;
	
	@Column(name = "WAREHOUSE_NAME")
	private String wareHouseName;
	
	@Column(name = "WAREHOUSE_ADDRESS")
	private String wareHouseAddress;
	
	@Column(name = "WAREHOUSE_DESCRIPTION")
	private String wareHouseDescription;
	
	@Column(name = "CREATED_DATE")
	private String createdDate;
	
	@Column(name = "UPDATED_DATE")
	private String updatedDate;

	@Transient
	private Integer page;
	@Transient
	private Integer max;
	
	public WareHouse() {}

	public Integer getWareHouseId() {
		return wareHouseId;
	}

	public void setWareHouseId(Integer wareHouseId) {
		this.wareHouseId = wareHouseId;
	}

	public String getWareHouseName() {
		return wareHouseName;
	}

	public void setWareHouseName(String wareHouseName) {
		this.wareHouseName = wareHouseName;
	}

	public String getWareHouseAddress() {
		return wareHouseAddress;
	}

	public void setWareHouseAddress(String wareHouseAddress) {
		this.wareHouseAddress = wareHouseAddress;
	}

	public String getWareHouseDescription() {
		return wareHouseDescription;
	}

	public void setWareHouseDescription(String wareHouseDescription) {
		this.wareHouseDescription = wareHouseDescription;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public String getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(String updatedDate) {
		this.updatedDate = updatedDate;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getMax() {
		return max;
	}

	public void setMax(Integer max) {
		this.max = max;
	}
	
}
