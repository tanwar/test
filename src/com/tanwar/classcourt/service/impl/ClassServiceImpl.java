package com.tanwar.classcourt.service.impl;

import java.util.List;

import com.tanwar.classcourt.bo.ClassBO;
import com.tanwar.classcourt.dao.ClassDAO;
import com.tanwar.classcourt.service.ClassService;

public class ClassServiceImpl implements ClassService {

	private ClassDAO classDAO;
	

	public void setClassDAO(ClassDAO classDAO) {
		this.classDAO = classDAO;
	}


	@Override
	public void addClass(String className, String boardId) {
		classDAO.addClass(className, boardId);
	}

	@Override
	public List<ClassBO> getAllClass(String boardId) {
		return classDAO.getAllClass(boardId);
	}


	@Override
	public void deleteClass(int classId) {
		classDAO.deleteClass(classId);
		
	}
	

}
