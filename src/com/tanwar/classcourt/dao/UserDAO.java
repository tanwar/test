package com.tanwar.classcourt.dao;

import com.tanwar.classcourt.bo.UserBO;


public interface UserDAO {
	
	public UserBO validateUser(String userType, String username, String password);

}
