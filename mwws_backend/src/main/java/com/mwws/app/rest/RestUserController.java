package com.mwws.app.rest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mwws.app.Service.ParameterService;
import com.mwws.app.Service.UserService;
import com.mwws.app.entity.User;

@RestController
@RequestMapping(value= {"user"})
@CrossOrigin
public class RestUserController {

	@Autowired
	UserService userService;
	@Autowired
	ParameterService parameterService;
	
	@PostMapping(value= {"login"})
	public User checkLoginUser(HttpServletRequest req,HttpServletResponse resp,@RequestBody String userLogin) {
		String[] str = userLogin.split(":");
		String username = str[0];String password = str[1];
		if(username != null && password != null && !username.trim().equals("") && !password.trim().equals("")) {
			User user = userService.loginUser(username, password);
			if(user!=null) {	
				HttpSession session = req.getSession();
				session.setAttribute("user", user);
				String token = session.getId();
				user.setToken(token);
				return user;	
			}
			return null;
		}
		return null;
	}
}
