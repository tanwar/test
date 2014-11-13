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
<title>Class Court Admin :: View Chapter</title>
</head>
<body>
<div align="center">
<display:table  name="requestScope.chapterBOList" pagesize="10"  export="false" sort="list" requestURI="/viewChapter.htm" decorator="com.tanwar.classcourt.util.ClassCourtTableDecorator">  
    <display:column property="chapterTitle" title="Chapter Title" sortable="true" headerClass="sortable" maxWords="10" />
    <display:column title="View Uploaded" value="View" href="viewUploaded.htm" paramId="chapterId" paramProperty="chapterId" />
    <display:column title="Delete Chapter" value="Delete" property="chapterLink" />
</display:table>
</div>


<form action="./addChapter.htm" method="POST" >
<input type="hidden" name="subjectId" value="<%=request.getParameter("subjectId")%>"/>
<table align="center">
	<tr>
		<td>chapter title:</td>
		<td><input type="text" name="chapterTitle"/></td>
	</tr>
	<!--<tr>
		<td>chapter content:</td>
		<td><input type="file" name="chapterContent"/></td>
	</tr>
	--><tr>
		<td colspan="2" align="center" ><input type="submit" value="Add Chapter" /></td>
	</tr>
</table>
</form>

</body>
</html>