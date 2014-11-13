package com.tanwar.classcourt.dao;

import java.util.List;

import com.tanwar.classcourt.bo.SubjectBO;


public interface SubjectDAO {
	
	public void addSubject(String subjectName, String classId);
	public List<SubjectBO> getAllSubject(String classId);
	public void deleteSubject(int subjectId);

}
