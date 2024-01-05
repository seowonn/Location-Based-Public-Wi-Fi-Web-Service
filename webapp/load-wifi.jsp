<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="java.sql.*" %>
<%@ page import="DBConnection.ConnectDB" %>
    

<!DOCTYPE html>
<html>
<head>
	<link href="style.css" rel="stylesheet" type="text/css">
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
<%
    request.setCharacterEncoding("utf-8");

	Connection connection = null;
	Statement stmt = null;
	ResultSet rs = null;
	
	String countQuery = "SELECT COUNT(*) FROM SEOUL_WIFI;";
	
	try {
		connection = ConnectDB.connectDB();
		stmt = connection.createStatement();
		
		rs = stmt.executeQuery(countQuery);
  		
  		while(rs.next()) {
  		%>
  			<h2 style="text-align:center;"><%=Integer.parseInt(rs.getString(1))%>개의 WIFI 정보를 정상적으로 저장하였습니다.</h2>
  		<%
  		}
	} catch(SQLException ex) {
		out.println(ex.getMessage());
  		ex.printStackTrace();
  	} finally {
		ConnectDB.close(connection, stmt, rs);
  	}
%>

<div class="atag" style="text-align:center">
	<a href="index.jsp">홈 으로 가기</a>
</div> 

</body>
</html>