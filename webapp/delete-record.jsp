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
    
    	String lat = request.getParameter("col");
    	
    	SearchedWifis swf = new SearchedWifis();
    	swf.deleteRecord(Integer.parseInt(lat));
    %>

</body>
</html>