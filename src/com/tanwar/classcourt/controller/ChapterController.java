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

import com.tanwar.classcourt.bo.ChapterBO;
import com.tanwar.classcourt.bo.UserBO;
import com.tanwar.classcourt.service.ChapterService;

@Controller
public class ChapterController {

	private ChapterService chapterService;

	@Autowired
	public void setChapterService(ChapterService chapterService) {
		this.chapterService = chapterService;
	}

	@RequestMapping(value = "/addChapter.htm", method = RequestMethod.POST)
	protected void addChapter(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String subjectId = request.getParameter("subjectId");
		String chapterTitle = request.getParameter("chapterTitle");
		
		
		System.out.println("chapter: " + chapterTitle + "; subject: " + subjectId);// + "; file: " + savedFile.getAbsolutePath());

		chapterService.addChatper(subjectId, chapterTitle, "");
		System.out.println("add chapter");
		response.sendRedirect("./viewChapters.htm?subjectId=" + subjectId);
	}

	@RequestMapping(value = "/deleteChapter.htm", method = RequestMethod.GET)
	protected void deleteSubject(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String subjectId = request.getParameter("subjectId");
		String chapterId = request.getParameter("chapterId");
		chapterService.deleteChapter(Integer.parseInt(chapterId));
		System.out.println("delete");
		response.sendRedirect("./viewChapters.htm?subjectId=" + subjectId);
	}

	@RequestMapping(value = "/viewChapters.htm", method = RequestMethod.GET)
	protected ModelAndView viewSubject(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession httpSession = request.getSession();
		UserBO userBO = (UserBO) httpSession.getAttribute("userBO");
		if (userBO == null) {
			return new ModelAndView("AdminLogin", "loginMsg", "Session Expired! Please try again.");
		} else {
			String subjectId = request.getParameter("subjectId");
			List<ChapterBO> chapterBOs = chapterService.getAllChapters(subjectId);
			request.getSession().setAttribute("chapterBOs", chapterBOs);
			System.out.println(chapterBOs);
			return new ModelAndView("viewChapters", "chapterBOList", chapterBOs);
		}
	}

	@RequestMapping(value = "/downloadChapter.htm", method = RequestMethod.GET)
	protected void downloadChapter(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String subjectId = request.getParameter("subjectId");
		String chapterId = request.getParameter("chapterId");
		response.sendRedirect("downloadFile.jsp?chapterId=" + chapterId);
	}
	
	@RequestMapping(value = "/studySourceType.htm", method = RequestMethod.GET)
	protected ModelAndView getChapterLists(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession httpSession = request.getSession();
		UserBO userBO = (UserBO) httpSession.getAttribute("userBO");
		if (userBO == null) {
			return new ModelAndView("AdminLogin", "loginMsg", "Session Expired! Please try again.");
		} else {
			String subjectId = request.getParameter("subjectId");
			String type = request.getParameter("type");
			List<ChapterBO> chapterBOs = chapterService.getAllChapters(subjectId);
			request.getSession().setAttribute("chapterBOs", chapterBOs);
			System.out.println(chapterBOs);
			
			String target = null;
			if(type.equals("study")){
				//get study material
				target = "UserStudyHome";
				request.getSession().setAttribute("contentType", "StudyMaterial");
			}else if(type.equals("ncert")){
				target = "UserNcertSols";
				request.getSession().setAttribute("contentType", "ncert");
			}else if(type.equals("test")){
				target = "UserTest";
				request.getSession().setAttribute("contentType", "test");
			}else if(type.equals("revision")){
				target = "UserRevision";
				request.getSession().setAttribute("contentType", "revision");
			}else if(type.equals("boardPapers")){
				target = "UserBoardPaper";
				request.getSession().setAttribute("contentType", "boardPapers");
			}else if(type.equals("modelTestPapers")){
				target = "UserModelPaper";
				request.getSession().setAttribute("contentType", "modelTestPapers");
			}
			return new ModelAndView(target, "chapterBOList", chapterBOs);
		}
	}

}
