<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <%
        // 한글이 깨지지 않도록 처리
        request.setCharacterEncoding("utf-8");
    %>
    <%@ page import="sample.ApiExplorer" %>
    <%
    	String cnt = "14497"; 
    	ApiExplorer api = new ApiExplorer();
    	
    	int totalCount = 144497;
    
	    %>
    	<b><%=totalCount%>개의 WIFI 정보를 정상적으로 저장하였습니다.</b><br/>
	    <%
	%>
    

</body>
</html>