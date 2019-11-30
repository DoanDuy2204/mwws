package com.mwws.app.ServiceImpl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mwws.app.DAO.CustomerDAO;
import com.mwws.app.Service.CustomerService;
import com.mwws.app.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	CustomerDAO customerDAO;
	
	@Override
	public Map<String, Object> getListCustomer(Customer customer) {
		if(customer==null || customer.getMax() < 0)
			return null;
		return customerDAO.getListCustomer(customer);
	}

	@Override
	public String getCode() {
		return customerDAO.getCode();
	}

	@Override
	public Customer save(Customer customer) {
		if(customer==null)
			return null;
		return customerDAO.save(customer);
	}

	@Override
	public Customer getCustomerById(Integer customerId) {
		if(customerId>=0) {
			return customerDAO.customerById(customerId);
		}
		return null;
	}

	@Override
	public Customer updateCustomer(Customer customer) {
		return customerDAO.updateCustomer(customer);
	}

	@Override
	public void deleteCustomerById(Integer id) {
		if(id>0){
			this.customerDAO.deleteCustomerById(id);
		}
	}

}
