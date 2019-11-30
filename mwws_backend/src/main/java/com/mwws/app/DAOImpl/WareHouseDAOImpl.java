package com.mwws.app.DAOImpl;

import java.math.BigInteger;
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

import com.mwws.app.DAO.WareHouseDAO;
import com.mwws.app.entity.WareHouse;

@Repository
@Transactional
public class WareHouseDAOImpl implements WareHouseDAO{

	private EntityManager entityManager;
	
	@Autowired
	public WareHouseDAOImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	/**
	 * Get list WareHouse
	 */
	@Override
	public List<WareHouse> getAllWareHouses() {
		Session session = entityManager.unwrap(Session.class);
		Query<WareHouse> rows = session.createQuery("from WareHouse",WareHouse.class);
		return rows.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String,Object> getWareHouses(WareHouse wareHouse) {
		Integer min = wareHouse.getPage();
		Integer max = wareHouse.getMax();
		Session session = entityManager.unwrap(Session.class);
		String sql = "from WareHouse ws where 1=1 ";
		String sqlCount = "select count(*) from warehouses ws where 1=1 ";
		Map<String,String> params = new HashMap<String,String>();
		if(wareHouse.getWareHouseName()!=null&&wareHouse.getWareHouseName().trim()!="") {
			sql += " and ws.wareHouseName =:name ";
			sqlCount += " and ws.WAREHOUSE_NAME =:name ";
			params.put("name", wareHouse.getWareHouseName());
		}
		if(wareHouse.getWareHouseAddress()!=null&&wareHouse.getWareHouseAddress().trim()!="") {
			sql += " and ws.wareHouseAddress =: address ";
			sqlCount += " and ws.WAREHOUSE_ADDRESS =:address ";
			params.put("address", wareHouse.getWareHouseAddress());
		}
		if(wareHouse.getWareHouseDescription()!=null&&wareHouse.getWareHouseDescription()!="") {
			sql += " and ws.wareHouseDescription =:description ";
			sqlCount += " and ws.WAREHOUSE_DESCRIPTION =:description ";
			params.put("description", wareHouse.getWareHouseDescription());
		}
		Query<BigInteger> queryCount = session.createNativeQuery(sqlCount); 
		Query<WareHouse> query = session.createQuery(sql,WareHouse.class);
		if(!params.isEmpty()) {
			for(Entry<String, String> item : params.entrySet()) {
				queryCount.setParameter(item.getKey(),item.getValue());
				query.setParameter(item.getKey(), item.getValue());
			}
		}
		if(min!=-1) {
			Integer count = queryCount.getSingleResult().intValue();
			Integer countPage = count%max==0?count/max:(count/max+1);
			Integer first = (min-1)*max;
			query.setFirstResult(first);
			query.setMaxResults(max);
			List<WareHouse> wareHouses = query.getResultList();
			Map<String, Object> results = new HashMap<String,Object>();
			results.put("total", count);
			results.put("page", countPage);
			results.put("warehouses", wareHouses);
			return results;
		}
		return null;
	}

	@Override
	public WareHouse getWareHouseById(Integer id) {
		return entityManager.unwrap(Session.class).get(WareHouse.class, id);
	}

	@Override
	public boolean deleteWareHousesById(Integer id) {
		if(id>=0) {
			Session session = entityManager.unwrap(Session.class);
			session.delete(id);
			return true;
		}
		return false;
	}

	@Override
	public boolean updateWareHousesById(WareHouse wareHouse) {
		if(wareHouse!=null) {
			Session session = entityManager.unwrap(Session.class);
			session.update(wareHouse);
			return true;
		}
		return false;
	}

	@Override
	public boolean addWareHouses(WareHouse wareHouse) {
		if(wareHouse!=null) {
			Session session = entityManager.unwrap(Session.class);
			session.persist(wareHouse);
			return true;
		}
		return false;
	}

}
