
<%@page import="com.tanwar.classcourt.bo.ChapterBO"%>
<%
	List<ChapterBO> chapterBOList = (List<ChapterBO>) session.getAttribute("chapterBOs");
%>

<%@page import="java.util.List"%>

<div id='osx-modal'>
			
<TABLE border=0 cellSpacing=0 cellPadding=0>
	<TBODY>
		<% String classId = (String)session.getAttribute("classId");
	String contentType = (String)session.getAttribute("contentType");
			for (ChapterBO chapterBO: chapterBOList) {
		%>
	
		<TR>
			<TD class="leftnav-a"><a href="./UploadedContent.htm?contentType=<%=contentType%>&chapterId=<%=chapterBO.getChapterId()%>"><%=chapterBO.getChapterTitle()%></a></TD>
		</TR>
		<%
			}
		%>
		<tr>
			<td><a class=leftnav-a href="viewClassSubjects.htm?classId=<%=classId%>">Back</a></td>
		</tr>

		<!--<tr>
			<td><a class=leftnav-a href="viewAllContents.htm">Upload</a></td>
		</tr>
		--><tr>
			<td></td>
		</tr>
		<tr>
			<td><a class=leftnav-a href="Logout.htm">Logout</a></td>
		</tr>
	</TBODY>
</TABLE>
		</div>