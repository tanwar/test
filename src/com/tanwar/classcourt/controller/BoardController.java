package com.tanwar.classcourt.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.tanwar.classcourt.bo.BoardBO;
import com.tanwar.classcourt.bo.UserBO;
import com.tanwar.classcourt.service.BoardService;

@Controller
public class BoardController {

	private BoardService boardService;

	@Autowired
	public void setBoardService(BoardService boardService) {
		this.boardService = boardService;
	}

	@RequestMapping(value = "/addBoard.htm", method = RequestMethod.POST)
	protected void addBoard(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String boardName = request.getParameter("boardName");
		String boardId = request.getParameter("boardId");
		boardService.addBoard(boardId, boardName);
		System.out.println("add");
		// return new ModelAndView("redirectViewBoard");
		response.sendRedirect("./viewBoard.htm");
	}

	@RequestMapping(value = "/deleteBoard.htm", method = RequestMethod.GET)
	protected void deleteBoard(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String boardName = request.getParameter("boardId");
		boardService.deleteBoard(boardName);
		System.out.println("delete");
		// return new ModelAndView("redirect:viewBoard.htm");
		response.sendRedirect("./viewBoard.htm");
	}

	@RequestMapping(value = "/viewBoard.htm", method = RequestMethod.GET)
	protected ModelAndView viewBoard(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession httpSession = request.getSession();
		UserBO userBO = (UserBO) httpSession.getAttribute("userBO");
		if (userBO == null) {
			return new ModelAndView("AdminLogin", "loginMsg", "Session Expired! Please try again.");
		} else {
			List<BoardBO> boardBOList = boardService.getAllBoards();
			System.out.println(boardBOList);
			return new ModelAndView("viewBoard", "boardBOList", boardBOList);
		}
	}

}
