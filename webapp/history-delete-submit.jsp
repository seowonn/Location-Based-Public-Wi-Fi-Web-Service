<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<%@ page import="Database.SearchedWifis" %>
<html>
<head>
	<meta charset="UTF-8">
	<title>와이파이 정보 구하기</title>
</head>
<body>

	<%
    	request.setCharacterEncoding("UTF-8");
    
    	String deleteId = request.getParameter("id");

    	if(!deleteId.equals("")){
    		SearchedWifis swf = new SearchedWifis();
	    	Boolean isdeleted = swf.deleteSearchedWifi(deleteId);
	    	
	    	if(isdeleted){ 
    %>

		    <script>    
		    	alert("위치 히스토리 정보를 삭제하였습니다.");
		    	location.href = "history.jsp";
		    </script>
		    <%} else { %>
		    <script>    
		    	alert("위치 히스토리 정보를 삭제하지 못했습니다.");
		    	location.href = "history.jsp";
		    </script>
		    <%} %>
		<%} %>

</body>
</html>