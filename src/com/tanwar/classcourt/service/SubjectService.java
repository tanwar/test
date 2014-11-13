package com.tanwar.classcourt.service;

import java.util.List;

import com.tanwar.classcourt.bo.SubjectBO;


public interface SubjectService {
	
	public void addSubject(String subjectName, String classId);
	public void deleteSubject(int subjectId);
	public List<SubjectBO> getAllSubject(String classId);

}
