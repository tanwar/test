

<%@page import="com.tanwar.classcourt.bo.UserBO"%>
<link href="css/style.css" rel="stylesheet" type="text/css">
<link href="css/style2.css" rel="stylesheet" type="text/css">
<link href="css/class.css" rel="stylesheet" type="text/css">
<link type='text/css' href='css/demo.css' rel='stylesheet' media='screen' />
<link type='text/css' href='css/osx.css' rel='stylesheet' media='screen' />
<style type="text/css">
<!--
.style2 {
	font-family: Verdana, Arial, Helvetica, sans-serif;
	color: #FFFFFF;
	font-size: 12px;
	font-weight: bold;
}
-->
</style>
<script type='text/javascript' src='js/jquery.js'></script>
<script type='text/javascript' src='js/jquery.simplemodal.js'></script>
<script type='text/javascript' src='js/osx.js'></script>
<table align="left" width="20%">

	<%
		UserBO userBO = (UserBO) session.getAttribute("userBO");
	if(userBO!=null){
	%>
	<tr>
		<td>Welcome <%=userBO.getName()%></td>
	</tr>
	<tr>
	<td><a href="modifyUserLink.htm" title="click here to update the account">Update Account</a></td>
	</tr>
</table>
<TABLE id=Table_01 border=0 cellSpacing=0 cellPadding=0 width=195 height=81 align="right">
	<TBODY>
		<TR>
			<TD rowSpan=3><IMG alt="" src="images/6_01.gif" width=14
				height=81></TD>
			<TD colSpan=4><IMG alt="" src="images/6_02.gif" width=181
				height=44></TD>
		</TR>
		<TR>
			<TD><IMG alt="" src="images/6_03.gif" width=78 height=24></TD>
			<TD><IMG alt="" src="images/6_04.gif" width=15 height=24></TD>
			<TD><IMG alt="" src="images/6_05.gif" width=77 height=24></TD>
			<TD rowSpan=2><IMG alt="" src="images/6_06.gif" width=11
				height=37></TD>
		</TR>
		<TR>
			<TD colSpan=3><IMG alt="" src="images/6_07.gif" width=170
				height=13></TD>
		</TR>
	</TBODY>
</TABLE>

<TABLE border=0 cellSpacing=2 cellPadding=0 width="100%" align=center>
	<TBODY>
		<TR>
			<TD bgColor=#fc9701 width="20%" align=middle><SPAN class=style2>STUDY
			ZONE </SPAN></TD>
			<TD vAlign=top background=images/btnbg.jpg width="80%">
			<TABLE border=0 cellSpacing=0 cellPadding=0 width="100%">
				<TBODY>
					<TR>
						<TD width=75 align=middle><A class=quicklink2 title=Home
							href="index.html">Home</A></TD>
						<TD width=3 align=middle><IMG alt="PALCO - Home"
							src="images/tab_div.jpg" width=3 height=32></TD>
						<TD width=105 align=middle><A class=quicklink2
							title="About Paras Lubricants Limited" href="subject_notes.html">Subject
						notes</A></TD>
						<TD width=3 align=middle><IMG alt=Profile
							src="images/tab_div.jpg" width=3 height=32></TD>
						<TD width=104 align=middle><A class=quicklink2 title=Products
							href="sample_paper.html">Sample papers</A></TD>
						<TD width=3 align=middle><IMG alt="Quality Policy"
							src="images/tab_div.jpg" width=3 height=32></TD>
						<TD width=115 align=middle><A class=quicklink2
							title="Paras Lubricants - Milestones" href="viewAllContents.htm">upload
						</A></TD>
						<TD width=3 align=middle><IMG alt=Milestones
							src="images/tab_div_002.jpg" width=3 height=32></TD>
						<TD width=115 align=middle><A class=quicklink2
							title="Events Happenings" href="forum.html">Forum </A></TD>
						<TD width=3 align=middle><IMG alt=Events
							src="images/tab_div_002.jpg" width=3 height=32></TD>
						<TD width=75 align=middle><A class=quicklink2
							title="Frequently Asked Questions" href="faq.html">FAQ</A></TD>
						<TD width=3 align=middle><IMG alt=FAQs
							src="images/tab_div_002.jpg" width=3 height=32></TD>
						<TD width=100 align=middle><A class=quicklink2
							title="Contact Us" href="contact_us.html">CONTACT US</A></TD>
					</TR>
				</TBODY>
			</TABLE>
			</TD>
		</TR>
	</TBODY>
</TABLE>
<%}else{
	response.sendRedirect("Logout.htm");
}
%>