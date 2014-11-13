<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@page import="java.util.List, com.tanwar.classcourt.bo.ClassBO"%>
<html>
<head>
<link rel="stylesheet" href="css/displaytag.css" type="text/css">  
<link rel="stylesheet" href="css/screen.css" type="text/css">  
<link rel="stylesheet" href="css/site.css" type="text/css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Class Court Admin :: View Subjects</title>
</head>
<body>
<div align="center">
<display:table  name="requestScope.subjectBOList" pagesize="10"  sort="list" requestURI="/viewSubjects.htm" decorator="com.tanwar.classcourt.util.ClassCourtTableDecorator">  
    <display:column property="subjectName" title="Subject Name" sortable="true" headerClass="sortable" maxWords="10" />
    <display:column title="View Chapters" value="View" href="viewChapters.htm" paramId="subjectId" paramProperty="subjectId" />
    <display:column title="Delete Subject" value="Delete" property="subjectLink" />
</display:table>
</div>


<form action="./addSubject.htm" method="POST">
<input type="hidden" name="classId" value="<%=request.getParameter("classId")%>"/>
<table align="center">
	<tr>
		<td>Subject Name:</td>
		<td><input type="text" name="subjectName"/></td>
	</tr>
	<tr>
		<td colspan="2" align="center" ><input type="submit" value="Add Subject" /></td>
	</tr>
</table>
</form>

</body>
</html>