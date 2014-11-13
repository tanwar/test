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

import com.tanwar.classcourt.bo.SubjectBO;
import com.tanwar.classcourt.bo.UserBO;
import com.tanwar.classcourt.service.SubjectService;

@Controller
public class SubjectController {

	private SubjectService subjectService;

	@Autowired
	public void setSubjectService(SubjectService subjectService) {
		this.subjectService = subjectService;
	}

	@RequestMapping(value = "/addSubject.htm", method = RequestMethod.POST)
	protected void addSubject(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String classId = request.getParameter("classId");
		String subjectName = request.getParameter("subjectName");
		subjectService.addSubject(subjectName, classId);
		System.out.println("add");
		response.sendRedirect("./viewSubjects.htm?classId=" + classId);
	}

	@RequestMapping(value = "/deleteSubject.htm", method = RequestMethod.GET)
	protected void deleteSubject(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String subjectId = request.getParameter("subjectId");
		String classId = request.getParameter("classId");
		subjectService.deleteSubject(Integer.parseInt(subjectId));
		System.out.println("add");
		response.sendRedirect("./viewSubjects.htm?subjectId=" + subjectId + "&classId=" + classId);
	}

	@RequestMapping(value = "/viewSubjects.htm", method = RequestMethod.GET)
	protected ModelAndView viewSubject(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession httpSession = request.getSession();
		UserBO userBO = (UserBO) httpSession.getAttribute("userBO");
		if (userBO == null) {
			return new ModelAndView("AdminLogin", "loginMsg", "Session Expired! Please try again.");
		} else {
			String classId = request.getParameter("classId");
			List<SubjectBO> subjectBOList = subjectService.getAllSubject(classId);
			System.out.println(subjectBOList);
			return new ModelAndView("viewSubjects", "subjectBOList", subjectBOList);
		}
	}
	
	
	//
	@RequestMapping(value = "/viewClassSubjects.htm", method = RequestMethod.GET)
	protected ModelAndView viewClassSubjects(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession httpSession = request.getSession();
		UserBO userBO = (UserBO) httpSession.getAttribute("userBO");
		if (userBO == null) {
			return new ModelAndView("AdminLogin", "loginMsg", "Session Expired! Please try again.");
		} else {
			String classId = request.getParameter("classId");
			List<SubjectBO> subjectBOList = subjectService.getAllSubject(classId);
			request.getSession().setAttribute("classId", classId);
			System.out.println("viewClassSubjects: "+subjectBOList);
			return new ModelAndView("viewClassSubjects", "subjectBOList", subjectBOList);
		}
	}

}
