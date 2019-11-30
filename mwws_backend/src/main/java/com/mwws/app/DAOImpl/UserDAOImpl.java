package com.mwws.app.DAOImpl;

import java.util.Base64;
import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mwws.app.DAO.UserDAO;
import com.mwws.app.entity.User;

@Repository
@Transactional
public class UserDAOImpl implements UserDAO{

	EntityManager entityManager;
	
	@Autowired
	public UserDAOImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Autowired
	BCryptPasswordEncoder bcryptPasswordEncoder;
	
	@Override
	public User loginUser(String username, String password){
		byte[] passwordDeco = Base64.getDecoder().decode(password.getBytes());
		String passwordDecoder = new String(passwordDeco);
		String query = "From User u where lower(u.USERNAME) like :username";
		Session session = entityManager.unwrap(Session.class);
		Query<User> row = session.createQuery(query,User.class);
		row.setParameter("username", username.toLowerCase());
		List<User> users = row.getResultList();
		if(!users.isEmpty()) {
			User user = users.get(0);
			boolean checkPass = bcryptPasswordEncoder.matches(passwordDecoder, user.getPASSWORD());
			if(checkPass) {
				return user;
			}
		}
		return null;
	}
	
	public static void main(String[] args) {
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		System.out.println(bCryptPasswordEncoder.encode("123456"));
	}

}
