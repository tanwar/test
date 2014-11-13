package com.tanwar.classcourt.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.tanwar.classcourt.bo.UserBO;
import com.tanwar.classcourt.service.BoardService;
import com.tanwar.classcourt.service.SubjectService;
import com.tanwar.classcourt.service.UserService;

@Controller
public class UserController {

	private UserService userService;
	
	private SubjectService subjectService;
	
	private BoardService boardService;

	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	@Autowired
	public void setSubjectService(SubjectService subjectService) {
		this.subjectService = subjectService;
	}
	
	@Autowired
	public void setBoardService(BoardService boardService) {
		this.boardService = boardService;
	}

	@RequestMapping(value = "/ValidateUser.htm", method = RequestMethod.POST)
	protected void validateUser(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String userType = request.getParameter("usertype") != null ? request.getParameter("usertype") : "Admin";
		String username = request.getParameter("username") != null ? request.getParameter("username") : "";
		String password = request.getParameter("password") != null ? request.getParameter("password") : "";
		HttpSession httpSession = request.getSession();
		System.out.println("Validate user: "+username+"; "+userType);
		UserBO userBO = (UserBO) httpSession.getAttribute("userBO");
		if (userBO == null) {
			userBO = userService.validateUser(userType, username, password);
		}
		System.out.println("userBO: " + userBO);

		if (userBO == null) {
			response.sendRedirect("AdminLogin.htm");// , "loginMsg",
													// "Invalid Login! Please try again.");
		} else {
			
			httpSession.setAttribute("userBO", userBO);
			if("Admin".equals(userType)){
				response.sendRedirect("viewBoard.htm"); // Admin
			}else{
				response.sendRedirect("Home.htm"); // User view
			}
		}
	}

	@RequestMapping(value = "/AdminLogin.htm", method = RequestMethod.GET)
	protected ModelAndView adminLoginRedirect(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// List<BoardBO> boardBOList = boardService.getAllBoards();
		return new ModelAndView("AdminLogin", "msg", "Please log-in.");
	}
	
	@RequestMapping(value = "/extHome.htm", method = RequestMethod.GET)
	protected ModelAndView homePageRedirect(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		session.setAttribute("boardListHome",boardService.getAllBoards());
		return new ModelAndView("extHome");
	}
	

	@RequestMapping(value = "/Logout.htm", method = RequestMethod.GET)
	protected ModelAndView logoutUser(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// List<BoardBO> boardBOList = boardService.getAllBoards();
		HttpSession session = request.getSession();
		session.removeAttribute("userBO");
		session.invalidate();
		return new ModelAndView("AdminLogin", "loginMsg", "User Logged off successfully!");
	}
	
	@RequestMapping(value = "/Home.htm", method = RequestMethod.GET)
	protected ModelAndView userHome(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//fetch related infos...
		// fetch Class list for the associated board...
		HttpSession session = request.getSession();
		//UserBO userBO = (UserBO)session.getAttribute("userBO");
		session.setAttribute("boardList",boardService.getAllBoards());
		//session.setAttribute("subjectList",subjectService.getAllSubject(String.valueOf(userBO.getClassBO().getClassId())));
		return new ModelAndView("UserHome");
	}

}
