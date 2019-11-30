package com.mwws.app.rest;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mwws.app.Service.CustomerService;
import com.mwws.app.entity.Customer;

@RestController
@RequestMapping("/customer")
@CrossOrigin
public class RestCustomerController {

	@Autowired
	CustomerService customerService;

	/**
	 * Get list customer by Condition, min, max
	 * @param customer
	 * @param req
	 * @return
	 */
	@PostMapping("/list")
	public Map<String, Object> getListCustomer(@RequestBody Customer customer, HttpServletRequest req) {
		if (customer != null)
			return customerService.getListCustomer(customer);
		else
			return null;
	}
	
	/**
	 * Get code of customer End list.
	 * @return
	 */
	@GetMapping("/getCode")
	public Map<String,String> getCode() {
		String code = customerService.getCode();
		Map<String,String> maps = new HashMap<String, String>();
		maps.put("code", code);
		return maps;
	}
	
	/**
	 * Add customer to DB
	 * @param customer
	 * @return
	 */
	@SuppressWarnings("unused")
	@PostMapping("add")
	public Customer addCustomer(@RequestBody Customer customer) {
		if(customer==null ||customer.getCustomerName()==null||customer.getCustomerName().trim().equals("")
			||customer.getCustomerAddress()==null||customer.getCustomerAddress().trim().equals("")
			||customer.getCustomerTelephone()==null||customer.getCustomerTelephone().trim().equals(""))
			return null;
		if(customer!=null) {
			return customerService.save(customer);
		}
		return null;
	}
	
	@SuppressWarnings("unused")
	@PostMapping("update")
	public Customer updateCutomer(@RequestBody Customer customer) {
		if(customer==null ||customer.getCustomerName()==null||customer.getCustomerName().trim().equals("")
				||customer.getCustomerAddress()==null||customer.getCustomerAddress().trim().equals("")
				||customer.getCustomerTelephone()==null||customer.getCustomerTelephone().trim().equals(""))
				return null;
		if(customer!=null) {
			return customerService.updateCustomer(customer);
		}
		return null;
	}
	
	@RequestMapping(value="detail/{id}",method = RequestMethod.GET)
	public Customer saveCustomer(@PathVariable("id") Integer id) {
		if(id>=0) {
			return customerService.getCustomerById(id);
		}
		return null;
	}
	
	@DeleteMapping(value="delete")
	public Map<String,String> deleteCustomer(HttpServletRequest req) {
		Map<String,String> maps = new HashMap<String, String>();
		String id = req.getParameter("id");
		String[] ids = id.split(",");
		if(ids.length>0) {
			for(int i=0;i<ids.length;i++) 
				this.customerService.deleteCustomerById(Integer.parseInt(ids[i]));
			maps.put("result", "success");
			return maps;
		}
		maps.put("result", "failed");
		return maps;
	}

}
