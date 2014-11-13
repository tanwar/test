package com.tanwar.classcourt.service.impl;

import java.util.List;

import com.tanwar.classcourt.bo.BoardBO;
import com.tanwar.classcourt.bo.ClassBO;
import com.tanwar.classcourt.dao.RegisterDAO;
import com.tanwar.classcourt.service.RegisterService;

public class RegisterServiceImpl implements RegisterService{

private RegisterDAO registerDAO;
	
	public void setRegisterDAO(RegisterDAO registerDAO) {
	this.registerDAO = registerDAO;
}
	
	@Override
	public void registerUser(String name, String userName, String emailId, String classId, String Mobile, String userType, String password) {
		// TODO Auto-generated method stub
		 registerDAO.registerUser(name, userName, emailId,classId, Mobile, userType, password);
	}

	@Override
	public List<BoardBO> getBoardNames() {
		List<BoardBO> boardList = registerDAO.getBoardNames();
		return boardList;
	}
	
	@Override
	public List<ClassBO> getBoardClass(String boardId){
		List<ClassBO> classList = registerDAO.getBoardClass(boardId);
		return classList;
		
	}
	
	@Override
	public void modifyUser(String name, String userId, String userName, String emailId, String classId, String Mobile, String userType, String password) {
		// TODO Auto-generated method stub
		 registerDAO.modifyUser(name, userId, userName, emailId,classId, Mobile, userType, password);
	}
		

}

