package com.mwws.app.DAO;

import com.mwws.app.entity.User;

public interface UserDAO {

	/**
	 * Check login from client 
	 * @param username
	 * @param password
	 * @return
	 */
	public User loginUser(String username,String password);

}
