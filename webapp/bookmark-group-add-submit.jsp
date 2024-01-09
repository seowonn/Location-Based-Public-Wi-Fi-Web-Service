<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>와이파이 정보 구하기</title>
	<script type="text/javascript" src="test.js"></script>
</head>
<body>
	<%
    	request.setCharacterEncoding("UTF-8");
    
    	String bookmarkName = request.getParameter("bookmarkName");
    	String order = request.getParameter("order");
    %>
    <script>    
    	alert("북마크 그룹 정보를 추가했습니다.");
    </script>
    <%=bookmarkName %>
    <%=order %>
    
    

</body>
</html>