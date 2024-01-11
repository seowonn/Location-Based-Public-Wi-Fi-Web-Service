<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ page import="dao.BookMarkedGroups" %>
<html>
<head>
	<meta charset="UTF-8">
	<title>와이파이 정보 구하기</title>
	<script type="text/javascript" src="test.js"></script>
</head>
<body>
	<%
    	request.setCharacterEncoding("UTF-8");
    
    	String bookMarkName = request.getParameter("bookmarkName");
    	String order = request.getParameter("order");

    	BookMarkedGroups bmg = new BookMarkedGroups();
    	if(!bookMarkName.equals("") && !order.equals("")){
	    	Boolean isInserted = bmg.insertBookMarkGroup(bookMarkName, order);
	    	if(isInserted){
    %>
		    <script>    
		    	alert("북마크 그룹 정보를 추가했습니다.");
		    	location.href = "bookmark-group.jsp";
		    </script>
		    <%} else { %>
		    <script>    
		    	alert("북마크 그룹 정보를 추가하지 못했습니다.");
		    	location.href = "bookmark-group.jsp";
		    </script>
		    <%} %>
		<%} %>

</body>
</html>