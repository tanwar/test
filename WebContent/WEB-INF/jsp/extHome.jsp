
<%@page import="com.tanwar.classcourt.service.BoardService"%>
<%@page import="java.util.List"%>
<%@page import="com.tanwar.classcourt.bo.BoardBO"%><html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<link href="style.css" rel="stylesheet" type="text/css">
<link href="style2.css" rel="stylesheet" type="text/css">
<link href="class.css" rel="stylesheet" type="text/css">
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
<script type="text/javascript">
function redirectToLogin(){
	window.location = "AdminLogin.htm";
}

function redirectLoginOnBoardNavigation(){
	if(confirm("Please login to access the system")){
	window.location = "AdminLogin.htm";
	}
	else 
	return false;
}


</script>

</head>
<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0">
<!-- ImageReady Slices (Untitled-1) -->
<table width="987" height="705" border="0" align="center"
	cellpadding="0" cellspacing="0" bgcolor="#FFFFFF" id="Table_01">
	<tr>
		<td height="93" background="images/hadder.jpg">
		<table width="100%" border="0">
			<tr>
				<td width="7%">&nbsp;</td>
				<td width="73%" class="bigheading">Classcourt</td>
				<td width="20%">
				<table id="Table_01" width="195" height="81" border="0"
					cellpadding="0" cellspacing="0">
					<tr>
						<input type="button" name="Login" value="Login/New User"
							onclick="redirectToLogin();" />

					</tr>
				</table>
				</td>
			</tr>

		</table>
		</td>
	</tr>
	<tr>
		<td height="36" valign="top">
		<table width="100%" border="0" align="center" cellpadding="0"
			cellspacing="2">
			<tr>
				<td width="20%" align="center" bgcolor="#FC9701"><span
					class="style2">STUDY ZONE </span></td>
				<td width="80%" valign="top" background="images/btnbg.jpg">
				<table border="0" cellpadding="0" cellspacing="0" width="100%">
					<tbody>
						<tr>
							<td width="75" align="center"><a href="#"
								class="quicklink2" title="Home">Home</a></td>
							<td width="3" align="center"><img src="images/tab_div.jpg"
								alt="PALCO - Home" width="3" height="32" /></td>
							<td width="105" align="center"><a href="#"
								class="quicklink2" title="About Paras Lubricants Limited">Subject
							notes</a></td>
							<td width="3" align="center"><img src="images/tab_div.jpg"
								alt="Profile" width="3" height="32" /></td>
							<td width="104" align="center"><a href="#"
								class="quicklink2" title="Products"> Sample papers</a></td>
							<td width="3" align="center"><img src="images/tab_div.jpg"
								alt="Quality Policy" width="3" height="32" /></td>
							<td width="115" align="center"><a href="#"
								class="quicklink2" title="Paras Lubricants - Milestones">upload
							</a></td>
							<td width="3" align="center"><img
								src="images/tab_div_002.jpg" alt="Milestones" height="32"
								width="3" /></td>
							<td width="115" align="center"><a href="#"
								class="quicklink2" title="Events Happenings">Forum </a></td>
							<td width="3" align="center"><img
								src="images/tab_div_002.jpg" alt="Events" width="3" height="32" /></td>
							<td width="75" align="center"><a href="#"
								class="quicklink2" title="Frequently Asked Questions">FAQ</a></td>
							<td width="3" align="center"><img
								src="images/tab_div_002.jpg" alt="FAQs" width="3" height="32" /></td>
							<td width="100" align="center"><a href="#"
								class="quicklink2" title="Contact Us">CONTACT US</a></td>
						</tr>
					</tbody>
				</table>
				</td>
			</tr>
		</table>
		</td>
	</tr>

	<%	  List<BoardBO> boardListHome = (List<BoardBO>)session.getAttribute("boardListHome");
  System.out.println(boardListHome.size());
  for (BoardBO boardBO : boardListHome) {
  %>
	<tr>
		<td height="283" valign="top">
		<table width="98%" border="0" align="center" cellpadding="0"
			cellspacing="2">
			<tr>
				<td width="20%">
				<table width="83%" border="0" cellpadding="0" cellspacing="0">
					<tbody>
						<TR>
							<TD class="leftnav-a"><a name='osx' class='osx demo'
								style='cursor: hand; cusror: pointer;'
								onclick="javascript:redirectLoginOnBoardNavigation();"><%=boardBO.getBoardName()%></a></TD>
						</TR>
					</tbody>
				</table>
				 </td>
				<%} %>
				<td width="80%"><img src="images/banner-main.jpg" width="800"
					height="242"></td>
			</tr>
			<tr>
				<td height="600" valign="top"><img
					src="images/LN_Web_Ad_banner.gif" width="200" height="280"><br>
				<img src="images/topper_mycbseguide.gif" width="200" height="300"></td>
				<td valign="top">
				<table width="100%" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td width="79%">
						<ul>
							<li>
							<h5><a href="#" class="textbox">CBSE Class 10 Result
							Declared on 21 May 2012 (Chennai Region)</a></h5>
							</li>
							<li><span class="text">CBSE Class 10 Result Declared
							on 21 May 2012 for Chennai region. The result for other regions
							will be updated within next 1-2 days. http://cbseresults.nic.in
							&nbsp; Out of&nbsp;151,509 total students, 152,024 students who
							appeared for the CBSE Class 10 exams have qualified for admission
							to ...</span><a href="#" class="link">Read More</a></li>
						</ul>
						<hr>
						<ul>
							<li>
							<h5><a href="#" class="textbox">Class 10 and Class 12
							School Board Results</a></h5>
							</li>
							<li><span class="text">Many School Boards such as
							CBSE, ICSE, Tamilnadu school Board, Karnataka School Board,
							Rajasthan Board, Manipur school Board, Kerala board, UP Board has
							declared or in process to declare their school board results for
							class 10 and class 12 in the month of May 2012. CBSE Class 10
							Result is ...&nbsp;</span><a href="#" class="link">Read More</a></li>
						</ul>
						<hr>
						<ul>
							<li>
							<h5><a href="#" class="textbox">English speaking and
							listening skills to be Part of Formative Assessment</a></h5>
							</li>
							<li><span class="text">CBSE envisages that all
							language skills need to be integrated into the English language
							curriculum at schools. Speaking and listening should be fostered
							in children to equip them with better communication skills. At
							the onset it proposes to introduce formal testing of speaking and
							listening skills in the form of ...&nbsp;</span><a href="#" class="link">Read
							More</a></li>
						</ul>
						<hr>
						<ul>
							<li>
							<h5><a href="#" class="textbox">Medical Entrance Exam
							Schedule in AIIMS</a></h5>
							</li>
							<li><span class="text">AIIMS conducts Medical
							Entrance Exams for many undergraduate and post graduate courses
							in the campus of the institute. The list of examinations is
							provided below. The basic information regarding the programme
							details for admission to different programmes by the Institute
							are given in a tabular form. The same indicates the ...&nbsp;</span><a
								href="#" class="link">Read More</a></li>
						</ul>
						<hr>
						<br>
						</td>
						<td width="21%" align="right" valign="top"><img
							src="images/9678549544633680148.gif" width="160" height="600"></td>
					</tr>
				</table>
				</td>
			</tr>
		</table>
		</td>
	</tr>
	<tr>
		<td valign="top">&nbsp;</td>
	</tr>
</table>
<!-- End ImageReady Slices -->
</body>
</html>