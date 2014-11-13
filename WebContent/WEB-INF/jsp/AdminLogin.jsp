
<%
	String msg = (String) request.getAttribute("loginMsg");
	msg = msg == null ? "" : msg;
	String msgRegisterSuccess = (String) request.getAttribute("registerMsg");
	msgRegisterSuccess = msgRegisterSuccess == null ? "" : msgRegisterSuccess;
%>

<a href="./RegisterUserScreen.htm">New User? Click here to register</a>

<form action="./ValidateUser.htm" method="POST">
<table align="center">
	<tr>
		<td colspan="2" valign="top" "center"><font color="green"><%=msgRegisterSuccess%></font></td>
	</tr><br></br>

	<tr>
		<td colspan="2" align="center"><%=msg%></td>
	</tr>
	<tr>
		<td>Username:</td>
		<td><input type="text" name="username" id="username" /></td>
	</tr>
	<tr>
		<td>Password:</td>
		<td><input type="password" name="password" id="password" /></td>
	</tr>
	<tr>
		<TD>You are a</TD>
		<TD><INPUT value="Student" type="radio" name="usertype"> Student<br />
		<INPUT value="Tutor" type="radio" name="usertype" />Tutor</TD>
	</tr>
	<tr>
		<td colspan="2" align="center"><input type="submit" value="Login" /></td>
	</tr>
</table>
</form>