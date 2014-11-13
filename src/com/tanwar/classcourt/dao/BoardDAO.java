package com.tanwar.classcourt.dao;

import java.util.List;

import com.tanwar.classcourt.bo.BoardBO;


public interface BoardDAO {
	
	public void addBoard(String boardId, String boardName);
	public List<BoardBO> getAllBoards();
	public void deleteBoard(String boardId);

}
