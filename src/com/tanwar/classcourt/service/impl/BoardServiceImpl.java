package com.tanwar.classcourt.service.impl;

import java.util.List;

import com.tanwar.classcourt.bo.BoardBO;
import com.tanwar.classcourt.dao.BoardDAO;
import com.tanwar.classcourt.service.BoardService;

public class BoardServiceImpl implements BoardService {

	private BoardDAO boardDAO;
	

	public void setBoardDAO(BoardDAO boardDAO) {
		this.boardDAO = boardDAO;
	}


	@Override
	public void addBoard(String boardId, String boardName) {
		boardDAO.addBoard(boardId, boardName);
	}

	@Override
	public List<BoardBO> getAllBoards() {
		return boardDAO.getAllBoards();
	}


	@Override
	public void deleteBoard(String boardId) {
		boardDAO.deleteBoard(boardId);
		
	}
	

}
