package com.mwws.app.DAOImpl;

import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mwws.app.DAO.CustomerDAO;
import com.mwws.app.entity.Customer;

@Repository
@Transactional
public class CustomerDAOImpl implements CustomerDAO {

	private EntityManager entityManager;

	@Autowired
	public CustomerDAOImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> getListCustomer(Customer customer) {
		Integer page = customer.getPage();
		Integer max = customer.getMax();
		Map<String, Object> mapResult = new HashMap<String, Object>();
		// Get session of HIbernate
		Session session = entityManager.unwrap(Session.class);
		String query = "From Customer c where 1=1 ";
		String queryCount = "Select count(*) from customers c where 1=1 ";
		Map<String, Object> listParams = new HashMap<String, Object>();
		if (customer.getCustomerName() != null && !customer.getCustomerName().trim().equals("")) {
			query += " and lower(c.customerName) like lower(concat('%',:name,'%')) ";
			queryCount += " and lower(c.CUSTOMER_NAME) like lower(concat('%',:name,'%')) ";
			listParams.put("name", customer.getCustomerName());
		}
		if (customer.getCustomerTelephone() != null && !customer.getCustomerTelephone().trim().equals("")) {
			query += " and lower(c.customerTelephone) like lower(concat('%',:telephone,'%')) ";
			queryCount += " and lower(c.CUSTOMER_TELEPHONE) like lower(concat('%',:telephone,'%')) ";
			listParams.put("telephone", customer.getCustomerTelephone());
		}
		if (customer.getCustomerAddress() != null && !customer.getCustomerAddress().equals("")) {
			query += " and lower(c.customerAddress) like lower(concat('%',:address,'%')) ";
			queryCount += " and lower(c.CUSTOMER_ADDRESS) like lower(concat('%',:address,'%')) ";
			listParams.put("address", customer.getCustomerAddress());
		}
		if (customer.getCreatedDate() != null && !customer.getCreatedDate().trim().equals("")) {
			query += " and c.createdDate =:createDate ";
			queryCount += " and c.CREATED_DATE=:createDate ";
			listParams.put("createDate", customer.getCreatedDate());
		}
		if (customer.getCustomerCode() != null && !customer.getCustomerCode().trim().equals("")) {
			query += " and lower(c.customerCode) like lower(concat('%',:code,'%')) ";
			queryCount += " and lower(c.CUSTOMER_CODE) like lower(concat('%',:code,'%')) ";
			listParams.put("code", customer.getCustomerCode());
		}
		if (customer.getCustomerDescription() != null && !customer.getCustomerDescription().trim().equals("")) {
			query += " and lower(c.customerDescription) like lower(concat('%',:description,'%')) ";
			queryCount += " and lower(c.CUSTOMER_DESCRIPTION) like lower(concat('%',:description,'%')) ";
			listParams.put("description", customer.getCustomerDescription());
		}
		if (customer.getCustomerEmail() != null && !customer.getCustomerEmail().equals("")) {
			query += " and lower(c.customerEmail) like lower(concat('%',:email,'%')) ";
			queryCount += " and lower(c.CUSTOMER_EMAIL) like lower(concat('%',:email,'%')) ";
			listParams.put("email", customer.getCustomerEmail());
		}
		Query<Customer> rows = session.createQuery(query);
		Query<Integer> row = session.createNativeQuery(queryCount);
		if (!listParams.isEmpty()) {
			for (Entry<String, Object> str : listParams.entrySet()) {
				rows.setParameter(str.getKey(), str.getValue());
				row.setParameter(str.getKey(), str.getValue());
			}
		}
		if (page != -1) {
			Object totalObj = row.getSingleResult();
			BigInteger totalBig = (BigInteger) totalObj;
			Integer total = totalBig.intValue();
			Integer pageCountList = total % max == 0 ? total / max : (total / max + 1);
			Integer first = (page - 1) * max;
			rows.setFirstResult(first);
			rows.setMaxResults(max);
			List<Customer> customers = rows.getResultList();
			mapResult.put("total", total);
			mapResult.put("pageCountList", pageCountList);
			mapResult.put("customers", customers);
		}else {
			List<Customer> customerAll = rows.getResultList();
			mapResult.put("customerAll", customerAll);
		}
		return mapResult;
	}

	@Override
	public String getCode() {
		Session session = entityManager.unwrap(Session.class);
		String query = "From Customer c order by c.customerId asc";
		List<Customer> customers = session.createQuery(query, Customer.class).getResultList();
		if (customers.isEmpty()) {
			return "KH0";
		}
		Customer customer = customers.get(customers.size() - 1);
		return customer.getCustomerCode();
	}

	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	/**
	 * Save Customer to DataBase
	 */
	@Override
	public Customer save(Customer customer) {
		Session session = entityManager.unwrap(Session.class);
		customer.setCreatedDate(sdf.format(new Date()));
		session.persist(customer);
		return customer;
	}

	/**
	 * Get Customer By Id
	 */
	@Override
	public Customer customerById(Integer customerId) {
		Session session = entityManager.unwrap(Session.class);
		return session.get(Customer.class, customerId);
	}

	@Override
	public Customer updateCustomer(Customer customer) {
		entityManager.unwrap(Session.class).update(customer);
		return customer;
	}

	@Override
	public void deleteCustomerById(Integer id) {
		Session session = entityManager.unwrap(Session.class);
		Customer customer = session.get(Customer.class, id);
		session.delete(customer);
	}

}
