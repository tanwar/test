package com.tanwar.classcourt.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.tanwar.classcourt.bo.ChapterBO;
import com.tanwar.classcourt.bo.SubjectBO;
import com.tanwar.classcourt.dao.ChapterDAO;

public class ChapterDAOImpl extends HibernateDaoSupport implements ChapterDAO {

	@Override
	public void addChatper(String subjectId, String chapterTitle, String chapterContent) {

		ChapterBO chapterBO= new ChapterBO();
		chapterBO.setChapterTitle(chapterTitle);
		//chapterBO.setChatperContent(chapterContent);
		SubjectBO subjectBO = new SubjectBO();
		subjectBO.setSubjectId(Integer.parseInt(subjectId));
		chapterBO.setSubjectBO(subjectBO);
		getHibernateTemplate().save(chapterBO);
		System.out.println(chapterBO);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ChapterBO> getAllChapters(final String subjectId) {
		return (List<ChapterBO>) this.getHibernateTemplate().execute(new HibernateCallback() {
			public List<ChapterBO> doInHibernate(Session session) throws HibernateException {
				return (List<ChapterBO>) session.createCriteria(ChapterBO.class).add(Restrictions.eq("subjectBO.subjectId", Integer.parseInt(subjectId))).list();
			}
		});

	}

	@Override
	public void deleteChapter(int chapterId) {
		ChapterBO chapterBO= new ChapterBO();
		chapterBO.setChapterId(chapterId);
		getHibernateTemplate().delete(chapterBO);
	}
}
