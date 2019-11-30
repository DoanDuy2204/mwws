package com.mwws.app.Service;

import java.util.Map;

import com.mwws.app.entity.Customer;

public interface CustomerService {
	
	/**
	 * Get List Customer by condition( name, address, code, description, date,..)
	 * Get total and total page
	 * @param customer
	 * @param page
	 * @param max
	 * @return
	 */
	public Map<String,Object> getListCustomer(Customer customer);
	
	/**
	 * Get code of customer oldest
	 * @return
	 */
	public String getCode();
	
	/**
	 * Save Customer 
	 * @param customer
	 * @return
	 */
	public Customer save(Customer customer);
	
	/**
	 * Get customer By Id
	 * @param customerId
	 * @return
	 */
	public Customer getCustomerById(Integer customerId);
	
	/**
	 * Update customer by Id
	 * @param customerId
	 * @return
	 */
	public Customer updateCustomer(Customer customer);
	
	/**
	 * Delete customer by id
	 * @param id
	 */
	public void deleteCustomerById(Integer id);
	
}
