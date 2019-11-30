package com.mwws.app.DAOImpl;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mwws.app.DAO.ParameterDAO;
import com.mwws.app.entity.Parameter;

@Repository
public class ParameterDAOImpl implements ParameterDAO{

	EntityManager entityManager;

	@Autowired
	public ParameterDAOImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	@Override
	public List<Parameter> getParameter() {
		Session session = this.entityManager.unwrap(Session.class);
		String query = "From Parameter p where p.status=1";
		Query<Parameter> queries = session.createQuery(query,Parameter.class);
		return queries.getResultList();
	}

}
