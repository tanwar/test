<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.tanwar.classcourt.bo.ChapterBO"%>
<%@page import="java.util.List"%>
<%@page import="java.io.ByteArrayInputStream"%>
<%@page import="java.io.DataOutputStream"%>
<%@page import="java.io.DataOutput"%>
<%@page import="java.io.File"%>
<%@page import="java.io.FileReader"%>
<%@page import="java.io.FileInputStream"%>
<%@page import="com.tanwar.classcourt.bo.UploadContentBO"%>

<%
	String contentId = request.getParameter("contentId");
	List<UploadContentBO> uploadContentBOs = (List<UploadContentBO>) request.getSession().getAttribute("uploadBOs");
	System.out.println("uploadContentBOs in download session: "+uploadContentBOs);
	UploadContentBO uploadContentBOFinal = null;
	for (UploadContentBO uploadContentBO: uploadContentBOs) {
		if (Integer.parseInt(contentId) == uploadContentBO.getContentId()) {
			uploadContentBOFinal = uploadContentBO;
			break;
		}
	}
	System.out.println("uploadContentBOFinal:::: " + uploadContentBOFinal);

	
	//String decoded = chapterBO.getChatperContent();
	//FileInputStream fileReader = new FileInputStream(request.getRealPath("/")+uploadContentBOFinal.getContent());
	ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(uploadContentBOFinal.getContent());
	ServletOutputStream out1 = response.getOutputStream();
	
	response.setHeader("Cache-Control", "max-age=0, must-revalidate");
	
	response.setContentType("application/octet-stream");
	response.setHeader("Content-Disposition", "attachment;filename="+uploadContentBOFinal.getContentFileName());

	response.setDateHeader("Expires", 0);
	DataOutput dataOutput = new DataOutputStream(out1);
	response.setContentLength(byteArrayInputStream.available());
	int b=-1;
	while((b = byteArrayInputStream.read())!=-1){
		dataOutput.write(b);
	}

	out1.flush();
	out1.close();
%>