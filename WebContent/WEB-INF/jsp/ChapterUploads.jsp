<%@page import="java.util.List"%>
<%@page import="com.tanwar.classcourt.bo.UploadContentBO"%>
<%
List<UploadContentBO> uploadBOs = (List<UploadContentBO>)session.getAttribute("uploadBOs");
UserBO userBO = (UserBO) session.getAttribute("userBO");
%>


<%@page import="com.tanwar.classcourt.bo.UserBO"%>
<TABLE border=1 cellSpacing=0 cellPadding=0 width="100%">
	<TBODY>
		<TR>
			<TD class=text width="28%"><SPAN class=text>Name /
					Submitted By</SPAN></TD>
			<TD class=text width="17%" align=middle><SPAN class=head4>Price
					/ Points </SPAN></TD>
			<TD class=text width="12%" align=middle><SPAN class=head4>Ratings</SPAN></TD>
			<TD class=text width="21%" align=middle><SPAN class=head4>Date
					Added</SPAN></TD>
			<TD class=text width="22%" align=middle><SPAN class=head4>Download</SPAN></TD>
		</TR>
		<% for(UploadContentBO contentBO : uploadBOs){
			if(contentBO.getAddedbyUserId().getUserType().equals("Admin")){
		%>
		<TR>
			<TD><%=contentBO.getContentFileName()%><BR>
			<SPAN class=bodytextsmall>By: <%=contentBO.getAddedbyUserId().getName() %></SPAN></TD>
			<TD align=middle>50</TD>
			<TD align=middle><IMG src="images/star4.gif" width=90 height=18></TD>
			<TD align=middle>02 Mar 2012</TD>
			<TD align=middle><A class=link href="downloadContent.htm?contentId=<%=contentBO.getContentId()%>&chapterId=<%=contentBO.getChapterBO().getChapterId()%>"><STRONG>Download Now</STRONG></A><BR></TD>
		</TR>
		<%}else{
			%>
			<tr><td colspan="5">No Admin Uploads found.</td></tr>
			<%
		}
			}%>
			
		<tr><td colspan="5">&nbsp;</td></tr>
		<tr><td colspan="5">&nbsp;</td></tr>
		
		<TR>
			<TD class=text width="28%"><SPAN class=text>Name /
					Submitted By</SPAN></TD>
			<TD class=text width="17%" align=middle><SPAN class=head4>Price
					/ Points </SPAN></TD>
			<TD class=text width="12%" align=middle><SPAN class=head4>Ratings</SPAN></TD>
			<TD class=text width="21%" align=middle><SPAN class=head4>Date
					Added</SPAN></TD>
			<TD class=text width="22%" align=middle><SPAN class=head4>Download</SPAN></TD>
		</TR>
		<% for(UploadContentBO contentBO : uploadBOs){
			if(!contentBO.getAddedbyUserId().getUserType().equals("Admin")){
		%>
		<TR>
		<%//out.println("1: " + contentBO.getContentFileName()); %>
			<TD><%=contentBO.getContentFileName()%><BR>
			<SPAN class=bodytextsmall>By: <%=contentBO.getAddedbyUserId().getName() %></SPAN></TD>
			<TD align=middle>50</TD>
			<TD align=middle><IMG src="images/star4.gif" width=90 height=18></TD>
			<TD align=middle>02 Mar 2012</TD>
			<TD align=middle><A class=link
				href="http://classcourt.com/new/study-material.html#"><STRONG>Download
						Now</STRONG></A><BR>
			<SPAN class=bodytextsmall>Size: 256 KB<BR>Total
					Downloads: 12541
			</SPAN></TD>
		</TR>
		<%}else{
			%>
			<tr><td colspan="5">No User Uploads found.</td></tr>
			<%
		}
			}%>	
	</TBODY>
</TABLE>