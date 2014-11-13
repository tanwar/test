package com.tanwar.classcourt.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.tanwar.classcourt.bo.ChapterBO;
import com.tanwar.classcourt.bo.UploadContentBO;
import com.tanwar.classcourt.bo.UserBO;
import com.tanwar.classcourt.dao.UploadedContentDAO;

public class UploadedContentDAOImpl extends HibernateDaoSupport implements UploadedContentDAO {

	@Override
	public void addContent(String chapterId, String contentName, String contentType, String chapterContentFileName, byte[] content, int uploadedByUser) {

		UploadContentBO uploadContentBO = new UploadContentBO();
		ChapterBO chapterBO =  new ChapterBO();
		chapterBO.setChapterId(Integer.parseInt(chapterId));
		UserBO userBO = new UserBO();
		userBO.setUserId(uploadedByUser);
		
		uploadContentBO.setChapterBO(chapterBO);
		uploadContentBO.setContentName(contentName);
		uploadContentBO.setContentFileName(chapterContentFileName);
		uploadContentBO.setContentType(contentType);
		uploadContentBO.setContent(content);
		uploadContentBO.setAddedbyUserId(userBO);
		
		getHibernateTemplate().save(uploadContentBO);
		System.out.println(uploadContentBO);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UploadContentBO> getAllContent(final String chapterId) {
		return (List<UploadContentBO>) this.getHibernateTemplate().execute(new HibernateCallback() {
			public List<UploadContentBO> doInHibernate(Session session) throws HibernateException {
				return (List<UploadContentBO>) session.createCriteria(UploadContentBO.class).add(Restrictions.eq("chapterBO.chapterId", Integer.parseInt(chapterId))).list();
			}
		});

	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<UploadContentBO> getAllContent(final String chapterId, final String contentType) {
		return (List<UploadContentBO>) this.getHibernateTemplate().execute(new HibernateCallback() {
			public List<UploadContentBO> doInHibernate(Session session) throws HibernateException {
				return (List<UploadContentBO>) session.createCriteria(UploadContentBO.class).add(Restrictions.eq("chapterBO.chapterId", Integer.parseInt(chapterId))).list();
			}
		});

	}

	
	@SuppressWarnings("unchecked")
	@Override
	public List<UploadContentBO> getAllContent() {
		return (List<UploadContentBO>) this.getHibernateTemplate().execute(new HibernateCallback() {
			public List<UploadContentBO> doInHibernate(Session session) throws HibernateException {
				return (List<UploadContentBO>) session.createCriteria(UploadContentBO.class).list();
			}
		});

	}

	@Override
	public void deleteContent(int contentId) {
		UploadContentBO uploadContentBO = new UploadContentBO();
		uploadContentBO.setContentId(contentId);
		getHibernateTemplate().delete(uploadContentBO);
	}
}
