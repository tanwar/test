package com.tanwar.classcourt.service;

import java.util.List;

import com.tanwar.classcourt.bo.BoardBO;
import com.tanwar.classcourt.bo.ClassBO;

public interface RegisterService {

	public void registerUser(String name, String userName, String emailId, String classId, String Mobile, String userType, String password);
	
	public List<BoardBO> getBoardNames();
	
	public List<ClassBO> getBoardClass(String boardId);
	
	public void modifyUser(String name, String userId,String userName, String emailId, String classId, String Mobile, String userType, String password);
	
}
