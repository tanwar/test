package com.tanwar.classcourt.controller;

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.tanwar.classcourt.bo.UploadContentBO;
import com.tanwar.classcourt.bo.UserBO;
import com.tanwar.classcourt.service.UploadedContentService;

@Controller
public class UploadContentController {

	private UploadedContentService uploadService;

	@Autowired
	public void setUploadService(UploadedContentService uploadService) {
		this.uploadService = uploadService;
	}


	@RequestMapping(value = "/addContent.htm", method = RequestMethod.POST)
	protected void addContent(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String chapterId = request.getParameter("chapterId");
		String contentName = request.getParameter("contentName");
		String userId = request.getParameter("userId");
		String contentType = request.getParameter("contentType");
		
		
		String fileName = null;
		File savedFile = null;
		String itemName = null;
		String fileInDB = null;
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		if (!isMultipart) {
		} else {
			FileItemFactory factory = new DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload(factory);
			List items = null;
			try {
				items = upload.parseRequest(request);
			} catch (FileUploadException e) {
				e.printStackTrace();
			}
			Iterator itr = items.iterator();

			while (itr.hasNext()) {
				FileItem item = (FileItem) itr.next();

				if (item.isFormField()) {
					try {
						if (item.getFieldName().equals("chapterId")) {
							chapterId = item.getString();
						} else if (item.getFieldName().equals("contentName")) {
							contentName = item.getString();
						}else if (item.getFieldName().equals("userId")) {
							userId = item.getString();
						}else if (item.getFieldName().equals("contentType")) {
							contentType = item.getString();
						}
					} catch (Exception e) {
					}
				} else {
					try {

						itemName = item.getName();
						fileName = itemName;
						fileName = request.getRealPath("/") + "appItems/" + itemName;
						fileInDB = itemName;
						savedFile = new File(fileName);
						item.write(savedFile);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}

			}
		}
		System.out.println("contentType: "+contentType+"; userId: "+userId+"; contentName: " + contentName + "; chapterId: " + chapterId + "; file: " + savedFile.getAbsolutePath());
		
		  FileInputStream fileInputStream = new FileInputStream(savedFile);
		  byte[] chapterContent = new byte[(int)savedFile.length()]; //convert
		 // file into array of bytes 
		  fileInputStream.read(chapterContent);
		  fileInputStream.close();
		 

		  uploadService.addContent(chapterId, contentName, contentType, fileInDB, chapterContent, Integer.parseInt(userId));
		System.out.println("add content");
		response.sendRedirect("./viewUploaded.htm?chapterId=" + chapterId);
	}

	@RequestMapping(value = "/deleteContent.htm", method = RequestMethod.GET)
	protected void deleteContent(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String contentId = request.getParameter("contentId");
		String chapterId = request.getParameter("chapterId");
		uploadService.deleteContent(Integer.parseInt(contentId));
		System.out.println("delete");
		response.sendRedirect("./viewUploaded.htm?chapterId=" + chapterId);
	}

	@RequestMapping(value = "/viewUploaded.htm", method = RequestMethod.GET)
	protected ModelAndView viewContent(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession httpSession = request.getSession();
		UserBO userBO = (UserBO) httpSession.getAttribute("userBO");
		if (userBO == null) {
			return new ModelAndView("AdminLogin", "loginMsg", "Session Expired! Please try again.");
		} else {
			String chapterId = request.getParameter("chapterId");
			List<UploadContentBO> uploadBOs = uploadService.getAllContent(chapterId);
			request.getSession().setAttribute("uploadBOs", uploadBOs);
			System.out.println(uploadBOs);
			request.setAttribute("allUploads", "No");
			return new ModelAndView("viewUploadedContents", "uploadBOs", uploadBOs);
		}
	}
	
	
	@RequestMapping(value = "/viewAllContents.htm", method = RequestMethod.GET)
	protected ModelAndView viewAllContent(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession httpSession = request.getSession();
		UserBO userBO = (UserBO) httpSession.getAttribute("userBO");
		if (userBO == null) {
			return new ModelAndView("AdminLogin", "loginMsg", "Session Expired! Please try again.");
		} else {
			//String chapterId = request.getParameter("chapterId");
			List<UploadContentBO> uploadBOs = uploadService.getAllContent();
			request.getSession().setAttribute("uploadBOs", uploadBOs);
			System.out.println(uploadBOs);
			request.setAttribute("allUploads", "Yes");
			return new ModelAndView("viewUploadedContents", "uploadBOs", uploadBOs);
		}
	}

	@RequestMapping(value = "/downloadContent.htm", method = RequestMethod.GET)
	protected void downloadChapter(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String contentId = request.getParameter("contentId");
		String chapterId = request.getParameter("chapterId");
		response.sendRedirect("downloadFile.jsp?contentId=" + contentId);
	}
	
	@RequestMapping(value = "/UploadedContent.htm", method = RequestMethod.GET)
	protected ModelAndView viewStudyMaterial(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession httpSession = request.getSession();
		UserBO userBO = (UserBO) httpSession.getAttribute("userBO");
		if (userBO == null) {
			return new ModelAndView("AdminLogin", "loginMsg", "Session Expired! Please try again.");
		} else {
			String chapterId = request.getParameter("chapterId");
			
			String contentType = (String)request.getSession().getAttribute("contentType");
			List<UploadContentBO> uploadBOs = uploadService.getAllContent(chapterId, contentType);
			request.getSession().setAttribute("uploadBOs", uploadBOs);
			System.out.println(uploadBOs);
			request.setAttribute("allUploads", "No");
			return new ModelAndView("viewUploadedChapterContent", "uploadBOs", uploadBOs);
		}
	}

}
