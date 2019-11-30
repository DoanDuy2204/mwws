package com.mwws.app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="infor_users")
public class Infor_User {

	@GeneratedValue
	@Id
	@Column(name="INFOR_ID")
	private int INFOR_ID;
	
	@Column(name="INFOR_NAME")
	private String INFOR_NAME;
	
	@Column(name="INFOR_FULLNAME")
	private String INFOR_FULLNAME;
	
	@Column(name="INFOR_ADDRESS")
	private String INFOR_ADDRESS;
	
	@Column(name="INFOR_EMAIL")
	private String INFOR_EMAIL;
	
	@Column(name="INFOR_PHONE")
	private String INFOR_PHONE;
	
	@Column(name="CREATED_DATE")
	private String CREATED_DATE;
	
	@Column(name="UPDATED_DATE")
	private String UPDATED_DATE;

	public Infor_User() {}

	public Infor_User(int iNFOR_ID, String iNFOR_NAME, String iNFOR_FULLNAME, String iNFOR_ADDRESS, String iNFOR_EMAIL,
			String iNFOR_PHONE, String cREATED_DATE, String uPDATED_DATE) {
		super();
		INFOR_ID = iNFOR_ID;
		INFOR_NAME = iNFOR_NAME;
		INFOR_FULLNAME = iNFOR_FULLNAME;
		INFOR_ADDRESS = iNFOR_ADDRESS;
		INFOR_EMAIL = iNFOR_EMAIL;
		INFOR_PHONE = iNFOR_PHONE;
		CREATED_DATE = cREATED_DATE;
		UPDATED_DATE = uPDATED_DATE;
	}

	public int getINFOR_ID() {
		return INFOR_ID;
	}

	public void setINFOR_ID(int iNFOR_ID) {
		INFOR_ID = iNFOR_ID;
	}

	public String getINFOR_NAME() {
		return INFOR_NAME;
	}

	public void setINFOR_NAME(String iNFOR_NAME) {
		INFOR_NAME = iNFOR_NAME;
	}

	public String getINFOR_FULLNAME() {
		return INFOR_FULLNAME;
	}

	public void setINFOR_FULLNAME(String iNFOR_FULLNAME) {
		INFOR_FULLNAME = iNFOR_FULLNAME;
	}

	public String getINFOR_ADDRESS() {
		return INFOR_ADDRESS;
	}

	public void setINFOR_ADDRESS(String iNFOR_ADDRESS) {
		INFOR_ADDRESS = iNFOR_ADDRESS;
	}

	public String getINFOR_EMAIL() {
		return INFOR_EMAIL;
	}

	public void setINFOR_EMAIL(String iNFOR_EMAIL) {
		INFOR_EMAIL = iNFOR_EMAIL;
	}

	public String getINFOR_PHONE() {
		return INFOR_PHONE;
	}

	public void setINFOR_PHONE(String iNFOR_PHONE) {
		INFOR_PHONE = iNFOR_PHONE;
	}

	public String getCREATED_DATE() {
		return CREATED_DATE;
	}

	public void setCREATED_DATE(String cREATED_DATE) {
		CREATED_DATE = cREATED_DATE;
	}

	public String getUPDATED_DATE() {
		return UPDATED_DATE;
	}

	public void setUPDATED_DATE(String uPDATED_DATE) {
		UPDATED_DATE = uPDATED_DATE;
	}
	
}
