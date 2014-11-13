package com.tanwar.classcourt.service;

import java.util.List;

import com.tanwar.classcourt.bo.ClassBO;


public interface ClassService {
	
	public void addClass(String className, String boardId);
	public void deleteClass(int classId);
	public List<ClassBO> getAllClass(String classId);

}
