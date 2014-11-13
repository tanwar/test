package com.tanwar.classcourt.service.impl;

import java.util.List;

import com.tanwar.classcourt.bo.SubjectBO;
import com.tanwar.classcourt.dao.SubjectDAO;
import com.tanwar.classcourt.service.SubjectService;

public class SubjectServiceImpl implements SubjectService {

	private SubjectDAO subjectDAO;
	

	public void setSubjectDAO(SubjectDAO subjectDAO) {
		this.subjectDAO = subjectDAO;
	}


	@Override
	public void addSubject(String subjectName, String classId) {
		subjectDAO.addSubject(subjectName, classId);
	}

	@Override
	public List<SubjectBO> getAllSubject(String classId) {
		return subjectDAO.getAllSubject(classId);
	}


	@Override
	public void deleteSubject(int subjectId) {
		subjectDAO.deleteSubject(subjectId);
		
	}
	

}
