package com.tanwar.classcourt.service;

import com.tanwar.classcourt.bo.UserBO;


public interface UserService {
	
	public UserBO validateUser(String userType, String username, String password);

}
