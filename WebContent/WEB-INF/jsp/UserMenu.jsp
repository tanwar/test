
<%
	List<BoardBO> boardBOList = (List<BoardBO>) session
			.getAttribute("boardList");
%>

<%@page import="java.util.List"%>

<%@page import="com.tanwar.classcourt.bo.BoardBO"%>
<div id='osx-modal'>
			
<TABLE border=0 cellSpacing=0 cellPadding=0>
	<TBODY>
		<%
			for (BoardBO boardBO : boardBOList) {
		%>
	
		<TR>
			<TD class="leftnav-a"><a name='osx' class='osx demo' style='cursor: hand; cusror: pointer;' onclick="javascript:setBoard('<%=boardBO.getBoardId()%>','<%=boardBO.getBoardName()%>');"><%=boardBO.getBoardName()%></a></TD>
		</TR>
		<%
			}
		%>
		<tr>
			<td><a class=leftnav-a href="viewBoard.htm">Add Boards</a></td>
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