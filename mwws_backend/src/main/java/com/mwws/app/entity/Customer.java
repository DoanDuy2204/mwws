package com.mwws.app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="customers")
public class Customer {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name="CUSTOMER_ID")
	private int customerId;
	@Column(name="CUSTOMER_CODE")
	private String customerCode;
	@Column(name="CUSTOMER_NAME")
	private String customerName;
	@Column(name="CUSTOMER_DESCRIPTION")
	private String customerDescription;
	@Column(name="CUSTOMER_ADDRESS")
	private String customerAddress;
	@Column(name = "CUSTOMER_EMAIL")
	private String customerEmail;
	@Column(name = "CUSTOMER_TELEPHONE")
	private String customerTelephone;
	@Column(name = "CUSTOMER_SERIAL")
	private String customerSerial;
	@Column(name = "CUSTOMER_DOB")
	private String customerDob;
	@Column(name = "CREATED_DATE")
	private String createdDate;
	@Column(name = "UPDATED_DATE")
	private String updatedDate;
	@Column(name = "DELIVERY_ADDRESS")
	private String deliveryAddress;
	@Column(name = "DELIVERY_TELEPHONE")
	private String deliveryTelephone;
	@Column(name = "BANK_ACCOUNT")
	private String bankAccount;
	@Column(name = "BANK_LOCATION")
	private String bankLocation;
	@Column(name = "IMAGE")
	private String image;
	@Transient
	private Integer page;
	@Transient
	private Integer max;
	public Customer() {}
	public Customer(int customerId, String customerCode, String customerName, String customerDescription,
			String customerAddress, String customerEmail, String customerTelephone, String customerSerial,
			String customerDob, String createdDate, String updateDate, String deliveryAddress, String deliveryTelephone,
			String bankAccount, String bankLocation, String image, Integer page, Integer max) {
		super();
		this.customerId = customerId;
		this.customerCode = customerCode;
		this.customerName = customerName;
		this.customerDescription = customerDescription;
		this.customerAddress = customerAddress;
		this.customerEmail = customerEmail;
		this.customerTelephone = customerTelephone;
		this.customerSerial = customerSerial;
		this.customerDob = customerDob;
		this.createdDate = createdDate;
		this.updatedDate = updateDate;
		this.deliveryAddress = deliveryAddress;
		this.deliveryTelephone = deliveryTelephone;
		this.bankAccount = bankAccount;
		this.bankLocation = bankLocation;
		this.image = image;
		this.page = page;
		this.max = max;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getCustomerCode() {
		return customerCode;
	}
	public void setCustomerCode(String customerCode) {
		this.customerCode = customerCode;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCustomerDescription() {
		return customerDescription;
	}
	public void setCustomerDescription(String customerDescription) {
		this.customerDescription = customerDescription;
	}
	public String getCustomerAddress() {
		return customerAddress;
	}
	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}
	public String getCustomerEmail() {
		return customerEmail;
	}
	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}
	public String getCustomerTelephone() {
		return customerTelephone;
	}
	public void setCustomerTelephone(String customerTelephone) {
		this.customerTelephone = customerTelephone;
	}
	public String getCustomerSerial() {
		return customerSerial;
	}
	public void setCustomerSerial(String customerSerial) {
		this.customerSerial = customerSerial;
	}
	public String getCustomerDob() {
		return customerDob;
	}
	public void setCustomerDob(String customerDob) {
		this.customerDob = customerDob;
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
	public String getDeliveryAddress() {
		return deliveryAddress;
	}
	public void setDeliveryAddress(String deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}
	public String getDeliveryTelephone() {
		return deliveryTelephone;
	}
	public void setDeliveryTelephone(String deliveryTelephone) {
		this.deliveryTelephone = deliveryTelephone;
	}
	public String getBankAccount() {
		return bankAccount;
	}
	public void setBankAccount(String bankAccount) {
		this.bankAccount = bankAccount;
	}
	public String getBankLocation() {
		return bankLocation;
	}
	public void setBankLocation(String bankLocation) {
		this.bankLocation = bankLocation;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
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
