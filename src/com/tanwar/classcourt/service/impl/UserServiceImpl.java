package com.tanwar.classcourt.service.impl;

import com.tanwar.classcourt.bo.UserBO;
import com.tanwar.classcourt.dao.UserDAO;
import com.tanwar.classcourt.service.UserService;

public class UserServiceImpl implements UserService {

	private UserDAO userDAO;
	
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	@Override
	public UserBO validateUser(String userType, String username, String password) {
		
		return userDAO.validateUser(userType, username, password);
	}

		

}
