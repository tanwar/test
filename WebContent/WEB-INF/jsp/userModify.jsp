<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="java.util.ArrayList"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.Map"%>

<%@page import="com.tanwar.classcourt.bo.UserBO"%><html>
<head>
<%
UserBO userBO = (UserBO) session.getAttribute("userBO");
String msg = (String)request.getAttribute("registerMsg")==null?"":(String)request.getAttribute("registerMsg");
String userId = Integer.toString(userBO.getUserId()); 
Map boardNameIdMap = (HashMap)request.getAttribute("boardNameIdMap");
Map classNameIdMap = (HashMap)request.getAttribute("classNameIdMap");
String sName = (String)request.getAttribute("name")==null?userBO.getName():request.getParameter("name");
String userName = (String)request.getAttribute("userName")==null?userBO.getUsername():request.getParameter("fullName");
String emailId = (String)request.getAttribute("emailId")==null?userBO.getEmailId():request.getParameter("emailId");
String phoneNo = (String)request.getAttribute("phoneNo")==null?userBO.getMobile():request.getParameter("phoneNo");
String Mobile = (String)request.getAttribute("Mobile")==null?userBO.getMobile():request.getParameter("mobile");
String userType = (String)request.getAttribute("userType")==null?userBO.getUserType():request.getParameter("userType");
String pass = (String)request.getAttribute("password")==null?"":"";
String confirmPass = (String)request.getAttribute("confirmPass")==null?"":(String)request.getAttribute("confirmPass");
String passDoesntMatch = (String)request.getAttribute("passwordDoesntMatch")==null?"":(String)request.getAttribute("passwordDoesntMatch");
String studentSelected = "";
String tutorSelected = "";
if("Student".equals(userType)){
	studentSelected = "selected";
}
else if("Tutor".equals(userType)){
	tutorSelected = "selected";
}
%>


<script type="text/javascript">

function populateClass(boardVal){
document.userModifyForm.boardId.value=boardVal;
document.userModifyForm.selectedValue.value=document.userModifyForm.boardNames.selectedIndex; 
document.userModifyForm.action.value="getClassNames";
document.userModifyForm.submit();
}

function retainComboValues(){
	var value1 =<%=request.getParameter("selectedValue")%>;  
    if(value1!=null)  
        {document.userModifyForm.boardNames.selectedIndex=value1;  
        //alert(value1);  
        }  
}

</script>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<link href="css/style.css" rel="stylesheet" type="text/css">
<link href="css/style2.css" rel="stylesheet" type="text/css">
<link href="css/class.css" rel="stylesheet" type="text/css">
</head>
<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" onload="retainComboValues()">
<form  name="userModifyForm" action="./modifyUserComplete.htm" method="POST">
<input type="hidden" name="action" value ="" />
<input type="hidden" name="boardId" value ="<%request.getParameter("boardId"); %>" />
<input type="hidden" name="userId" value ="<%=userId%>" />
<table width="987" height="756" border="0" align="center" cellpadding="0" cellspacing="0" bgcolor="#FFFFFF" id="Table_01">

	<h1><%=msg %></h1> 
	<h1><font color="red"><%=passDoesntMatch%></font></h1>
	<tr>
	  <td valign="top"><table width="98%" border="0" align="center" cellpadding="0" cellspacing="0">
        <tr>
          <td width="100%"><span class="ragistration">User Account Update</span></td>
        </tr>
        <tr>
          <td valign="top">
          <table width="100%" border="0" cellspacing="0" cellpadding="0">

            <tr>
              <td><span class="home-registration-label">Name<span class="textRed">*</span></span></td>
              <td><span class="mt-10 ml-10">
                <input name="name" autocomplete="off" class="grey" type="text" id="fullName" value="<%=sName%>">
              </span></td>
            </tr>

            <tr>
              <td><span class="home-registration-label">UserName<span class="textRed">*</span></span></td>
              <td><span class="mt-10 ml-10">
                <input name="fullName" autocomplete="off" class="grey" type="text" id="fullName" value="<%=userName%>">
              </span></td>
            </tr>
            <tr>
              <td>Email id* </td>
              <td><span class="mt-10 ml-10">
                <input name="emailId" autocomplete="off" class="grey" type="text" id="emailId" value="<%=emailId%>">
              </span></td>
            </tr>
            
             <tr>
              <td>Password* </td>
              <td><span class="mt-10 ml-10">
                <input name="password" autocomplete="off" class="grey" type="password" id="password" value="<%=pass%>">
              </span></td>
            </tr>
             <tr>
              <td>Confirm Password* </td>
              <td><span class="mt-10 ml-10">
                <input name="confirmPassword" autocomplete="off" class="grey" type="password" id="confirmPassword" value="<%=confirmPass%>">
              </span></td>
            </tr>

            <tr>
              <td><span class="home-registration-label">Board<span class="textRed">/ University*</span></span></td>
              <td><span class="mt-10 ml-10">
                <select name="boardNames" class="registration" onChange="populateClass(this.value)" id="boardNames">
                  <option value="Select Board">Select Board</option>
                  
                  
                 <%
                 if(boardNameIdMap!=null && !boardNameIdMap.isEmpty()){
                 Iterator<Map.Entry<ArrayList, ArrayList>> itr = boardNameIdMap.entrySet().iterator();
                 if (itr.hasNext()) {
                     Map.Entry<ArrayList, ArrayList> entry = itr.next();
                     System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());  
                 
                 for(int i=0; i<entry.getKey().size();i++){
                	 
                	 Integer value = (Integer) entry.getKey().get(i);
                	 String name = (String) entry.getValue().get(i);
                 
                	 
                 %>
                  <option value="<%=value%>"><%=name%></option>
                 <% }
                 }
                 }
                 %>
                
			
			
		
                </select>
                <input type="hidden" name="selectedValue" value ="0" />
              </span></td>
            </tr>
            <tr>
              <td><span class="home-registration-label">Class<span class="textRed">*</span></span></td>
              <td><span class="mt-10 ml-10">
                <select name="classNames" class="registration" id="classNames">
                  <option value="">Select Class</option>
                     <%  if(classNameIdMap!=null && !classNameIdMap.isEmpty()){
                 Iterator<Map.Entry<ArrayList, ArrayList>> itr1 = classNameIdMap.entrySet().iterator();
                     if (itr1.hasNext()) {
                     Map.Entry<ArrayList, ArrayList> entry = itr1.next();
                     System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());  
                 
                 for(int y=0; y<entry.getKey().size();y++){
                	 
                	 Integer value = (Integer) entry.getKey().get(y);
                	 String name = (String) entry.getValue().get(y);
                 
                	 
                 %>
                  <option value="<%=value%>"><%=name %></option>
                  <%}} }%>
                  
                </select>
              </span></td>
            </tr>
            <tr>
              <td><span class="home-registration-label">Mobile<span class="textRed">*</span></span></td>
              <td><span class="mt-10 ml-10">
                <input name="mobile" autocomplete="off" class="grey" maxlength="17" type="text" id="mobile" value="<%=Mobile%>">
              </span></td>
            </tr>
            <tr>
              <td> You are a </td>
              <td><div style="float:left;width:80px;">
                <input type="radio" name="userType"  value ="Student" id="userType" <%=studentSelected%> >
                <label for="userType" class="text11">Student</label>
                &nbsp;</div>
                <div style="float:left;width:80px;">
                  <input type="radio" name="userType" value="Tutor" id="userType" <%=tutorSelected%> >
                  <label for="userType" class="text11">Tutor</label>
                &nbsp;</div></td>
            </tr>
            <tr>
              <td><div class="field_holder termsCondBox">
                <div class="form_label4">
                  <input type="checkbox" name="terms_cond" id="terms_cond"  class="textfield1">
                  <span id="txt_terms_cond">I agree to terms and conditions</span> </div>
                <div class="clear"></div>
              </div></td>
              <td>&nbsp;</td>
            </tr>
            <tr>
              <td>&nbsp;</td>
              <td><input type="submit" value="Update Profile!"/></td>
            </tr>
          </table></td>
         </tr>
         </table>
         </td>
         </tr>
         </table>
</form>         
</body>
</html>