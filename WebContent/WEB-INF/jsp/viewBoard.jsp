<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@page import="java.util.List, com.tanwar.classcourt.bo.BoardBO"%>

<html>
<head>
<link rel="stylesheet" href="css/displaytag.css" type="text/css">  
<link rel="stylesheet" href="css/screen.css" type="text/css">  
<link rel="stylesheet" href="css/site.css" type="text/css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript">
function updateBoard(boardId, boardName){
	document.getElementById("boardId").value=boardId;
	document.getElementById("boardNameId").value=boardName.replace("__"," ");
	document.getElementById("submitId").value="Update Board";
}

function resetValues(){
	document.getElementById("boardId").value='';
	document.getElementById("boardNameId").value='';
	document.getElementById("submitId").value="Add Board";
}
</script>
</head>
<body>
<div align="center">
<display:table  id="boardList" name="requestScope.boardBOList" pagesize="10" sort="list" requestURI="/viewBoard.htm" decorator="com.tanwar.classcourt.util.ClassCourtTableDecorator">  
    <display:column property="boardName" title="Board Name" sortable="true" headerClass="sortable" maxWords="10" />
    <display:column title="View Class" value="View" href="viewClass.htm" paramId="boardId" paramProperty="boardId" />
    <display:column  title="Update Board" value="Update" property="boardUpdateLink"  />
    <display:column title="Delete Board" value="Delete" href="deleteBoard.htm" paramId="boardId" paramProperty="boardId" />
</display:table>
</div>


<form action="./addBoard.htm" method="POST">
<input type="hidden" name="boardId" id="boardId" />
<table align="center">
	<tr>
		<td>Board Name:</td>
		<td><input id="boardNameId" type="text" name="boardName"/></td>
	</tr>
	<tr>
		<td align="center" ><input id="submitId" type="submit" value="Add Board" /></td>
		<td align="center" ><input id="resetId" type="reset" value="Reset" onclick="resetValues();" /></td>
	</tr>
</table>
</form>

</body>
</html>