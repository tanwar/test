package com.tanwar.classcourt.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.tanwar.classcourt.bo.BoardBO;
import com.tanwar.classcourt.bo.ClassBO;
import com.tanwar.classcourt.bo.UserBO;
import com.tanwar.classcourt.dao.RegisterDAO;

public class RegisterDAOImpl extends HibernateDaoSupport implements RegisterDAO {

	@Override
	public void registerUser(String name, String userName, String emailId, String classId, String mobile, String userType, String password) {
		ClassBO classBO = new ClassBO();
		UserBO userBO = new UserBO();
		userBO.setClassBO(classBO);
		classBO.setClassId(Integer.parseInt(classId));
		userBO.setUsername(userName);
		userBO.setName(name);
		userBO.setEmailId(emailId);
		userBO.setMobile(mobile);
		userBO.setUserType(userType);
		userBO.setPassword(password);
		getHibernateTemplate().save(userBO);
		System.out.println(userBO);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<BoardBO> getBoardNames() {
		return (List<BoardBO>) this.getHibernateTemplate().execute(new HibernateCallback() {
			public List<BoardBO> doInHibernate(Session session) throws HibernateException {
				return (List<BoardBO>) session.createCriteria(BoardBO.class).list();
			}
		});
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<ClassBO> getBoardClass(String boardId) {
		final BoardBO boardBO = new BoardBO();
		boardBO.setBoardId(Integer.parseInt(boardId));
		return (List<ClassBO>) this.getHibernateTemplate().execute(new HibernateCallback() {
			public List<ClassBO> doInHibernate(Session session) throws HibernateException {
				return (List<ClassBO>) session.createCriteria(ClassBO.class).add(Restrictions.eq("boardBO", boardBO)).list();
			}
		});

	}
	
	@Override
	public void modifyUser(String name, String userId, String userName, String emailId, String classId, String mobile, String userType, String password) {
		ClassBO classBO = new ClassBO();
		UserBO userBO = new UserBO();
		userBO.setClassBO(classBO);
		classBO.setClassId(Integer.parseInt(classId));
		userBO.setUserId(Integer.parseInt(userId));
		userBO.setUsername(userName);
		userBO.setName(name);
		userBO.setEmailId(emailId);
		userBO.setMobile(mobile);
		userBO.setUserType(userType);
		userBO.setPassword(password);
		getHibernateTemplate().saveOrUpdate(userBO);
		System.out.println(userBO);
	}


}
