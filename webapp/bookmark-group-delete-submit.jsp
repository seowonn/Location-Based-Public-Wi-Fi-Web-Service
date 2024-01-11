<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<%@ page import="dao.BookMarkedGroups" %>
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
    		BookMarkedGroups bmg = new BookMarkedGroups();
	    	Boolean isdeleted = bmg.deleteBookMarkGroup(deleteId);
	    	
	    	if(isdeleted){ 
    %>

		    <script>    
		    	alert("북마크 그룹 정보를 삭제하였습니다.");
		    	location.href = "bookmark-group.jsp";
		    </script>
		    <%} else { %>
		    <script>    
		    	alert("북마크 그룹 정보를 삭제하지 못했습니다.");
		    	location.href = "bookmark-group.jsp";
		    </script>
		    <%} %>
		<%} %>

</body>
</html>