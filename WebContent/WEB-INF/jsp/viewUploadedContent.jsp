<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@page import="java.util.List, com.tanwar.classcourt.bo.ClassBO"%>

<%@page import="com.tanwar.classcourt.bo.UserBO"%><html>
<head>
<link rel="stylesheet" href="css/displaytag.css" type="text/css">  
<link rel="stylesheet" href="css/screen.css" type="text/css">  
<link rel="stylesheet" href="css/site.css" type="text/css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>
<%UserBO userBO = (UserBO) session.getAttribute("userBO"); %>
<div align="center">
<display:table  name="requestScope.uploadBOs" pagesize="10"  export="false" sort="list" requestURI="/viewUploaded.htm" decorator="com.tanwar.classcourt.util.ClassCourtTableDecorator">  
    <display:column property="contentName" title="Content Name" sortable="true" headerClass="sortable" maxWords="10" />
     <display:column title="Content Type"  property="contentType"/>
    <display:column title="Download file" value="download" property="contentFileDownloadLink" />
    <display:column title="Delete Content" value="Delete" property="deleteContentLink" />
</display:table>
</div>

<%
String allUploads = (String)request.getAttribute("allUploads");
if(allUploads!=null && allUploads.equals("No")){
%>
<form action="./addContent.htm" method="POST" enctype="multipart/form-data" >
<input type="hidden" name="chapterId" value="<%=request.getParameter("chapterId")%>"/>
<input type="hidden" name="userId" value="<%=userBO.getUserId()%>"/>
<table align="center">
	<tr>
		<td>Content Name:</td>
		<td><input type="text" name="contentName"/></td>
	</tr>
	<tr>
		<td>Content:</td>
		<td><input type="file" name="content"/></td>
	</tr>
	<tr>
		<td>Content Type:</td>
		<td><select name="contentType">
		<option value="Assignment">Assignment</option>
		<option value="study">Study Material</option>
		<option value="ncert">NCERT Solutions</option>
		<option value="revision">Revision Notes</option>
		<option value="boardPapers">Board Papers</option>
		<option value="modelTestPapers">Model Test Papers</option>
		<option value="Tutorial">Tutorial</option>
		</select> </td>
	</tr>
	<tr>
		<td colspan="2" align="center" ><input type="submit" value="Add Content" /></td>
	</tr>
</table>
</form>
<%} %>
</body>
</html>