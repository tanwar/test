<!-- <script type='text/javascript' src='./dwr/engine.js'> </script>
<script type='text/javascript' src='./dwr/util.js'> </script>
<script type='text/javascript' src='./dwr/interface/DWRService.js'> </script>
        <script lang="javascript">
            function getClassDetails(boardId, boardName){
               alert("boardid: "+boardId + "; boardname: "+boardName);
               dwr.util.removeAllOptions("classId");
               DWRService.getAllClassMap(boardId,function(classMap){
                   alert("function");
            	   alert(classMap);
                    dwr.util.addOptions("classId", classMap);
                });
            }
            
            function showClassDetails(){
            	alert(document.getElementById("classId").value);
            	
            	window.location= "./viewClassSubjects.htm?classId=" + document.getElementById("classId").value;
            }
</script>

<div id='content'>
		
		<div id="osx-modal-content">
			<div id="osx-modal-title">Select Class for board <label id="boardName"></label></div>
			<div class="close"><a href="#" class="simplemodal-close">x</a></div>
			<div id="osx-modal-data">
				<table>
					<tr>
						<td>Class: </td>
						<td><select name="classId" id="classId" onchange="javascript:showClassDetails();"></select>
						</td>
					</tr>
					<tr>
						<td colspan="2"><input type="button" value="Select Class" /></td>
					</tr>
				</table>
				
				<span>(or press ESC or click the overlay)</span>
			</div>
		</div>
	</div>
	 -->
	 
	 <%@include file="./includeClassList.jsp" %>	