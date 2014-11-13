package com.tanwar.classcourt.service;

import java.util.List;
import com.tanwar.classcourt.bo.BoardBO;


public interface BoardService {
	
	public void addBoard(String boardId, String boardName);
	public void deleteBoard(String boardId);
	public List<BoardBO> getAllBoards();

}
