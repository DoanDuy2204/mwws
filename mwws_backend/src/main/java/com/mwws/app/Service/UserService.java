package com.mwws.app.Service;

import com.mwws.app.entity.User;

public interface UserService {

	/**
	 * Check login for Client
	 * @param username
	 * @param password
	 * @return
	 *       User : user
	 */
	public User loginUser(String username,String password);
}
