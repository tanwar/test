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

import com.tanwar.classcourt.bo.ClassBO;
import com.tanwar.classcourt.bo.UserBO;
import com.tanwar.classcourt.service.ClassService;

@Controller
public class ClassController {

	private ClassService classService;

	@Autowired
	public void setClassService(ClassService classService) {
		this.classService = classService;
	}

	@RequestMapping(value = "/addClass.htm", method = RequestMethod.POST)
	protected void addClass(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String boardId = request.getParameter("boardId");
		String className = request.getParameter("className");
		classService.addClass(className, boardId);
		System.out.println("add");
		response.sendRedirect("./viewClass.htm?boardId=" + boardId);
	}

	@RequestMapping(value = "/deleteClass.htm", method = RequestMethod.GET)
	protected void deleteClass(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String classId = request.getParameter("classId");
		String boardId = request.getParameter("boardId");
		classService.deleteClass(Integer.parseInt(classId));
		System.out.println("add");
		response.sendRedirect("./viewClass.htm?boardId=" + boardId + "&classId=" + classId);
		// return new ModelAndView("redirect:viewClass.htm");
	}

	@RequestMapping(value = "/viewClass.htm", method = RequestMethod.GET)
	protected ModelAndView viewClass(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession httpSession = request.getSession();
		UserBO userBO = (UserBO) httpSession.getAttribute("userBO");
		if (userBO == null) {
			return new ModelAndView("AdminLogin", "loginMsg", "Session Expired! Please try again.");
		} else {
			String boardId = request.getParameter("boardId");
			List<ClassBO> classBOList = classService.getAllClass(boardId);
			System.out.println(classBOList);
			return new ModelAndView("viewClass", "classBOList", classBOList);
		}
	}

}
