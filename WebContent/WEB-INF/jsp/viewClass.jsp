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
<title>Class Court Admin :: View Class</title>
</head>
<body>
<div align="center">
<display:table  name="requestScope.classBOList" pagesize="10" sort="list" requestURI="/viewClass.htm" decorator="com.tanwar.classcourt.util.ClassCourtTableDecorator">  
    <display:column property="className" title="Class Name" sortable="true" headerClass="sortable" maxWords="10" />
    <display:column title="View Subjects" value="View" href="viewSubjects.htm" paramId="classId" paramProperty="classId" />
    <display:column title="Delete Class" value="Delete" property="classLink" />
</display:table>
</div>


<form action="./addClass.htm" method="POST">
<input type="hidden" name="boardId" value="<%=request.getParameter("boardId")%>"/>
<table align="center">
	<tr>
		<td>Class Name:</td>
		<td><input type="text" name="className"/></td>
	</tr>
	<tr>
		<td colspan="2" align="center" ><input type="submit" value="Add Class" /></td>
	</tr>
</table>
</form>

</body>
</html>