package com.tanwar.classcourt.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.tanwar.classcourt.bo.BoardBO;
import com.tanwar.classcourt.dao.BoardDAO;

public class BoardDAOImpl extends HibernateDaoSupport implements BoardDAO {

	@Override
	public void addBoard(String boardId, String boardName) {

		BoardBO boardBO = new BoardBO();
		if(boardId!=null && boardId.trim().length()>0){
			boardBO.setBoardId(Integer.parseInt(boardId));
		}
		boardBO.setBoardName(boardName);
		getHibernateTemplate().saveOrUpdate(boardBO);
		System.out.println(boardBO);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<BoardBO> getAllBoards() {

		return (List<BoardBO>) this.getHibernateTemplate().execute(new HibernateCallback() {
			public List<BoardBO> doInHibernate(Session session) throws HibernateException {
				return (List<BoardBO>) session.createCriteria(BoardBO.class).list();
			}
		});

	}

	@Override
	public void deleteBoard(String boardId) {
		BoardBO boardBO = new BoardBO();
		boardBO.setBoardId(Integer.parseInt(boardId));
		getHibernateTemplate().delete(boardBO);
	}
	
	

}
