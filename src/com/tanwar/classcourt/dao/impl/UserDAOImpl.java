package com.tanwar.classcourt.dao.impl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.tanwar.classcourt.bo.UserBO;
import com.tanwar.classcourt.dao.UserDAO;

public class UserDAOImpl extends HibernateDaoSupport implements UserDAO {

	@Override
	public UserBO validateUser(final String userType, final String username, final String password) {
		UserBO userBO = null;
		/*getHibernateTemplate().execute(new HibernateCallback() {
			@Override
			public UserBO doInHibernate(Session session) throws HibernateException, SQLException {
				return (UserBO) session.createCriteria(UserBO.class).add(Restrictions.eq("username", username)).add(Restrictions.eq("password", password)).add(Restrictions.eq("userType", userType)).uniqueResult();
			}
		});*/
		
		Session session = getSession();
		Query query =  session.createQuery("from UserBO where username = :username and password=:password and userType=:userType");
		query.setParameter("username", username);
		query.setParameter("password", password);
		query.setParameter("userType", userType);
		userBO= (UserBO) query.uniqueResult();
		return userBO;
	}

}
