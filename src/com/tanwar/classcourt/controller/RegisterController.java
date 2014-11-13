package com.tanwar.classcourt.controller;

import java.util.ArrayList;
import java.util.HashMap;
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
import com.tanwar.classcourt.bo.ClassBO;
import com.tanwar.classcourt.bo.UserBO;
import com.tanwar.classcourt.service.RegisterService;

@Controller
public class RegisterController {

	private RegisterService registerService;

	@Autowired
	public void setRegisterService(RegisterService registerService) {
		this.registerService = registerService;
	}

	@RequestMapping(value = {"/RegisterUserScreen.htm","/modifyUserLink.htm"}, method = RequestMethod.GET)
	protected ModelAndView redirectUser(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		HttpSession session = request.getSession(false);
		UserBO userBO = (UserBO)session.getAttribute("userBO");
		List<BoardBO> boardList = registerService.getBoardNames();
		ArrayList<String> boardNames = new ArrayList<String>();
		ArrayList<Integer> boardId = new ArrayList<Integer>();
		HashMap<ArrayList<Integer>, ArrayList<String>> boardNameIdMap = new HashMap<ArrayList<Integer>, ArrayList<String>>();
		for (int i = 0; i < boardList.size(); i++) {
			boardNames.add(boardList.get(i).getBoardName());
			boardId.add(boardList.get(i).getBoardId());
			boardNameIdMap.put(boardId, boardNames);
		}
		session.setAttribute("userBO", userBO);
		if("/RegisterUserScreen.htm".equals(request.getServletPath()))
		return new ModelAndView("RegisterUser", "boardNameIdMap", boardNameIdMap);
		else 
		return new ModelAndView("userModify", "boardNameIdMap", boardNameIdMap);
	}

	@RequestMapping(value = {"/RegisterUser.htm", "/modifyUserComplete.htm"}, method = RequestMethod.POST)
	protected ModelAndView registerUser(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String action = request.getParameter("action");
		String boardId = request.getParameter("boardId");
		String userName = request.getParameter("fullName");
		String name = request.getParameter("name");
		String emailId = request.getParameter("emailId");
		String classId = request.getParameter("classNames");
		String mobile = request.getParameter("mobile");
		String userType = request.getParameter("userType");
		String password = request.getParameter("password");
		String confirmPass = request.getParameter("confirmPassword");
		String userId  = (String)request.getParameter("userId");
		if ("getClassNames".equalsIgnoreCase(action)) {
			List<BoardBO> boardList = registerService.getBoardNames();
			ArrayList<String> boardNames = new ArrayList<String>();
			ArrayList<Integer> boardId1 = new ArrayList<Integer>();
			ArrayList<String> classNames = new ArrayList<String>();
			ArrayList<Integer> classIds = new ArrayList<Integer>();
			HashMap<ArrayList<Integer>, ArrayList<String>> boardNameIdMap = new HashMap<ArrayList<Integer>, ArrayList<String>>();
			HashMap<ArrayList<Integer>, ArrayList<String>> classNameIdMap = new HashMap<ArrayList<Integer>, ArrayList<String>>();
			for (int i = 0; i < boardList.size(); i++) {
				boardNames.add(boardList.get(i).getBoardName());
				boardId1.add(boardList.get(i).getBoardId());
				boardNameIdMap.put(boardId1, boardNames);
			}
			request.setAttribute("boardNameIdMap", boardNameIdMap);
			
			if(boardId!=null && !"".equals(boardId)){
			List<ClassBO> classList = registerService.getBoardClass(boardId);
			for (int i = 0; i < classList.size(); i++) {
				classNames.add(classList.get(i).getClassName());
				classIds.add(classList.get(i).getClassId());
				classNameIdMap.put(classIds, classNames);
			}
			}
			request.setAttribute("userName", userName);
			request.setAttribute("name", name);
			request.setAttribute("emailId", emailId);
			request.setAttribute("Mobile", mobile);
			request.setAttribute("userType", userType);
			request.setAttribute("password", password);
			request.setAttribute("confirmPass", confirmPass);
			if("/RegisterUser.htm".equals(request.getServletPath()))
			return new ModelAndView("RegisterUser", "classNameIdMap", classNameIdMap);
			else
			return new ModelAndView("userModify", "classNameIdMap", classNameIdMap);	
		} else {
			if ( (password==null|| "".equals(password)) && (confirmPass==null|| "".equals(confirmPass))
					&& (boardId==null || boardId=="") && (classId==null || classId=="")) {
				request.setAttribute("userName", userName);
				request.setAttribute("name", name);
				request.setAttribute("emailId", emailId);
				request.setAttribute("Mobile", mobile);
				request.setAttribute("userType", userType);
				request.setAttribute("password", password);
				request.setAttribute("confirmPass", confirmPass);
				if(!password.equals(confirmPass)){
					if("/RegisterUser.htm".equals(request.getServletPath()) )
						return new ModelAndView("RegisterUser", "passwordDoesntMatch", "Please enter the valid values!");
						else 
							return new ModelAndView("userModify", "passwordDoesntMatch", "Please enter the valid values!");
					} else{
				List<BoardBO> boardList = registerService.getBoardNames();
				ArrayList<String> boardNames = new ArrayList<String>();
				ArrayList<Integer> boardId1 = new ArrayList<Integer>();
				ArrayList<String> classNames = new ArrayList<String>();
				ArrayList<Integer> classIds = new ArrayList<Integer>();
				HashMap<ArrayList<Integer>, ArrayList<String>> boardNameIdMap = new HashMap<ArrayList<Integer>, ArrayList<String>>();
				HashMap<ArrayList<Integer>, ArrayList<String>> classNameIdMap = new HashMap<ArrayList<Integer>, ArrayList<String>>();
				for (int i = 0; i < boardList.size(); i++) {
					boardNames.add(boardList.get(i).getBoardName());
					boardId1.add(boardList.get(i).getBoardId());
					boardNameIdMap.put(boardId1, boardNames);
				}
				request.setAttribute("boardNameIdMap", boardNameIdMap);
				if(boardId!=null && !"".equals(boardId)){
				List<ClassBO> classList = registerService.getBoardClass(boardId);
				for (int i = 0; i < classList.size(); i++) {
					classNames.add(classList.get(i).getClassName());
					classIds.add(classList.get(i).getClassId());
					classNameIdMap.put(classIds, classNames);
				}
				}
				if("/RegisterUser.htm".equals(request.getServletPath()) && "".equals(action))
				return new ModelAndView("RegisterUser", "passwordDoesntMatch", "Please enter the valid values!");
				else 
					return new ModelAndView("userModify", "passwordDoesntMatch", "Please enter the valid values!");
			}} else {
				
				registerService.registerUser(name, userName, emailId, classId, mobile, userType, password);
				if("/RegisterUser.htm".equals(request.getServletPath()))
				return new ModelAndView("AdminLogin", "registerMsg", "Your account has been created successfully!");
				
				else{ 
				registerService.modifyUser(name,userId,userName, emailId, classId, mobile, userType, password);
				HttpSession session = request.getSession(false);
				session.invalidate();
					return new ModelAndView("AdminLogin", "registerMsg", "Your account has been modified successfully.Please login again to continue!");
				}
			}
		}
	}

}
