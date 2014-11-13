<%@page import="com.tanwar.classcourt.bo.SubjectBO"%>
<%@page import="java.util.List"%>
<script lang="javascript">
      
            
            function activateTab(mainid, li_id, divid, tabid) {
                var mainDiv = document.getElementById(mainid);
                var li = document.getElementById(li_id);
                var tabDiv = document.getElementById(divid);
                var mainTab = document.getElementById(tabid);
         
                for (var i = 0; i < mainDiv.childNodes.length; i++) {
                    var node = mainDiv.childNodes[i];
                    if (node.nodeType == 1) {
                        node.style.background = (node == li) ? '#aaa' : 'white';
                    }
                }
                for (var i = 0; i < tabDiv.childNodes.length; i++) {
                    var node = tabDiv.childNodes[i];
                    if (node.nodeType == 1) {
                        node.style.display = (node == mainTab) ? 'block' : 'none';
                    }
                }
            }   
            
            

    hideTabContent();

</script>

<%@include file="./includeClassList.jsp" %>	

<%
List<SubjectBO> subjectBOList = (List<SubjectBO>)request.getAttribute("subjectBOList");
%>
<h2>Subjects:</h2>
	<div id="tabheader">
        <div id="tablist">
        <%
        for(SubjectBO subjectBO : subjectBOList){
        %>
            <div id="<%=subjectBO.getSubjectId()%>" style="background: #aaa"><a href="javascript:activateTab('tablist','<%=subjectBO.getSubjectId()%>','tabcontent','<%=subjectBO.getSubjectId()%>_tab')" title=""><%=subjectBO.getSubjectName()%></a></div>
        <%} %>
        </div>
    </div> <!-- End of tabheader -->
    <div id="tabcontent" class="maintab">
     <% boolean b = false;
        for(SubjectBO subjectBO : subjectBOList){
        %>
        <div id="<%=subjectBO.getSubjectId()%>_tab" <%if(!b){ %>style="display: block"<%}else{ %> style="display: none"<%} b= true; %>>
            <jsp:include page="./SubjectHome.jsp">
            <jsp:param name="subjectId" value="<%=subjectBO.getSubjectId()%>"/>
            <jsp:param name="subjectName" value="<%=subjectBO.getSubjectName()%>"/>
            </jsp:include>
        </div> 
        <%} %>
        
    </div> <!-- End of tabcontent -->
	
	
