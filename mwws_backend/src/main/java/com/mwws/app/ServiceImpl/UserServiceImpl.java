package com.mwws.app.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mwws.app.DAO.UserDAO;
import com.mwws.app.Service.UserService;
import com.mwws.app.entity.User;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserDAO userDAO;
	
	@Override
	public User loginUser(String username, String password) {
		if(username!=null&&!username.trim().equals("")
			&&password!=null&&!password.trim().equals("")) {
			return userDAO.loginUser(username, password);
		}
		return null;
	}

}
