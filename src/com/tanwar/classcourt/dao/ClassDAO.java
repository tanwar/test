package com.tanwar.classcourt.dao;

import java.util.List;
import java.util.Map;

import com.tanwar.classcourt.bo.ClassBO;


public interface ClassDAO {
	
	public void addClass(String className, String boardId);
	public List<ClassBO> getAllClass(String boardId);
	public void deleteClass(int classId);
	public Map<String,String> getAllClassMap(String boardId);
}
