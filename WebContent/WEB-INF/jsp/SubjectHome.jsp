<%
String subjectId = request.getParameter("subjectId"); 
String subjectName = request.getParameter("subjectName");
%>
<br/>
<h3><%=subjectName%></h3>
<TABLE border=0 width="100%">
	<TBODY>
		<TR>
			<TD>&nbsp;</TD>
			<TD>&nbsp;</TD>
			<TD>&nbsp;</TD>
		</TR>
		<TR>
			<TD><A href="studySourceType.htm?type=study&subjectId=<%=subjectId%>"><IMG border=0
					src="images/Untitled-3.jpg" width=239 height=141></A></TD>
			<TD><A href="studySourceType.htm?type=ncert&subjectId=<%=subjectId%>"><IMG border=0
					src="images/Copy of Untitled-3.jpg" width=239 height=141></A></TD>
			<TD><A href="studySourceType.htm?type=test&subjectId=<%=subjectId%>"><IMG border=0
					src="images/Copy (2) of Untitled-3.jpg" width=239 height=141></A></TD>
		</TR>
		<TR>
			<TD><A href="studySourceType.htm?type=revision&subjectId=<%=subjectId%>"><IMG border=0
					src="images/Copy (3) of Untitled-3 copy.jpg" width=239 height=141></A></TD>
			<TD><A href="studySourceType.htm?type=boardPapers&subjectId=<%=subjectId%>"><IMG border=0
					src="images/Copy (4) of Untitled-3.jpg" width=239 height=141></A></TD>
			<TD><A href="studySourceType.htm?type=modelTestPapers&subjectId=<%=subjectId%>"><IMG border=0
					src="images/Copy (5) of Untitled-3.jpg" width=239 height=141></A></TD>
		</TR>
	</TBODY>
</TABLE>