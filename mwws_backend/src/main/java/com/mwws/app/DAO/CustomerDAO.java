package com.mwws.app.DAO;

import java.util.Map;

import com.mwws.app.entity.Customer;

public interface CustomerDAO {

	/**
	 * Get list customer by Condition (name, code, date, address,email)
	 * first and max 
	 * @return
	 */
	public Map<String,Object> getListCustomer(Customer customer);

	/**
	 * Get code of customer oldest
	 * @return
	 */
	public String getCode();
	
	/**
	 * Save Customer to DataBase
	 * @return
	 */
	public Customer save(Customer customer);
	
	/**
	 * Get Customer by Id 
	 * @param customerId
	 * @return
	 */
	public Customer customerById(Integer customerId);
	
	/**
	 * Update customer by Id
	 * @param customer
	 * @return
	 */
	public Customer updateCustomer(Customer customer);
	
	/**
	 * Delete Customer by Id
	 * @param id
	 */
	public void deleteCustomerById(Integer id);
}
