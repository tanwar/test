package com.tanwar.classcourt.dao.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.tanwar.classcourt.bo.BoardBO;
import com.tanwar.classcourt.bo.ClassBO;
import com.tanwar.classcourt.dao.ClassDAO;

public class ClassDAOImpl extends HibernateDaoSupport implements ClassDAO {

	@Override
	public void addClass(String className, String boardId) {

		ClassBO classBO = new ClassBO();
		BoardBO boardBO = new BoardBO();
		classBO.setClassName(className);
		
		classBO.setBoardBO(boardBO);
		boardBO.setBoardId(Integer.parseInt(boardId));
		classBO.setCreatedOn(new Date());
		getHibernateTemplate().save(classBO);
		System.out.println(classBO);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ClassBO> getAllClass(String boardId) {
		System.out.println("boardId22: "+boardId);
		final BoardBO boardBO = new BoardBO();
		boardBO.setBoardId(Integer.parseInt(boardId));

		return (List<ClassBO>) this.getHibernateTemplate().execute(new HibernateCallback() {
			public List<ClassBO> doInHibernate(Session session) throws HibernateException {
				return (List<ClassBO>) session.createCriteria(ClassBO.class).add(Restrictions.eq("boardBO", boardBO)).list();
			}
		});

	}
	
	public Map<String,String> getAllClassMap(String boardId) {
		System.out.println("boardId1: "+boardId);
		Map<String, String> map = new HashMap<String, String>();
		try{
		List<ClassBO> classBOs = getAllClass(boardId);
		for(ClassBO classBO : classBOs){
			map.put(String.valueOf(classBO.getClassId()), classBO.getClassName());
		}
		System.out.println("All class MAp: "+map);
		}catch(Exception e){
			e.printStackTrace();
		}
		return map;
	}
	
	

	@Override
	public void deleteClass(int classId) {
		ClassBO classBO = new ClassBO();
		classBO.setClassId(classId);
		getHibernateTemplate().delete(classBO);
	}

	
	
	

}
