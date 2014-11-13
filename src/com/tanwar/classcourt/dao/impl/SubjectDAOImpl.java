package com.tanwar.classcourt.dao.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.tanwar.classcourt.bo.ClassBO;
import com.tanwar.classcourt.bo.SubjectBO;
import com.tanwar.classcourt.dao.SubjectDAO;

public class SubjectDAOImpl extends HibernateDaoSupport implements SubjectDAO {

	@Override
	public void addSubject(String subjectName, String classId) {

		SubjectBO subjectBO = new SubjectBO();
		ClassBO classBO = new ClassBO();
		subjectBO.setClassBO(classBO);
		classBO.setClassId(Integer.parseInt(classId));
		subjectBO.setSubjectName(subjectName);
		subjectBO.setCreatedOn(new Date());
		getHibernateTemplate().save(subjectBO);
		System.out.println(subjectBO);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SubjectBO> getAllSubject(final String classId) {
		final ClassBO classBO = new ClassBO();
		classBO.setClassId(Integer.parseInt(classId));

		return (List<SubjectBO>) this.getHibernateTemplate().execute(new HibernateCallback() {
			public List<SubjectBO> doInHibernate(Session session) throws HibernateException {
				return (List<SubjectBO>) session.createCriteria(SubjectBO.class).add(Restrictions.eq("classBO.classId", Integer.parseInt(classId))).list();
			}
		});

	}
	/*@SuppressWarnings("unchecked")
	public List<SubjectBO> getAllSubject(final String classId){
		List<SubjectBO> subjectBOs = new ArrayList<SubjectBO>();
		String allSubjectQuery = "select subjectId, subjectName from SubjectBO where classBO.classId="+classId;
		Session session = this.getHibernateTemplate().getSessionFactory().openSession();
		try{
			if(session!=null){
				List<Object[]> subjectBOList = (List<Object[]>)session.createSQLQuery(allSubjectQuery).list();
				
				if(subjectBOList!=null && subjectBOList.size() > 0){
					for(Object[] subjectBOObj: subjectBOList){
						SubjectBO subjectBO = new SubjectBO();
						subjectBO.setSubjectId(Integer.parseInt(String.valueOf(subjectBOObj[0])));
						subjectBO.setSubjectName(String.valueOf(subjectBOObj[0]));
						subjectBOs.add(subjectBO);
					}
				}
				subjectBOList = null;
			}
		}finally {
			if (session != null) {
				session.close();
			}
		}
			return subjectBOs;
	}*/

	@Override
	public void deleteSubject(int subjectId) {
		SubjectBO subjectBO = new SubjectBO();
		subjectBO.setSubjectId(subjectId);
		getHibernateTemplate().delete(subjectBO);
	}

	
	
	

}
