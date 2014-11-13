

<%@page import="com.tanwar.classcourt.bo.UserBO"%>

<table align="right" width="20%">

	<%
		UserBO userBO = (UserBO) session.getAttribute("userBO");
	%>
	<tr>
		<td>Welcome <%=userBO.getName()%></td>
	</tr>
</table>